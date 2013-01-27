package scid3.model.results

import scid3.{Id3Frame}
import scid3.model.types.Version


/** Container class for Id3 results */

case class 	Id3Result(
	version: Version,
	id3Header:Id3Header,
	frames: Seq[Id3Frame],
	id3ExtendedData: Option[Id3ExtendedData]	= None
)