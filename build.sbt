name := "shared-test"

lazy val root = project.in(file(".")).
  aggregate(sharedJVM, sharedJS).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val shared = crossProject.in(file(".")).
  settings(
    name := "shared",
    version := "0.1",
    scalaVersion := "2.11.6"
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      "com.lihaoyi" %% "upickle" % "0.2.8"
    )
  )
  .jsSettings(
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "upickle" % "0.2.8"
    )
  )

lazy val sharedJVM = shared.jvm
lazy val sharedJS = shared.js
