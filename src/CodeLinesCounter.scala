import scala.io.{BufferedSource, Source}

class CodeLinesCounter {

  private val SINGLE_LINE_COMMENT_PATTERN = "//"
  private val MULTILINE_COMMENT_PATTERN = "\\/\\*.*|\\*.*|.*\\*\\/"

  def getLinesFromFile(path: String): List[String] = {
    val bufferedSource = readFile(path)
    getAllLines(bufferedSource)
  }

  def getNumberOfCodeLines(lines: List[String]): List[String] = {
    val trimmedLines = trim(lines)
    filterCodeLines(trimmedLines)
  }

  def printResult(message: String, lines: List[String]): Unit = {
    print(message + lines.size)
  }

  private def readFile(path: String): BufferedSource = {
    Source.fromFile(path)
  }

  private def getAllLines(bufferedSource: BufferedSource): List[String] = {
    val codeLines = bufferedSource.getLines().toList
    bufferedSource.close
    codeLines
  }

  private def trim(strings: List[String]) = strings.map(_.trim)

  private def filterCodeLines(lines: List[String]): List[String] = {
    val withoutEmptyLines = filterEmptyLines(lines)
    val withoutSingleLineComments = filterSingleLineComments(withoutEmptyLines)
    filterMultilineComments(withoutSingleLineComments)
  }

  private def filterEmptyLines(lines: List[String]): List[String] = {
    lines.filterNot(l => l.isEmpty)
  }

  private def filterSingleLineComments(lines: List[String]): List[String] = {
    lines.filterNot(l => l.startsWith(SINGLE_LINE_COMMENT_PATTERN))
  }

  private def filterMultilineComments(lines: List[String]): List[String] = {
    lines.filterNot(_.matches(MULTILINE_COMMENT_PATTERN))
  }

}
