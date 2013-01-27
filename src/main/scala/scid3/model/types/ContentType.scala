package scid3.model.types

object ContentType {
	val values = Set(OtherContentType, Lyrics, TextTranscription, Movement, Events, Chords, Trivia, PageUrl, ImageUrl)

	def apply(id: Byte): Option[ContentType] = {
		values.find(x => x.id == id)
	}
}

sealed abstract class ContentType(val id: Byte,val description: String)
case object OtherContentType extends ContentType(0x00, "other")
case object Lyrics extends ContentType(0x01, "lyrics")
case object TextTranscription extends ContentType(0x02, "text transcription")
case object Movement extends ContentType(0x03, "movement/part name")
case object Events extends ContentType(0x04, "events")
case object Chords extends ContentType(0x05, "chord")
case object Trivia extends ContentType(0x06, "trivia/'pop up' information")
case object PageUrl extends ContentType(0x07, "URLs to webpages")
case object ImageUrl extends ContentType(0x08, "URLs to images")


