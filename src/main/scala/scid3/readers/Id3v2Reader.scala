package scid3.readers

import java.io.InputStream
import scid3.model.types.Version
import scid3.{Id3Frame}
import scid3.model.results.{Id3Result, Id3ExtendedData, Id3Header}
import scid3.model.frames.FrameIdentifiers._
import scid3.model.frames.FrameBody
import scid3.model.frames.FrameBodyType
import annotation.tailrec
import scid3.util.Constants._
import scid3.util.StreamUtil._

/** This trait reads Id3v2 tags from a given Inputstream */ 

trait Id3v2Reader {

	val ID_BYTE_SIZE: Int
	val VERSION: Version

	final def read(in: InputStream): Id3Result = {
		val header = readHeader(in)
		val body = readBody(in)
		val extendedData	= if (header.extended) readExtendedData(in) else None
		Id3Result(VERSION, header, body, extendedData)
	}

	private final def readBody(in: InputStream): Seq[Id3Frame] = {
		@tailrec 
		def rec(previous:List[Id3Frame]): List[Id3Frame] = readFrame(in:InputStream) match {
		  case Some(frame) => rec(frame :: previous)
			case None	=> previous
		}
		rec(Nil).reverse
	}

	protected final def readCrCDataFlag(crcDataBuffer: Array[Byte]): Int = {
		crcDataBuffer.foldLeft(0)((result, byte) => (result << 7) | (byte & 0x7f))
	}

	protected def readIdentifier(in: InputStream): Option[FrameBodyType.Value] = {
		val buffer = readBytes(in, ID_BYTE_SIZE)
		val id = new String(buffer, ENCODING)
		buildFrameIdentifier(id)
	}

	protected def readFrame(in: InputStream): Option[Id3Frame]

	protected def readHeader(in: InputStream): Id3Header

	protected def readExtendedData(in: InputStream): Option[Id3ExtendedData]
}