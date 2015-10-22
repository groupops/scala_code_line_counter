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

  def printResult(lines: List[String]): Unit = {
    print(lines.size)
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
    val withoutSingleLineComments = filterSingleLineComments(lines)
    filterMultilineComments(withoutSingleLineComments)
  }

  private def filterSingleLineComments(lines: List[String]): List[String] = {
    lines.filterNot(l => l.startsWith(SINGLE_LINE_COMMENT_PATTERN))
  }

  private def filterMultilineComments(lines: List[String]): List[String] = {
    lines.filterNot(_.matches(MULTILINE_COMMENT_PATTERN))
  }

}
