package scid3.model.types

object PictureType {
	val values = Set(OtherPictureType, File_Icon_32x32, Other_File_Icon, Cover_Front, Cover_Back, Leaflet_Page, Artist_Performer,
		Conductor, Band_Orchestra, Band_Orchestra, Composer, Lyricist, Recording_Location, During_Recording, During_Performance,
		Movie_Screen_Capture, A_Bright_Coloured_Fish, Illustration, Band_Logotype, Publisher_Logotype)

	def apply(id: Byte): Option[PictureType] = values.find(_.id == id)
}

sealed abstract class PictureType(val id: Byte, val description: String) {
	override def toString = "PictureType[" + id + ", " + description + ']'
}
case object OtherPictureType extends PictureType(0x00, "Other")
case object File_Icon_32x32 extends PictureType(0x01, "32x32 pixels 'file icon' (PNG only)")
case object Other_File_Icon extends PictureType(0x02, "Other file icon")
case object Cover_Front extends PictureType(0x03, "Cover (front)")
case object Cover_Back extends PictureType(0x04, "Cover (back)")
case object Leaflet_Page extends PictureType(0x05, "Leaflet page")
case object Media extends PictureType(0x06, "Media (e.g. label side of CD)")
case object Lead_Artist extends PictureType(0x07, "Lead artist/lead performer/soloist")
case object Artist_Performer extends PictureType(0x08, "Artist/performer")
case object Conductor extends PictureType(0x09, "Conductor")
case object Band_Orchestra extends PictureType(0x0A, "Band/Orchestra")
case object Composer extends PictureType(0x0B, "Composer")
case object Lyricist extends PictureType(0x0C, "Lyricist/text writer")
case object Recording_Location extends PictureType(0x0D, "Recording Location")
case object During_Recording extends PictureType(0x0E, "During recording")
case object During_Performance extends PictureType(0x0F, "During performance")
case object Movie_Screen_Capture extends PictureType(0x10, "Movie/video screen capture")
case object A_Bright_Coloured_Fish extends PictureType(0x11, "A bright coloured fish")
case object Illustration extends PictureType(0x12, "Illustration")
case object Band_Logotype extends PictureType(0x13, "Band/artist logotype")
case object Publisher_Logotype extends PictureType(0x14, "Publisher/Studio logotype")

