name := "configurato"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.julienrf" %% "enum" % "3.1",
  "com.github.pureconfig" %% "pureconfig" % "0.8.0",
  "com.github.pureconfig" %% "pureconfig-enum" % "0.8.0",
)

mainClass in Compile := Some("configurato.Main")