import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

def currentTime(): String = {
  val now = LocalDateTime.now()
  val formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm:ss")
  now.format(formatter)+" "+xFromScala+" " //+mul(23,2)
}
def add(a: Int, b: Int): Int = a + b

currentTime()