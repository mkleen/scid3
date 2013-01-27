package scid3.model.frames


case class FrameBodyUnsupported(id: String) extends FrameBody {
	val frameBodyType = FrameBodyType.UNSUPPORTED
}
