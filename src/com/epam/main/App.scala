import scala.io.Source
import com.epam.service.Counter

object App {
    def main(args: Array[String]) {
        println("Following is the content read:")

        val counter = new Counter()
        val numberOfLines = counter.countLines()

        println("Number of code lines = " + numberOfLines)
    }
}