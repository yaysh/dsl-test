ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.1.3"

val zioVersion = "2.0.2"
val zioQuillVersion = "4.3.0"
lazy val root = (project in file("."))
  .settings(
    name := "ScalaIdeaTest",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % zioVersion,
      "dev.zio" %% "zio-test" % zioVersion % Test,
      "dev.zio" %% "zio-test-sbt" % zioVersion % Test,
      "dev.zio" %% "zio-test-magnolia" % zioVersion % Test,
      "com.drewnoakes" % "metadata-extractor" % "2.18.0"
    )
  )

testFrameworks += new TestFramework(
  "zio.test.sbt.ZTestFramework"
)
