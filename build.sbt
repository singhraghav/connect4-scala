import Dependencies._

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val allDependencies = List(
  Libraries.scalaTest % Test
)

lazy val root = (project in file("."))
  .settings(
    name := "com.rs.connect4",
    libraryDependencies := allDependencies
  )


