package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.{TextEncoding, ReceivedAs}

case class COMRFrameBody(
	price: String,
	validUntil: String,
	contactUrl: String,
	receivedAs: Option[ReceivedAs],
	nameOfSeller: Option[String],
	description: Option[String],
	pictureMimeType: String,
	sellerLogo: Array[Byte],
	textEncoding: Option[TextEncoding]) extends FrameBody {
	val frameBodyType = FrameBodyType.COMR
}

object COMRFrameBody {
	def apply(tok: ByteArrayTokenizer): COMRFrameBody = {

		val textEncoding = TextEncoding(tok.next()) 
		val price = tok.simpleString()
		val validUntil = tok.date()
		val contactUrl = tok.url()
		val receivedAs = ReceivedAs(tok.next()) 
		val nameOfSeller = textEncoding.map { t => tok.textString(t)}
		val description = textEncoding.map { t => tok.textString(t)}		
		val pictureMimeType = tok.mimeType()
		val sellerLogo = tok.rest()

		COMRFrameBody(price, validUntil, contactUrl, receivedAs, nameOfSeller, description, pictureMimeType, sellerLogo, textEncoding)
	}
}