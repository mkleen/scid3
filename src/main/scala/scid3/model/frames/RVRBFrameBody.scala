package scid3.model.frames

import scid3.util.ByteArrayTokenizer


case class RVRBFrameBody(
	reverbLeft: Long,
	reverbRight: Long,
	reverbBouncesLeft: Long,
	reverbBouncesRight: Long,
	reverbFeedbackLeftToLeft: Long,
	reverbFeedbackLeftToRight: Long,
	reverbFeedbackRightToRight: Long,
	reverbFeedbackRightToLeft: Long,
	premixLeftToRight: Long,
	premixRightToLeft: Long) extends FrameBody {
	val frameBodyType = FrameBodyType.RVRB
}

object RVRBFrameBody {
	def apply(tok: ByteArrayTokenizer): RVRBFrameBody = {

		val reverbLeft = tok.takeNumber(2)
		val reverbRight = tok.takeNumber(2)
		val reverbBouncesLeft = tok.takeNumber(1)
		val reverbBouncesRight = tok.takeNumber(2)
		val reverbFeedbackLeftToLeft = tok.takeNumber(1)
		val reverbFeedbackLeftToRight = tok.takeNumber(1)
		val reverbFeedbackRightToRight = tok.takeNumber(1)
		val reverbFeedbackRightToLeft = tok.takeNumber(1)
		val premixLeftToRight = tok.takeNumber(1)
		val premixRightToLeft = tok.takeNumber(1)

		RVRBFrameBody(reverbLeft, reverbRight,reverbBouncesLeft, reverbBouncesRight,
					reverbFeedbackLeftToLeft, reverbFeedbackLeftToRight,
					reverbFeedbackRightToRight, reverbFeedbackRightToLeft,
					premixLeftToRight, premixRightToLeft)
	}
}