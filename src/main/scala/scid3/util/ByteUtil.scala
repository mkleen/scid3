package scid3.util

/* Helper functions for processing Array[Byte] */

object ByteUtil {
	def subArray(input: Array[Byte], offset: Int, width: Int): Array[Byte] = {
		val result = new Array[Byte](width)
		System.arraycopy(input, offset, result, 0, width)
		result
	}

	def indexOf(input: Array[Byte], offset: Int, what: Byte): Int = {
		for (i <- offset until input.length) {
			if (input(i) == what) return i
		}
		-1
	}

	def indexOfMultiple(input: Array[Byte], offset: Int, step: Int, what: Array[Byte]): Int = {
		val last = input.length - what.length
		for (i <- offset to last by step) {
			if (is(input, i, what)) return i
		}
		-1
	}

	def is(input: Array[Byte], offset: Int, what: Array[Byte]): Boolean = {
		if (offset + what.length > input.length) return false
		for (i <- 0 until what.length) {
			if (input(offset + i) != what(i)) return false
		}
		true
	}

	def bit(value: Byte, index: Int): Boolean = {
		return (value & (1 << index)) != 0
	}

	def bits(input: Byte, lsb: Int, count: Int): Byte = {
		return ((input >> lsb) & ~(-1 << count)).toByte
	}
}
