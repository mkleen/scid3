package scid3.model.frames

import collection.mutable.ListBuffer
import scid3.util.ByteArrayTokenizer
import scid3.model.types.{TypeOfEvent, TimeStampFormat, EventTime}

case class ETCOFrameBody(
	timeStampFormat: Option[TimeStampFormat],
	eventTimes: Seq[EventTime]) extends FrameBody {
	val frameBodyType = FrameBodyType.ETCO
}

object ETCOFrameBody {
	def apply(tok: ByteArrayTokenizer): ETCOFrameBody = {
		val timeStampFormat = TimeStampFormat.buildById(tok.next()) 
		val eventTimes = new ListBuffer[EventTime]

		while (!tok.finished()) {
			val typeOfEvent = TypeOfEvent(tok.next()) 
			val timeStamp = tok.takeNumber(4)
			eventTimes += new EventTime(typeOfEvent, timeStamp)
		}
		ETCOFrameBody(timeStampFormat, eventTimes.toList)
	}
}