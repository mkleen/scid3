package scid3.model.frames


/* This object provides validation for ID3 Version 2 Frameidentifiers */

object FrameIdentifiers {

	def buildFrameIdentifier(id: String): Option[FrameBodyType.Value] = {
		if (isValidID3v2FrameIdentifier(id)) FrameBodyType.values.find(_.toString == id) else None
	}

	def isValidID3v2FrameIdentifier(identifier: String): Boolean = {
		identifier.exists(character => (character >= 'A' && character <= 'Z'|| (character >= '0' && character <= '9')))
	}

	def normalizeFrameIdentifier(id: String): String = convertFrameID2_2to2_4(id) getOrElse id

	def convertFrameID2_2to2_4(identifierV2: String): Option[String] = {
		val id2v2 = if (identifierV2.length() < 3) return None else identifierV2.substring(0, 3)
		val id2v3 = id3v2_2ToId3v2_3.get(id2v2) getOrElse {return None}
		if (id2v3.length() < 4) return None
		val id2v4 = id2v3.substring(0, 4)
		val result = id3v2_3ToId3v2_4.get(id2v4) orElse {Some(id2v4)}
	 	result
	}
	
	//TODO ugly hack 
	def convertFramID322(id: String): Option[String] = {
		 val result = convertFrameID2_2to2_4(id)
		 result match {
			case Some("APIC")	=> Some("APICID3V22")
			case _				=> result
		}
	}
	
	def isID3v2_2FrameIdentifier(identifier: String): Boolean = {
		if (identifier.length < 3) return false
		if (identifier.length == 3) return id3v2_2FrameIdToString.contains(identifier)
		val upperIdentifier: String = identifier.toUpperCase
		val isAlphaAt3 = upperIdentifier.charAt(3) >= 'A' && upperIdentifier.charAt(3) <= 'Z'
		val upperKey = if (isAlphaAt3) upperIdentifier.substring(0, 4) else upperIdentifier.substring(0, 3)
		id3v2_2FrameIdToString.contains(upperKey)
	}
	
	private val id3v2_2FrameIdToString = Map(
		"BUF" -> "Recommended buffer size",
		"CNT" -> "Play counter",
		"COM" -> "Comments",
		"CRA" -> "Audio encryption",
		"CRM" -> "Encrypted meta frame",
		"ETC" -> "Event timing codes",
		"EQU" -> "Equalization",
		"GEO" -> "General encapsulated object",
		"IPL" -> "Involved people list",
		"LNK" -> "Linked information",
		"MCI" -> "Music CD Identifier",
		"MLL" -> "MPEG location lookup table",
		"PIC" -> "Attached picture",
		"POP" -> "Popularimeter",
		"REV" -> "Reverb",
		"RVA" -> "Relative volume adjustment",
		"SLT" -> "Synchronized lyric/text",
		"STC" -> "Synced tempo codes",
		"TAL" -> "Text: Album/Movie/Show title",
		"TBP" -> "Text: BPM (Beats Per Minute)",
		"TCM" -> "Text: Composer",
		"TCO" -> "Text: Content type",
		"TCR" -> "Text: Copyright message",
		"TDA" -> "Text: Date",
		"TDY" -> "Text: Playlist delay",
		"TEN" -> "Text: Encoded by",
		"TFT" -> "Text: File type",
		"TIM" -> "Text: Time",
		"TKE" -> "Text: Initial key",
		"TLA" -> "Text: Language(s)",
		"TLE" -> "Text: Length",
		"TMT" -> "Text: Media type",
		"TOA" -> "Text: Original artist(s)/performer(s)",
		"TOF" -> "Text: Original filename",
		"TOL" -> "Text: Original Lyricist(s)/text writer(s)",
		"TOR" -> "Text: Original release year",
		"TOT" -> "Text: Original album/Movie/Show title",
		"TP1" -> "Text: Lead artist(s)/Lead performer(s)/Soloist(s)/Performing group",
		"TP2" -> "Text: Band/Orchestra/Accompaniment",
		"TP3" -> "Text: Conductor/Performer refinement",
		"TP4" -> "Text: Interpreted,remixed,or otherwise modified by",
		"TPA" -> "Text: Part of a set",
		"TPB" -> "Text: Publisher",
		"TRC" -> "Text: ISRC (International Standard Recording Code)",
		"TRD" -> "Text: Recording dates",
		"TRK" -> "Text: Track number/Position in set",
		"TSI" -> "Text: Size",
		"TSS" -> "Text: Software/hardware and settings used for encoding",
		"TT1" -> "Text: Content group description",
		"TT2" -> "Text: Title/Songname/Content description",
		"TT3" -> "Text: Subtitle/Description refinement",
		"TXT" -> "Text: Lyricist/text writer",
		"TXX" -> "User defined text information frame",
		"TYE" -> "Text: Year",
		"UFI" -> "Unique file identifier",
		"ULT" -> "Unsychronized lyric/text transcription",
		"WAF" -> "URL: Official audio file webpage",
		"WAR" -> "URL: Official artist/performer webpage",
		"WAS" -> "URL: Official audio source webpage",
		"WCM" -> "URL: Commercial information",
		"WCP" -> "URL: Copyright/Legal information",
		"WPB" -> "URL: Publishers official webpage",
		"WXX" -> "User defined URL link frame")

