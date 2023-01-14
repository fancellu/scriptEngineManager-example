ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "scriptEngineManager-example"
  )

 // To get access to the scalaScript engine
libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

