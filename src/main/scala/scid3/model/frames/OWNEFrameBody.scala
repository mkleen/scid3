package scid3.model.frames

import scid3.model.types.{TextEncoding}
import scid3.util.ByteArrayTokenizer

case class OWNEFrameBody(
	pricePaid: String,
	dateOfPurchase: String,
	seller: Option[String],
	textEncoding: Option[TextEncoding]) extends FrameBody {
	val frameBodyType = FrameBodyType.OWNE
}

object OWNEFrameBody {
	def apply(tok: ByteArrayTokenizer): OWNEFrameBody = {

		val textEncoding = TextEncoding(tok.next()) 
		val pricePaid = tok.simpleString()
		val dateOfPurchase = tok.date()
		val seller = textEncoding.map { tok.textString }

		OWNEFrameBody(pricePaid, dateOfPurchase, seller, textEncoding)
	}
}