
lazy val commonSettings = Seq(
  organization := "com.softwaremill",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.6",
  scalacOptions ++= Seq("-unchecked", "-deprecation")
)

name := "akka-http-session"

val akkaHttp = "com.typesafe.akka" %% "akka-http-experimental" % "1.0-RC4"

lazy val rootProject = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(impl, example)

lazy val impl: Project = (project in file("impl"))
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      akkaHttp,
      "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
      "ch.qos.logback" % "logback-classic" % "1.1.3",
      "org.scalatest" %% "scalatest" % "2.2.4" % "test"
    )
  )

lazy val example: Project = (project in file("example"))
  .settings(commonSettings: _*)
  .dependsOn(impl)