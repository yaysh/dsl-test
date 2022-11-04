object DSL {

  val date = SortingAlternative.Date
  val source = "source"
  val dest = "dest"

  enum SortingAlternative:
    case Date, Size

  enum FileType:
    case Images, All

  case class Path(p: String) {
    def to(s: String) = {
      TwoPaths(this, Path(s))
    }
  }

  case class TwoPaths(source: Path, dest: Path) {
    def sortBy(date: SortingAlternative) =
      val finalState = FinalState(date, source, dest)
      println(s"$finalState yeye")
  }

  case class Copy() {

    def from(s: String) =
      Path(s)
  }

  case class FinalState(order: SortingAlternative, source: Path, dest: Path)
}
