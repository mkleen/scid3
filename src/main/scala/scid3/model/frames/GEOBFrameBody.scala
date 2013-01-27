package scid3.model.frames

import scid3.model.types.{TextEncoding}
import scid3.util.ByteArrayTokenizer

case class GEOBFrameBody(
	filename: Option[String],
	mimeType: String,
	description: Option[String],
	textEncoding: Option[TextEncoding],
	encapsulatedObject: Array[Byte]) extends FrameBody {
	val frameBodyType = FrameBodyType.GEOB
}

object GEOBFrameBody {
	def apply(tok: ByteArrayTokenizer): GEOBFrameBody = {
		
		val textEncoding = TextEncoding(tok.next()) 
		val mimeType = tok.mimeType()
		val filename = textEncoding.map { tok.textString }
		val description = textEncoding.map { tok.textString }
		val encapsulatedObject = tok.rest()

		GEOBFrameBody(filename, mimeType, description, textEncoding, encapsulatedObject)
	}
}
