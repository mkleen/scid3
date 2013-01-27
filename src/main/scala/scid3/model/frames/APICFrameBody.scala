package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.{PictureType, TextEncoding}

case class APICFrameBody(
	mimeType: String,
	textEncoding: Option[TextEncoding],
	pictureType: Option[PictureType],
	description: Option[String],
	pictureData: Array[Byte]) extends FrameBody {
	val frameBodyType = FrameBodyType.APIC
}

object APICFrameBody {
	def apply(tok: ByteArrayTokenizer): APICFrameBody = {
		val textEncoding = TextEncoding(tok.next()) 
		val mimeType = tok.simpleString
		val pictureType = PictureType(tok.next()) 
		val description = textEncoding.map { tok.textString } 
		val pictureData = tok.rest()
		APICFrameBody(mimeType, textEncoding, pictureType, description, pictureData)
	}
}

object APICID3V22FrameBody {
	def apply(tok: ByteArrayTokenizer): APICFrameBody = {
		val textEncoding = TextEncoding(tok.next()) 
		val mimeType = tok.fixedString(3)
		val pictureType = PictureType(tok.next()) 
		val description = textEncoding.map { tok.textString } 
		val pictureData = tok.rest()
		APICFrameBody(mimeType, textEncoding, pictureType, description, pictureData)
	}
}
