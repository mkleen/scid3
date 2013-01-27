package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.TextEncoding


object FrameBodyTextInformation {
	def apply(tok: ByteArrayTokenizer): Tuple2[Seq[String], TextEncoding] = {
		val id = tok.next()
		val textEncoding = TextEncoding(id) orNull
		val text = tok.textStrings(textEncoding)
	 	Tuple2(text, textEncoding)
	}
}

trait FrameBodyTextInformation extends FrameBody {
	val textEncoding: TextEncoding
	val text	: Seq[String]
}

object TCONFrameBody {
	def apply(tok: ByteArrayTokenizer): TCONFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return TCONFrameBody(tuple._1, tuple._2)
	}
}

case class TCONFrameBody(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TCON
}

object TBPMFrameBody {
	def apply(tok: ByteArrayTokenizer): TBPMFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return TBPMFrameBody(tuple._1, tuple._2)
	}
}

case class TBPMFrameBody(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TBPM
}

object TCOMFrameBody {
	def apply(tok: ByteArrayTokenizer): TCOMFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		TCOMFrameBody(tuple._1, tuple._2)
	}
}

case class TCOMFrameBody(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TCOM
}

object TCOPFrameBody {
	def apply(tok: ByteArrayTokenizer): TCOPFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return TCOPFrameBody(tuple._1, tuple._2)
	}
}

case class TCOPFrameBody(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TCOP
}

object TDATFrameBody {
	def apply(tok: ByteArrayTokenizer): TDATFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return TDATFrameBody(tuple._1, tuple._2)
	}
}

case class TDATFrameBody(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TDAT
}

object TDLYFrameBody {
	def apply(tok: ByteArrayTokenizer): TDLYFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return TDLYFrameBody(tuple._1, tuple._2)
	}
}

case class TDLYFrameBody(
	text: Seq[String], textEncoding:
	TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TDLY
}

object TENCFrameBody {
	def apply(tok: ByteArrayTokenizer): TENCFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return TENCFrameBody(tuple._1, tuple._2)
	}
}

case class TENCFrameBody(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TENC
}

object TEXTFrameBody {
	def apply(tok: ByteArrayTokenizer): TEXTFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return TEXTFrameBody(tuple._1, tuple._2)
	}
}

case class TEXTFrameBody(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TEXT
}

object TFLTFrameBody {
	def apply(tok: ByteArrayTokenizer): TFLTFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return TFLTFrameBody(tuple._1, tuple._2)
	}
}

case class TFLTFrameBody(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TFLT
}

object TIMEFrameBody {
	def apply(tok: ByteArrayTokenizer): TIMEFrameBody = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return TIMEFrameBody(tuple._1, tuple._2)
	}
}

case class TIMEFrameBody(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TIME
}

object FrameBodyTIPL {
	def apply(tok: ByteArrayTokenizer): FrameBodyTIPL = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTIPL(tuple._1, tuple._2)
	}
}

case class FrameBodyTIPL(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TIPL
}

object FrameBodyTIT1 {
	def apply(tok: ByteArrayTokenizer): FrameBodyTIT1 = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTIT1(tuple._1, tuple._2)
	}
}

case class FrameBodyTIT1(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TIT1
}

object FrameBodyTIT2 {
	def apply(tok: ByteArrayTokenizer): FrameBodyTIT2 = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTIT2(tuple._1, tuple._2)
	}
}

case class FrameBodyTIT2(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TIT2
}


object FrameBodyTIT3 {
	def apply(tok: ByteArrayTokenizer): FrameBodyTIT3 = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTIT3(tuple._1, tuple._2)
	}
}

case class FrameBodyTIT3(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TIT3
}

object FrameBodyTKEY {
	def apply(tok: ByteArrayTokenizer): FrameBodyTKEY = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTKEY(tuple._1, tuple._2)
	}
}

case class FrameBodyTKEY(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TKEY
}

object FrameBodyTLEN {
	def apply(tok: ByteArrayTokenizer): FrameBodyTLEN = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTLEN(tuple._1, tuple._2)
	}
}

case class FrameBodyTLEN(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TLEN
}

object FrameBodyTMCL {
	def apply(tok: ByteArrayTokenizer): FrameBodyTMCL = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTMCL(tuple._1, tuple._2)
	}
}

case class FrameBodyTMCL(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TMCL
}

object FrameBodyTMED {
	def apply(tok: ByteArrayTokenizer): FrameBodyTMED = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTMED(tuple._1, tuple._2)
	}
}

case class FrameBodyTMED(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TMED
}

object FrameBodyTMOO {
	def apply(tok: ByteArrayTokenizer): FrameBodyTMOO = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTMOO(tuple._1, tuple._2)
	}
}

case class FrameBodyTMOO(
	text: Seq[String],
	textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TMOO
}

object FrameBodyTOAL {
	def apply(tok: ByteArrayTokenizer): FrameBodyTOAL = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTOAL(tuple._1, tuple._2)
	}
}

case class FrameBodyTOAL(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TOAL
}

object FrameBodyTOFN {
	def apply(tok: ByteArrayTokenizer): FrameBodyTOFN = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTOFN(tuple._1, tuple._2)
	}
}

case class FrameBodyTOFN(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TOFN
}

