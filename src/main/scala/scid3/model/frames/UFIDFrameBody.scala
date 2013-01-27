package scid3.model.frames

import scid3.util.ByteArrayTokenizer

case class UFIDFrameBody(
	owner: String,
	identifier: Array[Byte]) extends FrameBody {
	val frameBodyType = FrameBodyType.UFID
}

object UFIDFrameBody {
	def apply(tok: ByteArrayTokenizer): UFIDFrameBody = {
		val owner = tok.owner
		val identifier = tok.rest()
		UFIDFrameBody(owner, identifier)
	}
}