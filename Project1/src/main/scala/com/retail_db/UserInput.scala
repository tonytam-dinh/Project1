package com.retail_db
import scala.io.StdIn.{readInt, readLine, readDouble}

object UserInput {

    def userInputInt(): Int = {

      var intReader: Int = -1
      try{
        intReader = readInt()
      }
      catch{
        case e: Exception => null
      }
      return intReader
    }
    def userInputString(): String = {
      var stringReader: String = " "
      try{
        stringReader = readLine()
      }
      catch{
        case e: Exception => null
      }
      return stringReader
    }
    def userInputDouble(): Double = {
      var doubleReader: Double = -1.11
      try{
        doubleReader = readDouble()
      }
      catch{
        case e: Exception => null
      }
      return doubleReader
    }

}
