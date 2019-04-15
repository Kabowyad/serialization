import java.io._

import org.json4s._
import org.json4s.jackson.Serialization.write
import org.json4s.jackson.Serialization.read
import com.commodityvectors.messagepack.MessagePack
import MessagePack.auto._

object SerializationDemo extends App {
  val cat = new Cat("Kitty",
    1, BigDecimal(2.0), Seq(1,2,3), Map("foo" -> "bar"))
//  defaultSerialization(cat)
//  JsonSerialization(cat)
//  xmlSerialization(cat)

  def defaultSerialization(cat : Cat): Unit = {
    val oos = new ObjectOutputStream(new FileOutputStream("catNative"))
    time (oos.writeObject(cat), "defaultSerializationToFile")
    oos.close
    val ois = new ObjectInputStream(new FileInputStream("catNative"))
    val catFrom = time(ois.readObject.asInstanceOf[Cat], "defaultDeserializationFromFile")
    ois.close
  }

  def messagePackSerialization(cat: Cat) = {
    val data = MessagePack.pack(cat)

  }

//  def xmlSerialization(cat : Cat) = {
//    val xstream = XStreamConversions(new XStream(new DomDriver()))
//    val catXml = time(xstream.toXML(cat), "xmlSerialization")
//    val pw = new PrintWriter("catXml")
//    pw.write(catXml)
//    pw.close
//    val catFromXml: Cat = xstream.fromXML("catXml").asInstanceOf[Cat]
//    print(catFromXml.pur)
//  }

  def JsonSerialization(cat : Cat) = {
    implicit val formats = DefaultFormats
    val catJson = time(write(cat), "jsonSerializationToFile")
    val pw = new PrintWriter("catJson")
    pw.write(catJson)
    pw.close
    val catFromJson = time(read[Cat](catJson), "jsonDeserializationFromFile")
  }

  def time[R](block: => R, message: String): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println(message + " elapsed time: " + (t1 - t0) + " ns")
    result
  }
}

