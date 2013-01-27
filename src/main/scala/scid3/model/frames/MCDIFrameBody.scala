package scid3.model.frames

import scid3.util.ByteArrayTokenizer

case class MCDIFrameBody(cdTableOfContents: Array[Byte]) extends FrameBody {
	val frameBodyType = FrameBodyType.MCDI
}

object MCDIFrameBody {
	def apply(tok:ByteArrayTokenizer): MCDIFrameBody = {
		val cdTableOfContents = tok.rest()
		MCDIFrameBody(cdTableOfContents)
	}
}