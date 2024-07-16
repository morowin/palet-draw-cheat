val appVersion = "0.1.0-SNAPSHOT"

val catsVersion = "2.12.0"
val catsEffectVersion = "3.5.4"
val circeVersion = "0.14.9"
val doobieVersion = "1.0.0-RC5"
val mockitoScalaVersion = "1.17.22"
val scalatestVersion = "3.2.16"
val tapirVersion = "0.18.3"

val cats = Seq(
  "org.typelevel" %% "cats-core" % catsVersion,
  "org.typelevel" %% "cats-effect" % catsEffectVersion
)

val circe = Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion
)

val doobie = Seq(
  "org.tpolecat" %% "doobie-core" % doobieVersion,
  "org.tpolecat" %% "doobie-postgres" % doobieVersion,
  "org.tpolecat" %% "doobie-postgres-circe" % doobieVersion,
  "org.tpolecat" %% "doobie-hikari" % doobieVersion,
  "org.tpolecat" %% "doobie-scalatest" % doobieVersion % Test
)

lazy val commonSettings = Seq(
  organization := "fr.morowin.pdc",
  version := appVersion,
  scalaVersion := "2.13.14",
  scalacOptions -= "-language:experimental.macros",
  scalacOptions += "-language:higherKinds",
  scalacOptions += "-Ymacro-annotations",
  credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
  libraryDependencies ++= cats ++ circe ++ Seq(
    "org.scalactic" %% "scalactic" % scalatestVersion,
    "org.scalatest" %% "scalatest" % scalatestVersion % Test,
    "org.mockito" %% "mockito-scala" % mockitoScalaVersion % Test
  ),
  addCompilerPlugin(
    "org.typelevel" %% "kind-projector" % "0.13.3" cross CrossVersion.full
  )
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(name := "palet-draw-cheat")
