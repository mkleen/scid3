package scid3.model.types

object InterPolationMethod {
	val values = Iterable(Band, Linear)
	def apply(id: Byte): Option[InterPolationMethod] = {
		values.find(it => it.id == id)
	}
}
sealed abstract class InterPolationMethod(
	val id: Byte,
	val description: String
)

case object Band extends InterPolationMethod(0, "Band")
case object Linear extends InterPolationMethod(1, "Linear")
