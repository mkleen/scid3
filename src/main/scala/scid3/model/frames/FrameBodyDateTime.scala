package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.TextEncoding
import scid3.model.frames.FrameBodyType._


trait FrameBodyDateTime extends FrameBodyTextInformation {
	val dateTime: String
}

object TDENFrameBody {
	def apply(tok: ByteArrayTokenizer): TDENFrameBody = {

		val textEncoding = TextEncoding(tok.next())
		val text = textEncoding.toList.flatMap { tok.textStrings }
		val dateTime = text.head
		// TODO Parse DateTime
		// dateTime	   = text.isEmpty() ? null : text.get(0).replace(' ', 'T');
		return new TDENFrameBody(text, dateTime, textEncoding)
	}
}

case class TDENFrameBody(
	text: Seq[String],
	dateTime: String,
	textEncoding: Option[TextEncoding]) extends FrameBodyDateTime {
	val frameBodyType = TDEN
}

object TDORFrameBody {
	def apply(tok: ByteArrayTokenizer): TDORFrameBody = {

		val textEncoding = TextEncoding(tok.next())
		val text = textEncoding.toList.flatMap { tok.textStrings }
		val dateTime = text.head
		// TODO Parse DateTime
		// dateTime	   = text.isEmpty() ? null : text.get(0).replace(' ', 'T');
		return new TDORFrameBody(text, dateTime, textEncoding)
	}
}

case class TDORFrameBody(
	text: Seq[String],
	dateTime: String,
	textEncoding: Option[TextEncoding]) extends FrameBodyDateTime {
	val frameBodyType = TDOR
}

object TDRCFrameBody {
	def apply(tok: ByteArrayTokenizer): TDRCFrameBody = {

		val textEncoding = TextEncoding(tok.next())
		val text = textEncoding.toList.flatMap { tok.textStrings }
		val dateTime = text.head
		// TODO Parse DateTime
		// dateTime	   = text.isEmpty() ? null : text.get(0).replace(' ', 'T');
		return new TDRCFrameBody(text, dateTime, textEncoding)
	}
}

case class TDRCFrameBody(
	text: Seq[String],
	dateTime: String,
	textEncoding: Option[TextEncoding]) extends FrameBodyDateTime {
	val frameBodyType = TDRC
}

object TDRLFrameBody {
	def apply(tok: ByteArrayTokenizer): TDRLFrameBody = {

		val textEncoding = TextEncoding(tok.next())
		val text = textEncoding.toList.flatMap { tok.textStrings }
		val dateTime = text.head
		// TODO Parse DateTime
		// dateTime	   = text.isEmpty() ? null : text.get(0).replace(' ', 'T');
		return new TDRLFrameBody(text, dateTime, textEncoding)
	}
}

case class TDRLFrameBody(
	text: Seq[String],
	dateTime: String,
	textEncoding: Option[TextEncoding]) extends FrameBodyDateTime {
	val frameBodyType = TDRL
}

object TDTGFrameBody {
	def apply(tok: ByteArrayTokenizer): TDTGFrameBody = {

		val textEncoding = TextEncoding(tok.next()) 
		val text = textEncoding.toList.flatMap { tok.textStrings }
		val dateTime = text.head
		// TODO Parse DateTime
		// dateTime	   = text.isEmpty() ? null : text.get(0).replace(' ', 'T');
		return new TDTGFrameBody(text, dateTime, textEncoding)
	}
}

case class TDTGFrameBody(
		text: Seq[String],
		dateTime: String,
		textEncoding: Option[TextEncoding]) extends FrameBodyDateTime {
	val frameBodyType = TDTG
}