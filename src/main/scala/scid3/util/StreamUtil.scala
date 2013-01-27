package scid3.util

import java.io.{EOFException, InputStream}
import scid3.model.types.Version

/** Helper object for processing an Inputstream */
object StreamUtil {
	def readVersion(in:InputStream): Option[Version] = readString(in, 3)
		match {
			case "ID3" 	=> 	val tok = new ByteArrayTokenizer(readBytes(in, 2)); Version(tok.next, tok.next)
			case _		=> 	None
	}

	def readCrCDataFlag(crcDataBuffer: Array[Byte]): Int = {
		crcDataBuffer.foldLeft(0)((result, byte) => (result << 7) | (byte & 0x7f))
	}

	def readBytes(in: InputStream, b: Array[Byte], off: Int, len: Int): Unit = {
		var n: Int = 0
		do {
			var count: Int = in.read(b, off + n, len - n)
			if (count < 0) throw new EOFException
			n += count
		} while (n < len)
	}

	def readBytes(in: InputStream, len: Int): Array[Byte] = {
		val result = new Array[Byte](len)
		readBytes(in, result, 0, len)
		result
	}

	def readByte(in:InputStream):Byte = {
		val byte = in.read()
		if (byte == -1) throw new EOFException
		byte.toByte
	}

	def readSizePrefixed(in: InputStream): Array[Byte] = {
		readBytes(in, in.read)
	}

	def readUnsafeInt(in: InputStream): Int = {
		val buffer	= readBytes(in, 4)
		return	((buffer(0) & 0xff) << 24)	|
				((buffer(1) & 0xff) << 16)  |
				((buffer(2) & 0xff) << 8)	|
				((buffer(3) & 0xff) << 0)
	}
	
	def readSyncSafeInt(in: InputStream): Int = {
		val buffer	= readBytes(in, 4)
		return	((buffer(0) & 0x7f) << 21)	|
				((buffer(1) & 0x7f) << 14)  |
				((buffer(2) & 0x7f) << 7)	|
				((buffer(3) & 0x7f) << 0)
	}
	
	def readSmallInt(in: InputStream): Int = {
		val buffer	= readBytes(in, 3)
		return	((buffer(0) & 0xff) << 16)  |
				((buffer(1) & 0xff) << 8)	|
				((buffer(2) & 0xff) << 0)
	}

	def readString(in: InputStream, width: Int): String = {
		new String(readBytes(in, width), Constants.ENCODING)
	}
}
