package scid3.model.results

import scid3.{Id3Frame}

/** Container class for Id3 Header properties */

case class Id3Header(
	compression: Boolean = false,
	unsynchronization: Boolean = false,
	crcDataFlag: Boolean = false,
	experimental: Boolean = false,
	extended: Boolean = false,
	footerPresent: Boolean = false,
	size: Int	= 0
)
