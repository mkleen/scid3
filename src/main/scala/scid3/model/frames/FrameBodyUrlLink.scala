package scid3.model.frames

import scid3.util.ByteArrayTokenizer

trait FrameBodyUrlLink extends FrameBody {
	val urlLink: String
}


object FrameBodyWCOM {
	def apply(tok: ByteArrayTokenizer): FrameBodyWCOM = {
		val urlLink = tok.url
		FrameBodyWCOM(urlLink)
	}
}

case class FrameBodyWCOM(val urlLink: String) extends FrameBodyUrlLink {
	val frameBodyType = FrameBodyType.WCOM
}

object FrameBodyWCOP {
	def apply(tok: ByteArrayTokenizer): FrameBodyWCOP = {
		val urlLink = tok.url
		FrameBodyWCOP(urlLink)
	}
}

case class FrameBodyWCOP(val urlLink: String) extends FrameBodyUrlLink {
	val frameBodyType = FrameBodyType.WCOP
}

object FrameBodyWOAF {
	def apply(tok: ByteArrayTokenizer): FrameBodyWOAF = {
		val urlLink = tok.url
		FrameBodyWOAF(urlLink)
	}
}

case class FrameBodyWOAF(val urlLink: String) extends FrameBodyUrlLink {
	val frameBodyType = FrameBodyType.WOAF
}

object FrameBodyWOAR {
	def apply(tok: ByteArrayTokenizer): FrameBodyWOAR = {
		val urlLink = tok.url
		FrameBodyWOAR(urlLink)
	}
}

case class FrameBodyWOAR(val urlLink: String) extends FrameBodyUrlLink {
	val frameBodyType = FrameBodyType.WOAR
}

object FrameBodyWOAS {
	def apply(tok: ByteArrayTokenizer): FrameBodyWOAS = {
		val urlLink = tok.url
		FrameBodyWOAS(urlLink)
	}
}

case class FrameBodyWOAS(val urlLink: String) extends FrameBodyUrlLink {
	val frameBodyType = FrameBodyType.WOAS
}

object FrameBodyWORS {
	def apply(tok: ByteArrayTokenizer): FrameBodyWORS = {
		val urlLink = tok.url
		FrameBodyWORS(urlLink)
	}
}

case class FrameBodyWORS(val urlLink: String) extends FrameBodyUrlLink {
	val frameBodyType = FrameBodyType.WORS
}

object FrameBodyWPAY {
	def apply(tok: ByteArrayTokenizer): FrameBodyWPAY = {
		val urlLink = tok.url
		FrameBodyWPAY(urlLink)
	}
}

case class FrameBodyWPAY(val urlLink: String) extends FrameBodyUrlLink {
	val frameBodyType = FrameBodyType.WPAY
}

object FrameBodyWPUB {
	def apply(tok: ByteArrayTokenizer): FrameBodyWPUB = {
		val urlLink = tok.url
		FrameBodyWPUB(urlLink)
	}
}

case class FrameBodyWPUB(val urlLink: String) extends FrameBodyUrlLink {
	val frameBodyType = FrameBodyType.WPUB
}                             	