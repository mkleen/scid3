package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.TextEncoding

case class COMMFrameBody(
	language: String,
	contentDesc: Option[String],
	description: Option[String],
	textEncoding: Option[TextEncoding]) extends FrameBody {
	val frameBodyType = FrameBodyType.COMM
}

object COMMFrameBody {
	def apply(tok: ByteArrayTokenizer): COMMFrameBody = {
	    
		val textEncoding = TextEncoding(tok.next())
		val language = tok.language()
		val contentDesc = textEncoding.map { tok.textString } 
		val description = textEncoding.map { tok.textString } 
			
		COMMFrameBody(language, contentDesc, description, textEncoding)
	}
}