package mylistener

import org.apache.spark.sql.SparkSession
import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec

trait SparkSessionSetup extends AnyFlatSpec with Matchers {
  def withSparkSession(testMethod: (SparkSession) => Any): Unit = {
    val spark = SparkSession
      .builder()
      .master("local")
      .appName("Test")
      .config("spark.ui.config", value = false)
      .config("spark.extraListeners", "mylistener.MyListener")
      .getOrCreate()
    testMethod(spark)
  }
}
