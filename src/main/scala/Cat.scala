@SerialVersionUID(100L)
class Cat(var name: String,
          var paws: Int,
          var legs: BigDecimal,
          var eyes: Seq[Int],
          var pur: Map[String, String]) extends Serializable {
}
