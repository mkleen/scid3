name			:= "scid3"

organization	:= "de.michaelkleen"

version			:= "0.0.1"

scalaVersion	:= "2.9.1"

publishArtifact in (Compile, packageDoc)	:= false

publishArtifact in (Compile, packageSrc)	:= false

libraryDependencies	++= Seq(
	"org.scala-tools.testing"	%%	"specs"		% "1.6.9"	% "test"
)

scalacOptions	++= Seq("-deprecation", "-unchecked")
