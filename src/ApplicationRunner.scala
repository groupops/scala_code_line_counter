object ApplicationRunner {
  def main(args: Array[String]) {
    val application = new CodeLinesCounter
    val lines = application.getLinesFromFile("resources\\testFile.txt")
    val codeLines = application.getNumberOfCodeLines(lines)
    application.printResult(codeLines)
  }
}
