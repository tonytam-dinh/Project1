package com.data_request
import scala.io.Source.fromURL
import scala.io.Source.fromInputStream

object requestTest extends App {

  @throws(classOf[java.io.IOException])
  @throws(classOf[java.net.SocketTimeoutException])
  def get(url: String, connectTimeout: Int = 5000, readTimeout: Int = 5000, requestMethod: String = "GET") = {
    import java.net.{URL, HttpURLConnection}
    val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]
    connection.setConnectTimeout(connectTimeout)
    connection.setReadTimeout(readTimeout)
    connection.setRequestMethod(requestMethod)
    val inputStream = connection.getInputStream
    val content = fromInputStream(inputStream).mkString
    if (inputStream != null) inputStream.close
    content
  }
//AIzaSyD1sCMABciAUgQiL0SFAi54UbyvL4UWmfU
  Thread.sleep(2000)
  var temp40 = get("https://www.googleapis.com/books/v1/volumes?q=subject:fiction&printType=books&maxResults=40&orderBy=newest&key=AIzaSyD1sCMABciAUgQiL0SFAi54UbyvL4UWmfU")
  Thread.sleep(2000)
  var temp80 = get("https://www.googleapis.com/books/v1/volumes?q=subject:fiction&printType=books&maxResults=40&orderBy=newest&startIndex=40&key=AIzaSyD1sCMABciAUgQiL0SFAi54UbyvL4UWmfU")
  Thread.sleep(2000)
  var temp120 = get("https://www.googleapis.com/books/v1/volumes?q=subject:fiction&printType=books&maxResults=40&orderBy=newest&startIndex=80&key=AIzaSyD1sCMABciAUgQiL0SFAi54UbyvL4UWmfU")
  Thread.sleep(2000)
  var temp160 = get("https://www.googleapis.com/books/v1/volumes?q=subject:fiction&printType=books&maxResults=40&orderBy=newest&startIndex=120&key=AIzaSyD1sCMABciAUgQiL0SFAi54UbyvL4UWmfU")

}
