package com.felstar

import scala.io.Source

package object scriptEngine {
  def readFile(filePath: String): String = {
    val source = Source.fromFile(filePath)
    val lines = source.getLines().mkString("\n")
    source.close()
    lines
  }
}