object FrameBodyTOLY {
	def apply(tok: ByteArrayTokenizer): FrameBodyTOLY = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTOLY(tuple._1, tuple._2)
	}
}

case class FrameBodyTOLY(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TOLY
}

object FrameBodyTOPE {
	def apply(tok: ByteArrayTokenizer): FrameBodyTOPE = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTOPE(tuple._1, tuple._2)
	}
}

case class FrameBodyTOPE(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TOPE
}

object FrameBodyTORY {
	def apply(tok: ByteArrayTokenizer): FrameBodyTORY = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTORY(tuple._1, tuple._2)
	}
}

case class FrameBodyTORY(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TORY
}

object FrameBodyTOWN {
	def apply(tok: ByteArrayTokenizer): FrameBodyTOWN = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTOWN(tuple._1, tuple._2)
	}
}

case class FrameBodyTOWN(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TOWN
}

object FrameBodyTPE1 {
	def apply(tok: ByteArrayTokenizer): FrameBodyTPE1 = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTPE1(tuple._1, tuple._2)
	}
}

case class FrameBodyTPE1(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TPE1
}

object FrameBodyTPE2 {
	def apply(tok: ByteArrayTokenizer): FrameBodyTPE2 = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTPE2(tuple._1, tuple._2)
	}
}

case class FrameBodyTPE2(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TPE2
}

object FrameBodyTPE3 {
	def apply(tok: ByteArrayTokenizer): FrameBodyTPE3 = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTPE3(tuple._1, tuple._2)
	}
}

case class FrameBodyTPE3(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TPE3
}

object FrameBodyTPE4 {
	def apply(tok: ByteArrayTokenizer): FrameBodyTPE4 = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTPE4(tuple._1, tuple._2)
	}
}

case class FrameBodyTPE4(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TPE4
}

object FrameBodyTPOS {
	def apply(tok: ByteArrayTokenizer): FrameBodyTPOS = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTPOS(tuple._1, tuple._2)
	}
}

case class FrameBodyTPOS(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TPOS
}

object FrameBodyTPRO {
	def apply(tok: ByteArrayTokenizer): FrameBodyTPRO = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTPRO(tuple._1, tuple._2)
	}
}

case class FrameBodyTPRO(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TPRO
}

object FrameBodyTPUB {
	def apply(tok: ByteArrayTokenizer): FrameBodyTPUB = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTPUB(tuple._1, tuple._2)
	}
}

case class FrameBodyTPUB(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TPUB
}

object FrameBodyTRCK {
	def apply(tok: ByteArrayTokenizer): FrameBodyTRCK = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTRCK(tuple._1, tuple._2)
	}
}

case class FrameBodyTRCK(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TRCK
}

object FrameBodyTRDA {
	def apply(tok: ByteArrayTokenizer): FrameBodyTRDA = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTRDA(tuple._1, tuple._2)
	}
}

case class FrameBodyTRDA(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TRDA
}


object FrameBodyTRSN {
	def apply(tok: ByteArrayTokenizer): FrameBodyTRSN = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTRSN(tuple._1, tuple._2)
	}
}

case class FrameBodyTRSN(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TRSN
}

object FrameBodyTRSO {
	def apply(tok: ByteArrayTokenizer): FrameBodyTRSO = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTRSO(tuple._1, tuple._2)
	}
}

case class FrameBodyTRSO(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TRSO
}

object FrameBodyTSIZ {
	def apply(tok: ByteArrayTokenizer): FrameBodyTSIZ = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTSIZ(tuple._1, tuple._2)
	}
}

case class FrameBodyTSIZ(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TSIZ
}

object FrameBodyTSOA {
	def apply(tok: ByteArrayTokenizer): FrameBodyTSOA = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTSOA(tuple._1, tuple._2)
	}
}

case class FrameBodyTSOA(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TSOA
}

object FrameBodyTSOP {
	def apply(tok: ByteArrayTokenizer): FrameBodyTSOP = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTSOP(tuple._1, tuple._2)
	}
}

case class FrameBodyTSOP(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TSOP
}

object FrameBodyTSOT {
	def apply(tok: ByteArrayTokenizer): FrameBodyTSOT = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTSOT(tuple._1, tuple._2)
	}
}

case class FrameBodyTSOT(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TSOT
}

object FrameBodyTSRC {
	def apply(tok: ByteArrayTokenizer): FrameBodyTSRC = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTSRC(tuple._1, tuple._2)
	}
}

case class FrameBodyTSRC(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TSRC
}

object FrameBodyTSSE {
	def apply(tok: ByteArrayTokenizer): FrameBodyTSSE = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTSSE(tuple._1, tuple._2)
	}
}

case class FrameBodyTSSE(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TSSE
}

object FrameBodyTSST {
	def apply(tok: ByteArrayTokenizer): FrameBodyTSST = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTSST(tuple._1, tuple._2)
	}
}

case class FrameBodyTSST(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TSST
}

object FrameBodyTYER {
	def apply(tok: ByteArrayTokenizer): FrameBodyTYER = {
		val tuple = FrameBodyTextInformation.apply(tok)
		return FrameBodyTYER(tuple._1, tuple._2)
	}
}

case class FrameBodyTYER(text: Seq[String], textEncoding: TextEncoding) extends FrameBodyTextInformation {
	val frameBodyType = FrameBodyType.TYER
}