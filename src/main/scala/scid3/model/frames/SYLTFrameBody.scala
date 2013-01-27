package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import collection.mutable.ListBuffer
import scid3.model.types._

case class SYLTFrameBody(
	description: Option[String],
	language: String,
	timeStampFormat: Option[TimeStampFormat],
	contentType: Option[ContentType],
	textEncoding: Option[TextEncoding],
	syncs: Seq[Sync]) extends FrameBody {
	val frameBodyType = FrameBodyType.SYLT
}

object SYLTFrameBody {
	def apply(tok: ByteArrayTokenizer): SYLTFrameBody = {
		val textEncoding = TextEncoding(tok.next) 
		val language = tok.language
		val timeStampFormat = TimeStampFormat.buildById(tok.next()) 
		val contentType = ContentType(tok.next()) 
		val description = textEncoding.map { tok.textString }
		
		val syncs = new ListBuffer[Sync]

		while (!tok.finished()) {
			val syllable = textEncoding.map { tok.textString } 
			val timeStamp = tok.takeNumber(4)
			syncs += Sync(syllable, timeStamp)
		}
		return SYLTFrameBody(description, language, timeStampFormat, contentType, textEncoding, syncs)
	}
}