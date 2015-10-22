package com.epam.service

import scala.io.Source

class Counter {
    val COMMENT = "//"
    
    var numberOfLines = 0
    def countLines(): Int = {
    	Source.fromFile("ClassToRead.scala").getLines().foreach { line =>
    		if (!line.isEmpty()) {
    		    val trimedLine = line.toString().trim()
    			
    		    if ((trimedLine.length() == 1) || (trimedLine.length() > 1 && trimedLine.substring(0,2) != COMMENT)) {
    		    	println(trimedLine)
    				numberOfLines += 1
    			}
    		}
    	}
    	return numberOfLines
    }
}