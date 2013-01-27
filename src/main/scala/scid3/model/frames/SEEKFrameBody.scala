package scid3.model.frames

import scid3.util.ByteArrayTokenizer


case class SEEKFrameBody(minimumOffsetToNextTag: Long) extends FrameBody {
	val frameBodyType = FrameBodyType.SEEK
}

object SEEKFrameBody {
	def apply(tok: ByteArrayTokenizer): SEEKFrameBody = {
		val minimumOffsetToNextTag = tok.takeNumber(4)
		SEEKFrameBody(minimumOffsetToNextTag)
	}
}