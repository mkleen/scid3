package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.TextEncoding

case class USLTFrameBody(
	textEncoding: Option[TextEncoding],
	language: String,
	contentDesc: Option[String],
	lyricsOrText: Option[String]) extends FrameBody {
	val frameBodyType = FrameBodyType.USLT
}

object USLTFrameBody {
	def apply(tok: ByteArrayTokenizer): USLTFrameBody = {
		val textEncoding = TextEncoding(tok.next()) 
		val language = tok.language()
		val contentDesc =  textEncoding.map { tok.textString }
		val lyricsOrText = textEncoding.map { tok.textString }
		USLTFrameBody(textEncoding, language, contentDesc, lyricsOrText)
	}
}