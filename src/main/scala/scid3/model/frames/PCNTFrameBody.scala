package scid3.model.frames

import scid3.util.ByteArrayTokenizer

case class PCNTFrameBody(counter: Long) extends FrameBody {
	val frameBodyType = FrameBodyType.PCNT
}

object PCNTFrameBody {
	def apply(tok: ByteArrayTokenizer): PCNTFrameBody = {
		val counter = tok.restNumber(4)
		return new PCNTFrameBody(counter)
	}
}