package eleflow.uberdata.core.util

/**
  * Created by dirceu on 10/08/16.
  */
object ClusterSettings {

  /**
    * This config will transform every double values from the input to a BigDecimal value
    */
  var enforceDoublePrecision:Boolean = false
  var defaultDecimalScale: Int = 18
  var defaultDecimalPrecision: Int = 38
  var serializer: Option[String] = None
  var kryoBufferMaxSize: Option[String] = None
  var maxResultSize = "2g"
  var masterInstanceType = "r3.large"
  var coreInstanceType = "r3.large"
  var coreInstanceCount = 4
  var spotPriceFactor: Option[String] = Some("1.3")
  var ec2KeyName: Option[String] = None
  var hadoopVersion = "2"
  var appName = "IUberdata"
  var clusterName = "IUberdataApplication"
  var region: Option[String] = None
  var profile: Option[String] = None
  var resume = false
  var executorMemory: Option[String] = None
  var defaultParallelism: Option[Int] = None
  var master: Option[String] = None
  var baseDir: String = "/tmp"
  var localDir: String = "/tmp"
  val additionalConfs: scala.collection.mutable.Map[String,String] = scala.collection.mutable.Map.empty

  def setMaster(mas: String) = {
    master = Some(mas)
  }

  def getNumberOfCores = ClusterSettings.coreInstanceCount * slavesCores

  def slavesCores = ClusterSettings.coreInstanceType match {
    case s: String if s.endsWith("xlarge") => 4
    case s: String if s.endsWith("2xlarge") => 8
    case s: String if s.endsWith("4xlarge") => 16
    case s: String if s.endsWith("8xlarge") => 32
    case _ => 2
  }
}

