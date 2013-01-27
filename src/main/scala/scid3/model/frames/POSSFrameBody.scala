package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.{TimeStampFormat, TextEncoding}


case class POSSFrameBody(
	timeStampFormat: Option[TimeStampFormat],
	position: Long) extends FrameBody {
	val frameBodyType = FrameBodyType.POSS
}

object POSSFrameBody {
	def apply(tok: ByteArrayTokenizer): POSSFrameBody = {
		val timeStampFormat = TimeStampFormat.buildById(tok.next()) 
		val position = tok.restNumber(1)
		POSSFrameBody(timeStampFormat, position)
	}
}