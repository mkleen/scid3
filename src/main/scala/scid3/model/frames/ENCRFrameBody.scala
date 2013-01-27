package scid3.model.frames

import scid3.util.ByteArrayTokenizer

case class ENCRFrameBody(
	owner: String,
	methodSymbol: Byte,
	encryptionData: Array[Byte]) extends FrameBody {
	val frameBodyType = FrameBodyType.ENCR
}

object ENCRFrameBody {
	def apply(tok: ByteArrayTokenizer): ENCRFrameBody = {
		val owner = tok.owner()
		val methodSymbol = tok.next()
		val encryptionData = tok.rest()
		
		ENCRFrameBody(owner, methodSymbol, encryptionData)
	}
}
