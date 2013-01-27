package scid3.model.frames

import scid3.util.ByteArrayTokenizer

case class POPMFrameBody(
	emailToUser: String,
	rating: Byte,
	counter: Long) extends FrameBody {
	val frameBodyType = FrameBodyType.POPM
}

object POPMFrameBody {
	def apply(tok: ByteArrayTokenizer): POPMFrameBody = {
		val emailToUser = tok.email()
		val rating = tok.next()
		val counter = tok.restNumber(1)
		POPMFrameBody(emailToUser, rating, counter)
	}
}