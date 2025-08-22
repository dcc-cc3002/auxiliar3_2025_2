ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "Auxiliar3_2025_2"
  )

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
