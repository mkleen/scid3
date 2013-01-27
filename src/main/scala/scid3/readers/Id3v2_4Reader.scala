package scid3.readers

import java.io.InputStream
import scid3.{Id3Frame}
import scid3.util.ByteArrayTokenizer
import scid3.model.frames.FrameBody
import scid3.model.frames.FrameBodyType
import scid3.model.types.{ID3v2_4, ID3v2_2}
import scid3.model.results.{TagRestrictedExtendedData, Id3ExtendedData, Id3Header}
import scid3.util.StreamUtil._
import scid3.util.ByteUtil._

/* The Id3v2_4Reader reads all Id3tag data from a Id3 2.4  */

object Id3v2_4Reader extends Id3v2Reader {
	
	val ID_BYTE_SIZE =	4
	val VERSION 	=	ID3v2_4

	override protected def readFrame(in: InputStream): Option[Id3Frame] = {
		for(id <- readIdentifier(in))
		yield {
			val bodySize: Int 	= readSyncSafeInt(in)
			if (bodySize <= 0)	return None

			val flagBytes 		= readBytes(in, 2)
			val bodyData 		= readBytes(in, bodySize)
			val body 			= FrameBody(id, new ByteArrayTokenizer(bodyData))
			Id3Frame(version 	= ID3v2_4, body = body)
		}
	}

	override protected def readHeader(in: InputStream): Id3Header = {
		val flagsByte: Int 		= in.read
		val unsynchronization 	= bit(flagsByte.toByte, 7)
		val extended 			= bit(flagsByte.toByte, 6)
		val experimental 		= bit(flagsByte.toByte, 5)
	    val footerPresent		= bit(flagsByte.toByte, 4)

		val size = readSyncSafeInt(in)
		Id3Header(unsynchronization = unsynchronization, extended = extended, experimental = experimental, footerPresent = footerPresent, size = size)
	}

	override protected def readExtendedData(in: InputStream):  Option[Id3ExtendedData] = {

		val extendedHeaderSize = readSyncSafeInt(in)
		if (extendedHeaderSize <= 6) return None
		
		val flagBytes: Array[Byte] 	= readSizePrefixed(in)
		val updateTag: Boolean 		= bit(flagBytes(0), 6)
		val crcDataFlag: Boolean	= bit(flagBytes(0), 5)
		val tagRestriction: Boolean	= bit(flagBytes(0), 4)

		val updateTagBuffer = if (updateTag) Some(readSizePrefixed(in)) else None
		val crcData = if (crcDataFlag)	 Some(readCrCDataFlag(readSizePrefixed(in))) else None
		val tagRestrictedExtendedData = if (tagRestriction) Some(readTagRestrictedData(in)) else None

		Some(Id3ExtendedData(updateTag = updateTag, crcDataFlag = crcDataFlag, tagRestriction = tagRestriction,
			crcData = crcData,tagRestrictedExtendedData = tagRestrictedExtendedData))
	}

	private def readTagRestrictedData(in:InputStream): TagRestrictedExtendedData = {
		val tagRestrictionBuffer = readSizePrefixed(in)
		TagRestrictedExtendedData(
			tagSizeRestriction 			= Some(bits(tagRestrictionBuffer(0), 6, 2)),
			textEncodingRestriction		= bit(tagRestrictionBuffer(0), 5),
			textFieldSizeRestriction	= Some(bits(tagRestrictionBuffer(0), 3, 2)),
			imageEncodingRestriction	= bit(tagRestrictionBuffer(0), 2),
			imageSizeRestriction		= Some(bits(tagRestrictionBuffer(0), 0, 2))
		)
	}
}