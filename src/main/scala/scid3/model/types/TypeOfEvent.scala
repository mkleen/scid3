package scid3.model.types

object TypeOfEvent {
	val values = Set(Padding, EndOfSilence, IntroStart, MainPartStart, OutroStart, OutroEnd, VerseStart,
		VerseEnd, RefrainStart, RefrainEnd, InterludeStart, ThemeStart, VariationStart, KeyChange,
		TimeChange, MomentaryNoise, SustainedNoize, sustainedNoizeEnd, IntroEnd, MainPartEnd, VerseEnd
		, RefrainEnd, ThemeEnd, Profanity, ProfanityEnd, StartOfSilence, AudioFileEnds)

	def apply(id: Byte): Option[TypeOfEvent] = {
		values.find( it => it.id == id)
	}
}

sealed abstract class TypeOfEvent(val id: Byte,val description: String)
case object Padding extends TypeOfEvent(0x00, "Padding (has no meaning)")
case object EndOfSilence extends TypeOfEvent(0x01, "End of initial silence")
case object IntroStart extends TypeOfEvent(0x02, "Intro start")
case object MainPartStart extends TypeOfEvent(0x03, "Main part start")
case object OutroStart extends TypeOfEvent(0x04, "Outro start")
case object OutroEnd extends TypeOfEvent(0x05, "Outro end")
case object VerseStart extends TypeOfEvent(0x06, "Verse start")
case object RefrainStart extends TypeOfEvent(0x07, "Refrain start")
case object InterludeStart extends TypeOfEvent(0x08, "Interlude start")
case object ThemeStart extends TypeOfEvent(0x09, "Theme start")
case object VariationStart extends TypeOfEvent(0x0A, "Variation start")
case object KeyChange extends TypeOfEvent(0x0B, "Key change")
case object TimeChange extends TypeOfEvent(0x0C, "Time change")
case object MomentaryNoise extends TypeOfEvent(0x0D, "Momentary unwanted noise (Snap, Crackle & Pop)")
case object SustainedNoize extends TypeOfEvent(0x0E, "Sustained noise")
case object sustainedNoizeEnd extends TypeOfEvent(0x0F, "Sustained noise end")
case object IntroEnd extends TypeOfEvent(0x10, "Intro end")
case object MainPartEnd extends TypeOfEvent(0x11, "Main part end")
case object VerseEnd extends TypeOfEvent(0x12, "Verse end")
case object RefrainEnd extends TypeOfEvent(0x13, "Refrain end")
case object ThemeEnd extends TypeOfEvent(0x14, "Theme end")
case object Profanity extends TypeOfEvent(0x15, "Profanity")
case object ProfanityEnd extends TypeOfEvent(0x16, "Profanity end")
case object StartOfSilence extends TypeOfEvent(0xFD.toByte, "Audio end (start of silence)")
case object AudioFileEnds extends TypeOfEvent(0xFE.toByte, "Audio file ends")

