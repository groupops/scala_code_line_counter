package com.epam.training.scala

import java.nio.file.{Files, Paths}

import scala.io.Source


/**
 * Created by Dmytro_Ulanovych on 10/21/2015.
 */
class CodeLinesCounter(private val filePath: String) {
  private val COMMENTS_PATTERN: String = "((['\"])(?:(?!\\2|\\\\).|\\\\.)*\\2)|\\/\\/[^\\n]*|\\/\\*(?:[^*]|\\*(?!\\/))*\\*\\/"
  private val EMPTY_LINE_PATTERN: String = "(?m)^[ \t]*\r?\n"

  def calculate(): Int = {
    var file = readFile()
    file = removeComments(file)
    file = removeEmptyLines(file)
    file.count(character => character == '\n')
  }

  private def readFile(): String = {
    var text: String = ""
    if (Files.exists(Paths.get(filePath))) {
      val source = Source.fromFile(filePath)
      text = try source.mkString finally source.close()
    }
    text
  }

  private def removeComments(text: String): String = {
    text.replaceAll(COMMENTS_PATTERN, "")
  }

  private def removeEmptyLines(text: String): String = {
    text.replaceAll(EMPTY_LINE_PATTERN, "")
  }
}
/*
*
* tEST COMMENT
* */

object CodeLinesCounter {
  def main(args: Array[String]) {
    val sampleFilePath: String = "D:\\projects\\scala-code-lines\\src\\main\\scala\\com\\epam\\training\\scala\\CodeLinesCounter.scala"
    def linesCounter = new CodeLinesCounter(sampleFilePath)
    println("Total count of lines: " + linesCounter.calculate())
  }
}