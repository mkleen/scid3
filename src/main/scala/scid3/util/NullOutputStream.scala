package scid3.util

import java.io.OutputStream

/** OutputStream which does absolutely nothing */

object NullOutputStream extends OutputStream {

    override def  write(b: Array[Byte], off: Int,  len: Int) = {}

    override def  write( b: Int) = {}

    override def  write(b: Array[Byte]) = {}
}
