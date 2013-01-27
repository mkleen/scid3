package scid3.model.types

object TimeStampFormat {
	val values = Iterable(MpegFrames, Milliseconds)

	def buildById(id: Byte): Option[TimeStampFormat] = values.find(x => x.id == id)
}

sealed abstract class TimeStampFormat(val id: Byte, val description: String)
case object MpegFrames extends TimeStampFormat(0x01, "Absolute time using MPEG [MPEG] frames as unit")
case object Milliseconds extends TimeStampFormat(0x02, "Absolute time using milliseconds as unit")


