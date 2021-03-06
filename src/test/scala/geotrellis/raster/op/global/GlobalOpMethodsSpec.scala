package geotrellis.raster.op.global

import geotrellis._
import geotrellis.raster._
import geotrellis.testutil._
import geotrellis.source._
import geotrellis.process._

import org.scalatest.FunSpec

class GlobalOpMethodsSpec extends FunSpec
                             with TestServer 
                             with RasterBuilders {
  describe("finding min and max") {
    it("Gets correct min and max for 3 x 2 tiles") {
      val rs1 = createRasterSource(
        Array( 1,1,1,      2,2,2,      3,3,3,
               1,1,1,      2,2,2,      3,3,3,

               4,4,4,      5,5,nd,      6,6,nd,
               4,4,4,      5,5,5,      6,6,6,

               7,7,7,      8,4,8,      9,9,9,
               7,1,7,      8,nd,8,      9,9,9,

              10,10,10,   11,11,11,   12,12,12,
              10,9,10,   11,20,11,   12,12,12
        ),
        3,4,3,2
      )
      get(rs1.min) should be (1)
      get(rs1.max) should be (20)
      get(rs1.minMax) should be ((1,20))
    }
  }
}
