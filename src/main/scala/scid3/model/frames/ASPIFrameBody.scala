package scid3.model.frames

import scid3.util.ByteArrayTokenizer

case class ASPIFrameBody(
	fraction: Array[Long],
	bitsPerPoint: Long,
	dataLength: Long,
	dataStart: Long,
	indexPoints: Long) extends FrameBody {
	val frameBodyType = FrameBodyType.ASPI
}

object ASPIFrameBody {
	def apply(tok: ByteArrayTokenizer): ASPIFrameBody = {

		val dataStart		= tok takeNumber (4)
		val dataLength		= tok takeNumber (4)
		val indexPoints		= tok takeNumber (2)
		val bitsPerPoint	= tok takeNumber (1)

		val fraction = new Array[Long](indexPoints.toInt)

		fraction foreach (x => if (bitsPerPoint == 8) tok.takeNumber(1)
								else if (bitsPerPoint == 16) tok.takeNumber(2)
								else throw new IllegalArgumentException("ASPI bits per point wasn't 8 or 16"))
		
		ASPIFrameBody(fraction, bitsPerPoint, dataLength, dataStart, indexPoints)
	}
}

