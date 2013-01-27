package scid3.model.types

sealed abstract class Version(val minor: Byte, val revision: Byte)
case object ID3v2_2 extends Version(2, 0)
case object ID3v2_3 extends Version(3, 0)
case object ID3v2_4 extends Version(4, 0)

object Version {
	val values = Set(ID3v2_2, ID3v2_3, ID3v2_4)

	def apply(minor: Byte, revision: Byte): Option[Version] = {
		values.find(x => x.minor == minor && x.revision == revision)
	}
}