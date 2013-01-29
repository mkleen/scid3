package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.TextEncoding

object TALBFrameBody {
	def apply(tok: ByteArrayTokenizer): TALBFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return TALBFrameBody(tuple._1, tuple._2)
	}
}

case class TALBFrameBody(
	text: Seq[String],
	textEncoding: Option[TextEncoding]) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TALB
}