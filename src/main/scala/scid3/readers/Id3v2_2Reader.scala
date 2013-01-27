package scid3.readers

import java.io.InputStream
import scid3.model.results.{Id3ExtendedData, Id3Header}
import scid3.{Id3Frame}
import scid3.util.ByteArrayTokenizer
import scid3.model.frames.FrameBody
import scid3.model.frames.FrameBodyType
import scid3.model.frames.FrameIdentifiers._
import scid3.model.types.ID3v2_2
import scid3.util.Constants._
import scid3.util.StreamUtil._
import scid3.util.ByteUtil._

/* The  Id3v2_2Reader reads all Id3tag data from a Id3 2.2  */

object Id3v2_2Reader extends Id3v2Reader {

	val ID_BYTE_SIZE	=	3
	val VERSION 		=	ID3v2_2

	override protected def readFrame(in: InputStream): Option[Id3Frame] = {
		for{id			<- readIdentifier(in)
			bodySize	<- readBodySize(in)}
		yield {
			val bodyData: Array[Byte] 	=	readBytes(in, bodySize)
			val body					=	FrameBody(id, new ByteArrayTokenizer(bodyData))
			Id3Frame(version = VERSION, body = body)
		}
	}

	override protected def readHeader(in: InputStream): Id3Header = {
		val flagsByte: Byte 		=	readByte(in)
		val unsynchronization 		=	bit(flagsByte, 7)
		val compression 			=	bit(flagsByte, 6)
		val size 					=	readSyncSafeInt(in: InputStream)
		Id3Header(compression = compression, unsynchronization = unsynchronization, size = size)
	}
	
	override protected def readIdentifier(in: InputStream): Option[FrameBodyType.Value] = {
		val buffer 	= readBytes(in, ID_BYTE_SIZE)
		val id 		= new String(buffer, ENCODING)
		convertFramID322(id) match {
			case Some(id)	=> buildFrameIdentifier(id)
			case None		=> None 
		}
	}

	private def readBodySize(in: InputStream): Option[Int] = {
		val bodySize = readSmallInt(in)
		if (bodySize <= 0) None else Some(bodySize)
	}
	
	override protected def readExtendedData(in: InputStream): Option[Id3ExtendedData]  = None
}