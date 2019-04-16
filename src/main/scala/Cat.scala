import net.jcazevedo.moultingyaml.DefaultYamlProtocol
import upickle.default.{macroRW, ReadWriter => RW}

@SerialVersionUID(100L)
case class Cat(var name: String,
          var paws: Int,
          var legs: BigDecimal,
          var eyes: Seq[Int],
          var pur: Map[String, String]) extends Serializable {
}

object Cat {
  implicit val rw: RW[Cat] = macroRW
}
