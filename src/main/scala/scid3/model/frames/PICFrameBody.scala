package scid3.model.frames

import scid3.model.types.TextEncoding
import scid3.util.ByteArrayTokenizer

case class PICFrameBody (
	imageFormat: String,
	description: Option[String],
	pictureType: Long,
	pictureData: Array[Byte],
	textEncoding: Option[TextEncoding]
) extends FrameBody {
	val frameBodyType = FrameBodyType.PIC
}

object PICFrameBody {
	def apply(tok: ByteArrayTokenizer): PICFrameBody = {
		val textEncoding = TextEncoding(tok.next()) 
		val imageFormat = tok.simpleString()
		val pictureType = tok.takeNumber(3)
		val description = textEncoding.map { tok.textString } 
		val pictureData = tok.rest()
		PICFrameBody(imageFormat, description, pictureType, pictureData, textEncoding)
	}
}
