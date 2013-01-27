package scid3.model.frames

import scid3.util.ByteArrayTokenizer


case class LINKFrameBody(
	frameIdentifier: String,
	url: String, idAndAdditionalData:
	Seq[String]) extends FrameBody {
	val frameBodyType = FrameBodyType.LINK
}

object LINKFrameBody {
	def apply(tok: ByteArrayTokenizer): LINKFrameBody = {
		val frameIdentifier = tok.frameIdentifier()
		val url = tok.url()
		val idAndAdditionalData = tok.simpleStrings()
		 LINKFrameBody(frameIdentifier, url, idAndAdditionalData)
	}
}