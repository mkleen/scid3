package scid3.model.frames

import scid3.util.ByteArrayTokenizer
import scid3.model.types.TextEncoding

trait FrameBody {
	val frameBodyType: FrameBodyType.Value
}

object FrameBody {
    
    import FrameBodyType._
    
	def apply(id: FrameBodyType.Value, tok: ByteArrayTokenizer): FrameBody = {
		id match {
			case TALB => return TALBFrameBody.apply(tok)
			case TBPM => return TBPMFrameBody.apply(tok)
			case TCOM => return TCOMFrameBody.apply(tok)
			case TCON => return TCONFrameBody.apply(tok)
			case TCOP => return TCOPFrameBody.apply(tok)
			case TDAT => return TDATFrameBody.apply(tok)
			case TDLY => return TDLYFrameBody.apply(tok)
			case TENC => return TENCFrameBody.apply(tok)
			case TEXT => return TEXTFrameBody.apply(tok)
			case TFLT => return TFLTFrameBody.apply(tok)
			case TIME => return FrameBodyTIPL.apply(tok)
			case TIPL => return ETCOFrameBody.apply(tok)
			case TIT1 => return FrameBodyTIT1.apply(tok)
			case TIT2 => return FrameBodyTIT2.apply(tok)
			case TIT3 => return FrameBodyTIT3.apply(tok)
			case TKEY => return FrameBodyTKEY.apply(tok)
			case TLEN => return FrameBodyTLEN.apply(tok)
			case TMCL => return FrameBodyTMCL.apply(tok)
			case TMED => return FrameBodyTMED.apply(tok)
			case TMOO => return FrameBodyTMOO.apply(tok)
			case TOAL => return FrameBodyTOAL.apply(tok)
			case TOFN => return FrameBodyTOFN.apply(tok)
			case TOLY => return FrameBodyTOLY.apply(tok)
			case TOWN => return FrameBodyTOWN.apply(tok)
			case TPE1 => return FrameBodyTPE1.apply(tok)
			case TPE2 => return FrameBodyTPE2.apply(tok)
			case TPE3 => return FrameBodyTPE3.apply(tok)
			case TPE4 => return FrameBodyTPE4.apply(tok)
			case TPOS => return FrameBodyTPOS.apply(tok)
			case TPRO => return FrameBodyTPRO.apply(tok)
			case TPUB => return FrameBodyTPUB.apply(tok)
			case TRCK => return FrameBodyTRCK.apply(tok)
			case TRDA => return FrameBodyTRDA.apply(tok)
			case TRSN => return FrameBodyTRSN.apply(tok)
			case TRSO => return FrameBodyTRSO.apply(tok)
			case TSIZ => return FrameBodyTSIZ.apply(tok)
			case TSOA => return FrameBodyTSOA.apply(tok)
			case TSOP => return FrameBodyTSOP.apply(tok)
			case TSOT => return FrameBodyTSOT.apply(tok)
			case TSRC => return FrameBodyTSRC.apply(tok)
			case TSSE => return FrameBodyTSSE.apply(tok)
			case TSST => return FrameBodyTSST.apply(tok)
			case TYER => return FrameBodyTYER.apply(tok)
			case ETCO => return ETCOFrameBody.apply(tok)
			case TDEN => return TDENFrameBody.apply(tok)
			case TDOR => return TDORFrameBody.apply(tok)
			case TDRC => return TDRCFrameBody.apply(tok)
			case PIC => return PICFrameBody.apply(tok)
			case POSS => return POSSFrameBody.apply(tok)
			case TDRL => return TDRLFrameBody.apply(tok)
			case TDTG => return TDTGFrameBody.apply(tok)
			case OWNE => return OWNEFrameBody.apply(tok)
			case ASPI => return ASPIFrameBody.apply(tok)
			case APIC => return APICFrameBody.apply(tok)
			case APICID3V22	=>	return APICID3V22FrameBody(tok)
 			case COMM => return COMMFrameBody.apply(tok)
			case COMR => return COMRFrameBody.apply(tok)
			case CRM => return CRMFrameBody.apply(tok)
			case ENCR => return ENCRFrameBody.apply(tok)
			case GEOB => return GEOBFrameBody.apply(tok)
			case GRID => return GRIDFrameBody.apply(tok)
			case RVRB => return RVRBFrameBody.apply(tok)
			case LINK => return LINKFrameBody.apply(tok)
			case MCDI => return MCDIFrameBody.apply(tok)
			case PCNT => return PCNTFrameBody.apply(tok)
			case POPM => return POPMFrameBody.apply(tok)
			case PRIV => return PRIVFrameBody.apply(tok)
			case RBUF => return RBUFFrameBody.apply(tok)
			case SYLT => return SYLTFrameBody.apply(tok)
			case SEEK => return SEEKFrameBody.apply(tok)
			case TLAN => return TLANFrameBody.apply(tok)
			case TORY => return FrameBodyTORY.apply(tok)
			case TOPE => return FrameBodyTOPE.apply(tok)
			case SIGN => return SIGNFrameBody.apply(tok)
			case TXXX => return TXXXFrameBody.apply(tok)
			case UFID => return UFIDFrameBody.apply(tok)
			case USER => return USERFrameBody.apply(tok)
			case USLT => return USLTFrameBody.apply(tok)
			case WCOM => return FrameBodyWCOM.apply(tok)
			case WCOP => return FrameBodyWCOP.apply(tok)
			case WOAF => return FrameBodyWOAF.apply(tok)
			case WOAR => return FrameBodyWOAR.apply(tok)
			case WOAS => return FrameBodyWOAS.apply(tok)
			case WORS => return FrameBodyWORS.apply(tok)
			case WPAY => return FrameBodyWPAY.apply(tok)
			case WPUB => return FrameBodyWPUB.apply(tok)
			case WXXX => return WXXXFrameBody.apply(tok)
			case AENC => return AENCFrameBody.apply(tok)
			//    case "RVAD" => return FrameBodyRVAD.apply(tok)			
			case _ => return FrameBodyUnsupported(id.toString)
		}
	}

	def apply(id: String, tok: ByteArrayTokenizer): FrameBody = {
		val frameBodyType = FrameBodyType.values.find(_.toString == id) getOrElse {return new FrameBodyUnsupported(id)}
		apply(frameBodyType, tok)
	}
}