	private val id3v2_3ToId3v2_4 = Map(
		"EQUA" -> "EQU2", // changed from EQUA to EQU2 in
		"RVAD" -> "RVA2") // changed from RVAD to RVA2 in

	private val id3v2_2ToId3v2_3 = Map(
		"BUF" -> "RBUF",
		"CNT" -> "PCNT",
		"COM" -> "COMM",
		"CRA" -> "AENC",
		"CRM" -> "CRM", // removed in ID3v2.3
		"ETC" -> "ETCO",
		"EQU" -> "EQUA", // changed from EQUA to EQU2 in
		"GEO" -> "GEOB", // Deprecated in ID3v2.4
		"IPL" -> "IPLS",
		"LNK" -> "LINK",
		"MCI" -> "MCDI",
		"MLL" -> "MLLT",
		"PIC" -> "APIC", //TODO needs to be fixed PIC is not an APIC
		"POP" -> "POPM",
		"REV" -> "RVRB",
		"RVA" -> "RVAD", // changed from RVAD to RVA2 in
		"SLT" -> "SYLT",
		"STC" -> "SYTC",
		"TAL" -> "TALB",
		"TBP" -> "TBPM",
		"TCM" -> "TCOM",
		"TCO" -> "TCON",
		"TCR" -> "TCOP",
		"TDA" -> "TDAT", // Deprecated in ID3v2.4
		"TDY" -> "TDLY",
		"TEN" -> "TENC",
		"TFT" -> "TFLT",
		"TIM" -> "TIME", // Deprecated in ID3v2.4
		"TKE" -> "TKEY",
		"TLA" -> "TLAN",
		"TLE" -> "TLEN",
		"TMT" -> "TMED",
		"TOA" -> "TOPE",
		"TOF" -> "TOFN",
		"TOL" -> "TOLY",
		"TOR" -> "TORY", // Deprecated in ID3v2.4
		"TOT" -> "TOAL",
		"TP1" -> "TPE1",
		"TP2" -> "TPE2",
		"TP3" -> "TPE3",
		"TP4" -> "TPE4",
		"TPA" -> "TPOS",
		"TPB" -> "TPUB",
		"TRC" -> "TSRC",
		"TRD" -> "TRDA", // Deprecated in ID3v2.4
		"TRK" -> "TRCK",
		"TSI" -> "TSIZ", // Deprecated in ID3v2.4
		"TSS" -> "TSSE",
		"TT1" -> "TIT1",
		"TT2" -> "TIT2",
		"TT3" -> "TIT3",
		"TXT" -> "TEXT",
		"TXX" -> "TXXX",
		"TYE" -> "TYER", // Deprecated in ID3v2.4
		"UFI" -> "UFID",
		"ULT" -> "USLT",
		"WAF" -> "WOAF",
		"WAR" -> "WOAR",
		"WAS" -> "WOAS",
		"WCM" -> "WCOM",
		"WCP" -> "WCOP",
		"WPB" -> "WPUB",
		"WXX" -> "WXXX"
		)
}