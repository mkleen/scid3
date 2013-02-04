package scid3.readers

import java.io.InputStream
import scid3.model.results.{Id3ExtendedData, Id3Header}
import scid3.util.ByteArrayTokenizer
import scid3.model.frames.FrameBody
import scid3.model.frames.FrameBodyType
import scid3.{Id3Frame}
import scid3.model.types.{ID3v2_2, ID3v2_3}
import scid3.util.StreamUtil._
import scid3.util.ByteUtil._

/* The  Id3v2_3Reader reads all Id3tag data from a Id3 2.3  */

object Id3v2_3Reader extends Id3v2Reader {

	val ID_BYTE_SIZE 	=	4
	val VERSION =	ID3v2_3

	override protected def readFrame(in: InputStream): Option[Id3Frame] = {
		for{id			<- readIdentifier(in)
			bodySize	<- readBodySize(in)}
		yield {
			val flagBytes: Array[Byte] = readBytes(in, 2)
			val bodyData: Array[Byte]  = readBytes(in, bodySize)
			val body = FrameBody(id, new ByteArrayTokenizer(bodyData))
			Id3Frame(version = VERSION, body = body)
		}
	}

	override protected def readHeader(in: InputStream): Id3Header = {
		val flagsByte: Byte = readByte(in)
		val unsynchronization = bit(flagsByte, 7)
		val extended = bit(flagsByte, 6)
		val experimental = bit(flagsByte, 5)
		val size = readSyncSafeInt(in)
		Id3Header(unsynchronization = unsynchronization, experimental = experimental, extended = extended, size = size)
	}

	override protected def readExtendedData(in: InputStream): Option[Id3ExtendedData]  = {
		val extendedHeaderSize: Int = readSyncSafeInt(in)
		if (extendedHeaderSize != 6 && extendedHeaderSize != 10) return None
		val flagBytes = readBytes(in, 2)
		Some(Id3ExtendedData())
	}

	private def readBodySize(in: InputStream): Option[Int] = {
		// TODO check other uses of readSyncSafeInt outside of ID3v2_4
		// NOTE was readSyncSafeInt
		// http://www.id3.org/id3v2.3.0#head-1a37d4a15deafc294208ccfde950f77e47000bca
		// and chapter 4 of http://www.id3.org/id3v2.4.0-structure
		val bodySize: Int = readUnsafeInt(in)
		if (bodySize <= 0) None else Some(bodySize)
	}
}
