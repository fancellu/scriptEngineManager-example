package com.felstar.scriptEngine

import java.io.PrintWriter
import javax.script._

import java.io.Writer

class Console(val writer: Writer=new PrintWriter(System.out)) {
  def log(message: String): Unit = {
    try {
      writer.write(message + "\n")
      writer.flush()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}

object JSApp extends App {

  val engine = new ScriptEngineManager().getEngineByName("JavaScript")

  engine.put("xFromScala","I am injected from Scala")

  val script=readFile("src/main/scala/javascript.js")

  val out=engine.eval( script)
  println(out)

  println("2+3=="+engine.eval("add(2,3)"))
  println("2+3=="+engine.eval("2+3"))

  engine.put("xFromScala","I am injected from Scala, again")

  val out2 = engine.eval(script)
  println(out2)

  def display(message: String): Unit = {
    System.out.println("!!!!!")
    System.out.println(message)
  }
  engine.put("JSApp", this)
  engine.eval("function callMethod(x) { JSApp.display('Hello from JavaScript! x='+x); }")

    // js engine is invocable
  val invocable = engine.asInstanceOf[Invocable]
  invocable.invokeFunction("callMethod", 123)

  // JavaScript from ScriptEngineManager doesn't have console, so we need to provide our own function

  engine.put("console", new Console())
  engine.eval(""" console.log('hello') """)

}
