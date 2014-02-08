package geotrellis

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SortArrayTest extends FunSuite with ShouldMatchers {

 test("SortArrayTest") {

    val arr = Array((for(i <- 0 to 99) yield scala.util.Random.nextInt): _*)
    scala.util.Sorting.quickSort(arr)

	for(a <- 0 until 99) {
		arr(a) should be <= arr(a + 1)
	}
 }
}