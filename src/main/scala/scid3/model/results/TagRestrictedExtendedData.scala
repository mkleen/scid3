package scid3.model.results

import scid3.{Id3Frame}

/** Container class for Id3 tag restricted extended data */

case class TagRestrictedExtendedData(
	tagSizeRestriction: Option[Byte] 		= None,
	textEncodingRestriction: Boolean 		= false,
	textFieldSizeRestriction: Option[Byte] 	= None,
	imageEncodingRestriction: Boolean 		= false,
	imageSizeRestriction: Option[Byte] 		= None
)
