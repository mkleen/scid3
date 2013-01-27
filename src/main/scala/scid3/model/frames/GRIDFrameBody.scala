package scid3.model.frames

import scid3.util.ByteArrayTokenizer

case class GRIDFrameBody(
	owner: String,
	groupSymbol: Byte,
	groupDependentData: Array[Byte]) extends FrameBody {
	val frameBodyType = FrameBodyType.GRID
}

object GRIDFrameBody {
	def apply(tok: ByteArrayTokenizer): GRIDFrameBody = {
		val owner = tok.owner()
		val groupSymbol = tok.next()
		val groupDependentData = tok.rest()
		GRIDFrameBody(owner, groupSymbol, groupDependentData)
	}
}