package scid3.util

import collection.mutable.ListBuffer
import ByteUtil._
import Constants._
import scid3.model.types.TextEncoding

/* The ByteArrayTokenizer tokenizes a given Array[Byte] into various types */

final class ByteArrayTokenizer(val data: Array[Byte], var position: Int) {
	
	def this(data: Array[Byte]) = this (data, 0)

	def finished(): Boolean = this.position >= data.length

	def available(): Int = data.length - position

	def seek(pos: Int) = this.position = pos

	def skip(offset: Int) = position += offset

	def peek(): Byte = data(position)

	def next(): Byte = {val result = data(position); position = position + 1; result}

	def frameIdentifier(): String = fixedString(4)

	def language(): String = fixedString(3)

	def date(): String = fixedString(8).replaceAll("-", "")

	def url(): String = simpleString

	def mimeType(): String = simpleString

	def email(): String = simpleString

	def owner(): String = simpleString

	def fixedString(width: Int, encoding: String = ENCODING): String = new String(take(width), encoding)
	
	def rest(): Array[Byte] = {
		val result = subArray(data, position, data.length - position)
		position = data.length
		result
	}

	def take(bytes: Int): Array[Byte] = {
		if (bytes > available()) throw new IllegalArgumentException("not enough data available")
		val result = subArray(data, position, bytes)
		position += bytes
		result
	}

	def is(bytes: Array[Byte]): Boolean = {
		val old = position
		for (i <- 0 until bytes.length) {
			if (finished() || next() != bytes(i)) {
				position = old
				return false
			}
		}
		true
	}

	def takeNumber(width: Int): Long = {
		if (width < 1) throw new IllegalArgumentException("Number cannot have less than 1 byte")
		if (width > 8) throw new IllegalArgumentException("Number cannot have more than 8 bytes")

		var out = 0
		for (i <- 0 until width) {
			out = (out << 8) | next() & 0xff
		}
		out
	}

	def restNumber(minWidth: Int): Long = {
		val left = data.length - position
		if (left < minWidth) throw new IllegalArgumentException("Not enough bytes available")
		return takeNumber(left)
	}

	def simpleString(): String = {
		val before = position

		val after = indexOf(data, position, 0.toByte)

		if (after == -1) {
			position = data.length
			return new String(data, before, data.length - before, ENCODING)
		}
		else {
			position = after + 1 // skips the terminator
			return new String(data, before, after - before, ENCODING)
		}
	}

	def simpleStrings(): Seq[String] = {
		val result = new ListBuffer[String]
		while (!finished) {
			result += simpleString
		}
		result toList
	}

	def textString(textEncoding: TextEncoding): String = {
		val before 	= position
		val after 	= indexOfMultiple(data, position, textEncoding.terminator.length, textEncoding.terminator) 
		
		if (after == -1) {
			position = data.length
			return new String(data, before, data.length - before, textEncoding.charset)
		}		
		else {
			position = after + textEncoding.terminator.length // skip the terminator
			val stringData = subArray(data, before, after - before)
			new String(stringData, textEncoding.charset)
		}
	}

	def textStrings(textEncoding: TextEncoding): Seq[String] = {
		val result = new ListBuffer[String]
		while (!finished()) {
			result += (textString(textEncoding))
		}
		result toList
	}
}