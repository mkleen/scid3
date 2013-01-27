package scid3

import java.io._
import org.specs._
import org.specs.matcher._
import frames._

class Id3ReaderSpec extends Specification {
	
	val home	= new File(System getProperty "user.home")
	
	"Id3 v 2.2" should {
		"have 12 frames" in {
			for(result <- Id3Reader.read(new FileInputStream(new File(home, "mezcla2_2.mp3"))))
			{
				result.frames.size must be_==(11)
			}
		}
	}

	"Id3 v 2.3" should {
			"have 12 frames" in {
				for(result <- Id3Reader.read(new FileInputStream(new File(home, "mezcla2_3.mp3"))))
				{
					result.frames.size must be_==(12)
				}
			}
		}
			
		"Id3 v 2.4" should {
			"have 12 frames" in {
				for(result <- Id3Reader.read(new FileInputStream(new File(home, "mezcla2_4.mp3"))))
				{
					result.frames.size must be_==(12)
				}
			}
		}
}
