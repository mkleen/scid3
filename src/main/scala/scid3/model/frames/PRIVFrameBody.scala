package scid3.model.frames

import scid3.util.ByteArrayTokenizer

case class PRIVFrameBody(owner: String,
						 privateData: Array[Byte]) extends FrameBody {
	val frameBodyType = FrameBodyType.PRIV
}
object PRIVFrameBody {
	def apply(tok: ByteArrayTokenizer): PRIVFrameBody = {
		val owner = tok.owner()
		val privateData = tok.rest()
		new PRIVFrameBody(owner, privateData)
	}
}