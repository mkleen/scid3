package scid3.model.frames

import scid3.util.ByteArrayTokenizer

case class AENCFrameBody(
	owner: String,
	previewStart: Long,
	previewLength: Long,
	encryptionInfo: Array[Byte]) extends FrameBody {
	val frameBodyType = FrameBodyType.AENC
}

object AENCFrameBody {
	def apply(tok: ByteArrayTokenizer): AENCFrameBody = {
		val owner = tok.owner()
		val previewStart = tok.takeNumber(2)
		val previewLength = tok.takeNumber(2)
		val encryptionInfo = tok.rest()
		AENCFrameBody(owner, previewStart, previewLength, encryptionInfo)
	}
}