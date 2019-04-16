name := "serialization"

version := "0.1"

scalaVersion := "2.12.8"

// https://mvnrepository.com/artifact/org.json4s/json4s-jackson
libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.6.0"
// https://mvnrepository.com/artifact/com.thoughtworks.xstream/xstream
libraryDependencies += "com.thoughtworks.xstream" % "xstream" % "1.4.10"
libraryDependencies += "org.msgpack" %% "msgpack-scala" % "0.8.13"
resolvers += Resolver.bintrayRepo("commodityvectors", "commodityvectors-releases")

libraryDependencies += "com.commodityvectors" %% "messagepack" % "1.0.0"
libraryDependencies += "com.lihaoyi" %% "upickle" % "0.7.1"
libraryDependencies += "io.circe" %% "circe-yaml" % "0.8.0"
libraryDependencies += "net.jcazevedo" %% "moultingyaml" % "0.4.0"

libraryDependencies += "com.thesamet.scalapb" %% "compilerplugin" % "0.8.4"
