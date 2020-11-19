package com.samples.ie

import com.samples.common.Product
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.insightedge.spark.context.InsightEdgeConfig
//import org.insightedge.spark.implicits.all._
import org.insightedge.spark.implicits.basic._

import com.samples.common.Car
import com.samples.common.Cellphone


object SaveToGridExample {
  def main(args: Array[String]): Unit = {

    println("Executing job")

    // See: https://github.com/InsightEdge/insightedge-examples/tree/master/src/main/scala/org/insightedge/examples/basic
    val initConfig = InsightEdgeConfig.fromSparkConf(new SparkConf())

    val settings = Array( new SparkConf().get("spark.master", InsightEdgeConfig.SPARK_MASTER_LOCAL_URL_DEFAULT),
      initConfig.spaceName)

    val Array(master, space) = settings
    val ieConfig = initConfig.copy(spaceName = space)

    println(s"master: $master")
    println(s"space: $space")

    val spark = SparkSession.builder
      .appName("SaveToGridExample")
      .master(master)
      .insightEdgeConfig(ieConfig)
      .getOrCreate()


    val sc = spark.sparkContext

    var car = new Car
    car.setModel("Honda")
    car.setName("Odyssey")
    car.setId(1)
    car.setCode("12341")

    var car1 = new Car
    car1.setModel("Toyota")
    car1.setName("Camry")
    car1.setId(2)
    car1.setCode("12342")

    var car2 = new Car
    car2.setModel("Ford")
    car2.setName("F-150")
    car2.setId(3)
    car2.setCode("12343")

    var cellphone = new Cellphone
    cellphone.setBrand("Apple")
    cellphone.setModel("iPhone 11")
    cellphone.setCode("671")
    cellphone.setId(1)
    cellphone.setName("Apple iphone 11")

    var cellphone1 = new Cellphone
    cellphone1.setBrand("Samsung")
    cellphone1.setModel("Galaxy S10")
    cellphone1.setCode("672")
    cellphone1.setId(2)
    cellphone1.setName("Samsung Galaxy S10")


    val arr = Array(car, car1, car2, cellphone, cellphone1)

    val rdd = sc.parallelize(arr)

    rdd.saveToGrid()

    //spark.stop()
    spark.stopInsightEdgeContext()
  }
}
