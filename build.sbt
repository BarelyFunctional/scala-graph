name := "scala-graph"

version := "1.0"

scalaVersion := "2.10.3"

resolvers ++= Seq(
  "Sonatype OSS Releases"  at "http://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= Seq(
  "com.chuusai" % "shapeless" % "2.0.0-M1" cross CrossVersion.full,
  "org.scala-lang" % "scala-reflect" % "2.10.3",
  "org.scala-lang.plugins" % "continuations" % "2.10.3"
  //  "com.chuusai" % "shapeless_2.10.2" % "2.0.0-M1" // alternatively ...
)
// libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.10.3"