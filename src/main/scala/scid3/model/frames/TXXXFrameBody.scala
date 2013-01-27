package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.TextEncoding

case class TXXXFrameBody(
	textEncoding: Option[TextEncoding],
	description: Option[String],
	text: Option[String]
	) extends FrameBody {
	val frameBodyType = FrameBodyType.TXXX
}

object TXXXFrameBody {
	def apply(tok: ByteArrayTokenizer): TXXXFrameBody = {
		val textEncoding = TextEncoding(tok.next()) 
		val description = textEncoding.map { tok.textString } 
		val text = textEncoding.map { tok.textString } 
		return TXXXFrameBody(textEncoding, description, text)
	}
}