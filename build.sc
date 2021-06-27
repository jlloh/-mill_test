import mill._, scalalib._
import mill.modules.Assembly

object MyListener extends ScalaModule {
  def scalaVersion = "2.12.13"

  def sparkVersion = "2.4.4"

  def commonIvy = Agg(
    ivy"org.apache.spark::spark-sql:${sparkVersion}",
    ivy"org.apache.spark::spark-hive:${sparkVersion}",
    ivy"org.apache.spark::spark-core:${sparkVersion}"
  )

  def ivyDeps = commonIvy

  def assemblyRules = Assembly.defaultRules ++
    Seq("scala/.*", "org\\.apache\\.spark/.*")
      .map(Assembly.Rule.ExcludePattern.apply)

  object test extends Tests with TestModule.ScalaTest {
    def ivyDeps = Agg(
      ivy"org.scalatest::scalatest:3.1.1"
    ) ++ commonIvy
  }
}
