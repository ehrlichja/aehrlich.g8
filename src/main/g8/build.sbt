ThisBuild / organization := "$org$"
ThisBuild / scalaVersion := "2.13.1"

val awsVersion = "1.11.652"
val catsVersion = "2.0.0"
val circeVersion = "0.12.2"
val http4sVersion = "0.21.0-M5"
val zioVersion = "1.0.0-RC14"

enablePlugins(JavaAppPackaging, DockerPlugin)
addCompilerPlugin("org.scalameta" % "semanticdb-scalac" % "4.2.3" cross CrossVersion.full)
addCompilerPlugin(scalafixSemanticdb)
addCommandAlias(
  "scalafixCheck",
  "; compile:scalafix --check ; test:scalafix --check"
)

commands += Command.command("build") { state => 
  "scalafixCheck" :: "unusedCompileDependencies" :: "compile" :: state 
}

lazy val root = (project in file(".")).
  settings(
    name := "$name$",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
    libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.12.1",
    libraryDependencies += "dev.zio" %% "zio" % zioVersion,
    libraryDependencies += "dev.zio" %% "zio-interop-cats" % "2.0.0.0-RC5",
    libraryDependencies += "org.typelevel" %% "cats-core" % catsVersion,
    libraryDependencies += "org.typelevel" %% "cats-effect" % catsVersion,
    libraryDependencies += "org.typelevel" %% "cats-mtl-core" % "0.7.0",
    libraryDependencies += "org.http4s" %% "http4s-dsl" % http4sVersion,
    libraryDependencies += "org.http4s" %% "http4s-blaze-client" % http4sVersion,
    libraryDependencies += "org.http4s" %% "http4s-blaze-client" % http4sVersion,
    libraryDependencies += "org.http4s" %% "http4s-circe" % http4sVersion,
    libraryDependencies += "io.circe" %% "circe-generic" % circeVersion,
    libraryDependencies += "io.circe" %% "circe-parser" % circeVersion,
    libraryDependencies += "io.circe" %% "circe-literal" % circeVersion,
    libraryDependencies += "com.twilio.sdk" % "twilio" % "7.42.0",
    libraryDependencies += "com.amazonaws" % "aws-java-sdk-s3" % awsVersion,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test",
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1" % "test",
    libraryDependencies += "dev.zio" %% "zio-test" % zioVersion,
    libraryDependencies += "dev.zio" %% "zio-test-sbt" % zioVersion,
    mainClass in Compile := Some("$package$.Main"),
    scalacOptions ++= Seq(
      "-deprecation",
      "-explaintypes",
      "-feature",
      "-language:implicitConversions",
      "-language:higherKinds",
      "-language:existentials",
      "-language:postfixOps",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xlint:adapted-args,nullary-unit,inaccessible,nullary-override,infer-any,missing-interpolator,doc-detached,private-shadow,type-parameter-shadow," +
      "poly-implicit-overload,option-implicit,delayedinit-select,package-object-classes,stars-align,constant,unused,nonlocal-return,implicit-not-found,serial,valpattern,eta-zero," +
      "eta-sam,deprecation",
      "-Wunused:imports,patvars,privates,locals,explicits,implicits,params,linted",
      "-Ywarn-unused",
      "-Yrangepos"
    ),
    testFrameworks ++= Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
    dockerExposedPorts := Seq(8080),
    dockerRepository := None
  )
