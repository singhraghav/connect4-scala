import sbt._

object Dependencies {

  object V {
    val scalaTest = "3.2.17"
  }

  object Libraries {
    val scalaTest = "org.scalatest" %% "scalatest" % V.scalaTest
  }

}
