package scid3

import java.io.{OutputStream, InputStream}

import scid3.model.frames._
import scid3.readers._
import scid3.model.types._
import scid3.model.results._
import scid3.util._

/** Reads ID3 tags from a given Inputstream and optionally copies the read data to a given OutputStream.
   Returns None if the data is invalid. */

object Id3Reader {
	def read(ist:InputStream, ost:OutputStream = NullOutputStream): Option[Id3Result] = {
		val in	= new TeeInputStream(ist, ost)
		for{version <- StreamUtil.readVersion(in)}
			yield {
				version match {
					case ID3v2_2 =>  Id3v2_2Reader read in
					case ID3v2_3 =>  Id3v2_3Reader read in
					case ID3v2_4 =>  Id3v2_4Reader read in
				}
			}
	}

	def readFrameBodies(ist:InputStream, ost:OutputStream = NullOutputStream): Option[Map[FrameBodyType.Value, Seq[FrameBody]]] = {
		for{result <- read(ist, ost)}
			yield {
			result.frames.map { _.body } groupBy { _.frameBodyType }
		}
	}	
}