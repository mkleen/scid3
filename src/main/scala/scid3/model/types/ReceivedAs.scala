package scid3.model.types

object ReceivedAs {
	val values = 	Set(Other, CdAlbum, CompressedOnCd, FileOverInternet, StreamOverInternet, AsNoteSheets,
							AsNoteSheetsWithOtherSheets,OnOtherMedia, NonMusicalMerchandise)

	def apply(id: Byte) = values.find(_.id == id)
}

sealed abstract class ReceivedAs(val id: Byte,val  value: String)
case object Other extends ReceivedAs(0x00, "Other")
case object CdAlbum extends ReceivedAs(0x01, "Standard CD album with other songs")
case object CompressedOnCd extends ReceivedAs(0x02, "Compressed audio on CD")
case object FileOverInternet extends ReceivedAs(0x03, "File over the Internet")
case object StreamOverInternet extends ReceivedAs(0x04, "Stream over the Internet")
case object AsNoteSheets extends ReceivedAs(0x05, "As note sheets")
case object AsNoteSheetsWithOtherSheets extends ReceivedAs(0x06, "As note sheets in a book with other sheets")
case object OnOtherMedia extends ReceivedAs(0x07, "Music on other media")
case object NonMusicalMerchandise extends ReceivedAs(0x08, "Non-musical merchandise")


