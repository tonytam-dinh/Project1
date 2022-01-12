package com.data_request

import net.liftweb.json.DefaultFormats
import net.liftweb.json._
import java.io._

object ParseJson extends App{
  val pw = new PrintWriter(new File("C:\\Users\\Tony\\IdeaProjects\\Project1\\src\\BookData\\test3.txt" ))
  implicit val formats = DefaultFormats
  requestTest.main(null)
  val jsonString = requestTest.temp40
  val json = parse(jsonString)
  val volumeInfo = (json \\ "volumeInfo").children

  for (acct <- volumeInfo) {
    try {
      val m = acct.extract[BookData]
      val authors = m.authors.mkString(" and ")
      val writeString = s"${m.title},${authors},${m.publishedDate},${m.pageCount},${m.averageRating},${m.ratingsCount},${m.publisher} \n"
      pw.write(writeString)
    }
    catch{
      case e: Exception => null
    }
  }
  val jsonString2 = requestTest.temp80
  val json2 = parse(jsonString2)
  val volumeInfo2 = (json2 \\ "volumeInfo").children

  for (acct <- volumeInfo2) {
    try {
      val m = acct.extract[BookData]
      val authors = m.authors.mkString(" and ")
      val writeString = s"${m.title},${authors},${m.publishedDate},${m.pageCount},${m.averageRating},${m.ratingsCount},${m.publisher} \n"
      pw.write(writeString)
    }
    catch{
      case e: Exception => null
    }
  }
  val jsonString3 = requestTest.temp120
  val json3 = parse(jsonString3)
  val volumeInfo3 = (json3 \\ "volumeInfo").children

  for (acct <- volumeInfo3) {
    try {
      val m = acct.extract[BookData]
      val authors = m.authors.mkString(" and ")
      val writeString = s"${m.title},${authors},${m.publishedDate},${m.pageCount},${m.averageRating},${m.ratingsCount},${m.publisher} \n"
      pw.write(writeString)
    }
    catch{
      case e: Exception => null
    }
  }
  val jsonString4 = requestTest.temp160
  val json4 = parse(jsonString4)
  val volumeInfo4 = (json4 \\ "volumeInfo").children

  for (acct <- volumeInfo4) {
    try {
      val m = acct.extract[BookData]
      val authors = m.authors.mkString(" and ")
      val writeString = s"${m.title},${authors},${m.publishedDate},${m.pageCount},${m.averageRating},${m.ratingsCount},${m.publisher} \n"
      pw.write(writeString)
    }
    catch{
      case e: Exception => null
    }
  }
  pw.close()
}

