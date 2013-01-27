package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.TextEncoding

case class WXXXFrameBody(
	urlLink: String,
	description: Option[String],	
	textEncoding: Option[TextEncoding]) extends FrameBody {
	val frameBodyType = FrameBodyType.WXXX
}
object WXXXFrameBody {
	def apply(tok: ByteArrayTokenizer): WXXXFrameBody = {
		val textEncoding = TextEncoding(tok.next()) 
		val description = textEncoding.map { tok.textString }
		val urlLink = tok.url()
		WXXXFrameBody(urlLink, description, textEncoding)
	}
}