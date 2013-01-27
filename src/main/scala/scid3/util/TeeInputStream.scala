package scid3.util

import java.io.{OutputStream, InputStream, FilterInputStream}

/** TeeInputStream writes a copy of all bytes read from the InputStream to a given OutputStream.*/

final class TeeInputStream(
    in: InputStream,
    out: OutputStream, 
    closeBranch: Boolean = false
    ) extends FilterInputStream(in) {

	override def read(): Int = {
		val n = super.read()
		if (n != -1) {
			out.write(n)
		}
		n
	}

	override def read(bts: Array[Byte], st: Int, end: Int): Int = {
		val n = super.read(bts, st, end)
		if (n != -1) {
			out.write(bts, st, n)
		}
		n
	}

	override def read(bts: Array[Byte]): Int = {
		val n = super.read(bts)
		if (n != -1) {
			out.write(bts, 0, n)
		}
		n
	}

	override def close() = {
		try {
			super.close()
		} finally {
			if (closeBranch) {
				out.close()
			}
		}
	}

	/** Copies the rest of all remaining bytes from the InputStream into the OutputStream */

	def drain(): Unit = {
		val buffer = new Array[Byte](1024)
		while (true) {
			val bytesRead = in.read(buffer)
			if (bytesRead == -1) return
			out.write(buffer, 0, bytesRead)
		}
	}

	override def available() = super.available()

	override def markSupported() = false

	override def mark(readlimit: Int) = error("Not supported")

	override def skip(ln: Long) = error("Not supported")

	override def reset() = error("Not supported")
}
