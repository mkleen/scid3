package scid3.model.frames

import scid3.util.{ByteUtil, ByteArrayTokenizer}

case class RBUFFrameBody(
	bufferSize: Long,
	embeddedInfoFlag: Boolean,
	offsetToNextTag: Long) extends FrameBody {
	val frameBodyType = FrameBodyType.RBUF
}

object RBUFFrameBody {
	def apply(tok: ByteArrayTokenizer): RBUFFrameBody = {
		val bufferSize = tok.takeNumber(3)
		val embeddedInfoFlag = ByteUtil.bit(tok.next(), 1)
		val offsetToNextTag = tok.takeNumber(4)

		RBUFFrameBody(bufferSize, embeddedInfoFlag, offsetToNextTag)
	}
}