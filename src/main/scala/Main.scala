import DSL._

object Main {

  val Copy = new Copy

  @main def run =
    Copy from source to dest sortBy date
}
