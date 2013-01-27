package scid3.model.types

object TextEncoding {
	val values = Set(ISO_8859_1, UTF_16_BOM, UTF_16_BE, UTF_8)
	def apply(id: Byte): Option[TextEncoding] = values.find(x => x.id == id)
}

sealed abstract class TextEncoding(val id: Byte, val charset: String, val terminator: Array[Byte], val description: String) 
case object ISO_8859_1 extends TextEncoding(0, "ISO-8859-1", new Array[Byte](1), "ISO-8859-1 [ISO-8859-1]. Terminated with $00.")
case object UTF_16_BOM extends TextEncoding(1, "UTF-16", new Array[Byte](2), "UTF-16 [UTF-16] encoded Unicode [UNICODE] with BOM. All strings in the same frame SHALL have the same byteorder.	Terminated with $00 00.")
case object UTF_16_BE extends TextEncoding(2, "UnicodeLittleUnmarked", new Array[Byte](2), "UTF-16BE [UTF-16] encoded Unicode [UNICODE] without BOM. Terminated with $00 00.")
case object UTF_8 extends TextEncoding(3, "UTF-8", new Array[Byte](1), "UTF-8 [UTF-8] encoded Unicode [UNICODE]. Terminated with $00.")
// case object UNDEFINED extends TextEncoding