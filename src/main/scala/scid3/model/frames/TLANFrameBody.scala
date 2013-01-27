package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.TextEncoding

case class TLANFrameBody(
	textEncoding: Option[TextEncoding],
	language: String) extends FrameBody {
	val frameBodyType = FrameBodyType.TLAN
}

object TLANFrameBody {
	def apply(tok: ByteArrayTokenizer): TLANFrameBody = {
		val textEncoding = TextEncoding(tok.next()) 
		val language = tok.language
		return TLANFrameBody(textEncoding, language)
	}
}