package mylistener

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MyTest extends AnyFlatSpec with Matchers with SparkSessionSetup {
  "this" should "that" in withSparkSession(spark => {
    import spark.implicits._
    val testDF = Seq(("a", 1), ("b", 2)).toDF("col1", "col2")
    testDF.show()
    testDF.count()
  })
}
