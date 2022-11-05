object DSL {

  val date = OrderingAlternative.Date
  val source = "source"
  val dest = "dest"
  val images = FileType.Images
  enum OrderingAlternative:
    case Date, Size

  enum FileType:
    case Images, All

  case class Path(s: String)
  case class FiletypeAndSource(fileType: FileType, sourcePath: Path) {
    def to(destinationPath: String) = {
      FileMoveDetails(fileType, sourcePath, Path(destinationPath))
    }
  }

  case class FileMoveDetails(
      fileType: FileType,
      source: Path,
      dest: Path
  ) {
    def sortBy(orderingAlternative: OrderingAlternative) =
      val finalState = FinalState(orderingAlternative, source, dest, fileType)
      println(s"$finalState yeye")
  }

  case class FileTypeContainer(fileType: FileType) {
    def from(s: String) =
      FiletypeAndSource(fileType, Path(s))
  }
  case class Copy() {
    def all(fileType: FileType) =
      FileTypeContainer(fileType)
  }

  case class FinalState(
      order: OrderingAlternative,
      source: Path,
      dest: Path,
      fileType: FileType
  )
}
