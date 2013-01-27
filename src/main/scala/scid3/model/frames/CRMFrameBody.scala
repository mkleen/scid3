package scid3.model.frames

import scid3.util.ByteArrayTokenizer

case class CRMFrameBody(
	owner: String,
	description: String,
	encryptedDataBlock: Array[Byte]) extends FrameBody {
	val frameBodyType = FrameBodyType.CRM
}

object CRMFrameBody {
	def apply(tok: ByteArrayTokenizer): CRMFrameBody = {
		val owner = tok.owner()
		val description = tok.simpleString()
		val encryptedDataBlock = tok.rest()
		new CRMFrameBody(owner, description, encryptedDataBlock)
	}
}