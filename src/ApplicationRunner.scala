object ApplicationRunner {
  def main(args: Array[String]) {
    val application = new CodeLinesCounter
    val lines = application.getLinesFromFile("resources\\testFile1.txt")
    val codeLines = application.getNumberOfCodeLines(lines)
    application.printResult("Number of code lines: ", codeLines)
  }
}
