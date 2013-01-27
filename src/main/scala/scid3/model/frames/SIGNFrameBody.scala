package scid3.model.frames

import scid3.util.ByteArrayTokenizer


case class SIGNFrameBody(
	groupSymbol: Byte,
	signature: Array[Byte]) extends FrameBody {
	val frameBodyType = FrameBodyType.SIGN
}

object SIGNFrameBody {
	def apply(tok: ByteArrayTokenizer): SIGNFrameBody = {
		val groupSymbol = tok.next
		val signature = tok.rest
		SIGNFrameBody(groupSymbol, signature)
	}
}
