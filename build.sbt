name := """blog-api"""
organization := "com.tosametal"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies ++= Seq(
  cacheApi
)
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "org.json4s" %% "json4s-native" % "3.5.3"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.45"
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "3.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.0"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.tosametal.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.tosametal.binders._"
