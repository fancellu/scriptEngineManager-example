package com.felstar.scriptEngine

import java.io.PrintWriter
import javax.script._

object ScalaScriptApp extends App {

   // ScalaScript engine is not invocable
  val engine = new ScriptEngineManager().getEngineByName("scala")

  engine.put("xFromScala","I am injected from Scala")

  val script=readFile("src/main/scala/scalaScript.sc")

  println(engine.eval(script))

  println("2+3=="+engine.eval("add(2,3)"))

  println("2+3=="+engine.eval("2+3"))

  engine.put("xFromScala","I am injected from Scala, again")

  println(engine.eval(script))

  // This tells it to send its output to stdout, else the output will not be seen
  // We could capture in a StringWriter too

 val writer = new PrintWriter(System.out)
 engine.getContext().setWriter(writer)
 engine.eval(""" println("hello") """)
 writer.flush()

}
