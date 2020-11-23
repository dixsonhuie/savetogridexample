package com.samples.ie


import com.samples.common.{Car, Cellphone, Product}

import org.apache.spark
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.insightedge.spark.context.InsightEdgeConfig
//import org.insightedge.spark.implicits.all._
import org.insightedge.spark.implicits.basic._

object ReadFromGridExample {
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
      .appName("ReadFromGridExample")
      .master(master)
      .insightEdgeConfig(ieConfig)
      .getOrCreate()


    val sc = spark.sparkContext

    val rdd = sc.gridRdd[Product]()

    val javaRdd  = rdd.toJavaRDD()
    
    println("rdd.count is: " + rdd.count())

    println("About to print rdd")
    rdd.collect().foreach(p => println(p.getName()))
    
    println("About to print rdd concrete classes")
    rdd.collect().foreach(p => p match {
      case p: Cellphone => println(p.getBrand())
      case p: Car       => println(p.getMake())
    })


    println("About to print Java rdd")
    import scala.collection.JavaConversions._
    for (p <- javaRdd.collect) {
      System.out.println(p.getName)
    }


    //spark.stop()
    spark.stopInsightEdgeContext()
  }
}
