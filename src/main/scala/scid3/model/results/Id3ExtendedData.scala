package scid3.model.results

import scid3.{Id3Frame}

/** Container class for Id3 ExtendedData  */

case class Id3ExtendedData(
	paddingSize: Option[Int]= None,
	crcDataFlag: Boolean 	= false,
	crcData: Option[Int] 	= None,
	tagRestriction: Boolean	= false,
	updateTag: Boolean 		= false,
	tagRestrictedExtendedData: Option[TagRestrictedExtendedData] = None
)
	