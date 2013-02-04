package scid3

import scid3.model.frames.FrameBody
import scid3.model.types.Version

final case class Id3Frame(
	version: Version,
	body: FrameBody,
	compression: Boolean = false,
	encryption: Boolean = false,
	groupingIdentity: Boolean = false,
	readOnly: Boolean = false,
	tagAlterPreservation: Boolean = false,
	fileAlterPreservation: Boolean = false,
	dataLengthIndicator: Boolean = false,
	unsynchronization: Boolean = false
) {
	override
	def toString() = "Id3Frame[" + body + " version: "  + version + ']'
}



