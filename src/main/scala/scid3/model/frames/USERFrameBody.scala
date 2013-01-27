package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.TextEncoding


case class USERFrameBody(
	textEncoding: Option[TextEncoding],
	language: String,
	text: Option[String]) extends FrameBody {
	val frameBodyType = FrameBodyType.USER
}

object USERFrameBody {
	def apply(tok: ByteArrayTokenizer): USERFrameBody = {
		val textEncoding = TextEncoding(tok.next()) 
		val language =tok.language()
		val text = textEncoding.map { tok.textString }
		USERFrameBody(textEncoding, language, text)
	}
}