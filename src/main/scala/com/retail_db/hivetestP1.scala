package com.retail_db

import org.apache.spark.sql.SparkSession

  object hivetestP1 {
    def main(args: Array[String]): Unit = {
      // create a spark session
      // for Windows
      //System.setProperty("hadoop.home.dir", "C:\\winutils")
      System.setProperty("hadoop.home.dir", "C:\\hadoop")
      val spark = SparkSession
        .builder
        .appName("hello hive")
        .config("spark.master", "local")
        .enableHiveSupport()
        .getOrCreate()
      println("created spark session")
      spark.sparkContext.setLogLevel("ERROR")

      spark.sql("DROP table IF EXISTS book")
      spark.sql("create table IF NOT EXISTS book(bookTitle String,bookAuthor String,pageCount Int,averageRating Double,ratingCount Int, publisher String ) row format delimited fields terminated by ','")
      spark.sql("LOAD DATA LOCAL INPATH 'test.txt' INTO TABLE book")
      //spark.sql("SELECT * FROM book").show()

      spark.sql("DROP table IF EXISTS users")
      spark.sql("create table IF NOT EXISTS users(username String,password String,adminOrBasic String) row format delimited fields terminated by ','")
      spark.sql("LOAD DATA LOCAL INPATH 'users.txt' INTO TABLE users")
      //spark.sql("SELECT * FROM users").show()

      Login.main(null)
      var mainIntInput = -1
      while(mainIntInput != 0){
        println("clear")
        View.printLogo()
        View.printMainMenu()
        print("Input: ")
        mainIntInput = UserInput.userInputInt()

        if(mainIntInput == 1){
          var accountIntInput = -1
          while(accountIntInput != 0){
            println("clear")
            View.printLogo()
            View.printAccountMenu()
            print("Input: ")
            accountIntInput = UserInput.userInputInt()
            if(accountIntInput == 1){
              print("[New UserName]: ")
              val accountUser = UserInput.userInputString()
              print("[New Password]: ")
              val accountPass = UserInput.userInputString()
              print("[Account Type]: ")
              val accountType = UserInput.userInputString()
              spark.sql(s"INSERT INTO users VALUES('$accountUser','$accountPass','$accountType')")
            }
            else if (accountIntInput ==2 ){
              spark.sql("SELECT * FROM users").show()
              print("[Enter] To Continue...")
              val temp = UserInput.userInputInt()
            }
            else if (accountIntInput ==3){
              print("[Current UserName]: ")
              val accountUser = UserInput.userInputString()
              print("[Current Password]: ")
              val accountPass = UserInput.userInputString()
              print("    [New Password]: ")
              val accountNewPass = UserInput.userInputString()
              val accountExists = spark.sql(s"SELECT COUNT(*) FROM users WHERE username = '$accountUser' AND password = '$accountPass'").collect()
              if(accountExists(0)(0) == 1){
                val temp = spark.sql(s"SELECT * FROM users WHERE username = '$accountUser' AND password = '$accountPass'").collect()
                val user = temp(0)(0)
                val privil = temp(0)(2)
                spark.sql("CREATE TABLE temp(username STRING, password STRING, adminOrBasic STRING)")
                spark.sql(s"INSERT INTO temp SELECT * FROM users WHERE username <> '$accountUser'")
                spark.sql("DROP TABLE users")
                spark.sql("ALTER TABLE temp RENAME TO users")
                spark.sql(s"INSERT INTO users VALUES('$user','$accountNewPass','$privil')")

              }
            }
          }

        }
        else if(mainIntInput == 2){
          var analysisIntInput = -1
          while(analysisIntInput != 0) {
            println("clear")
            View.printLogo()
            View.printAnalysisMenu()
            print("Input: ")
            analysisIntInput = UserInput.userInputInt()
            if(analysisIntInput ==1){
              spark.sql("SELECT bookTitle, bookAuthor, averageRating FROM book ORDER BY averageRating DESC LIMIT 5").show()
              print("[Enter] To Continue...")
              val temp = UserInput.userInputInt()
            }
            else if(analysisIntInput ==2){
              spark.sql("SELECT bookTitle, bookAuthor, ratingCount FROM book ORDER BY ratingCount DESC LIMIT 5").show()
              print("[Enter] To Continue...")
              val temp = UserInput.userInputInt()
            }
            else if(analysisIntInput ==3){
              spark.sql("SELECT bookTitle, bookAuthor, pageCount FROM book ORDER BY pageCount DESC LIMIT 5").show()
              print("[Enter] To Continue...")
              val temp = UserInput.userInputInt()
            }
            else if(analysisIntInput ==4){
              spark.sql("SELECT bookTitle, bookAuthor, averageRating FROM book ORDER BY averageRating ASC LIMIT 5").show()
              print("[Enter] To Continue...")
              val temp = UserInput.userInputInt()
            }
            else if(analysisIntInput ==5){
              spark.sql("SELECT publisher, count(bookTitle) FROM book GROUP BY publisher ORDER BY COUNT(bookTitle) DESC LIMIT 5").show()
              print("[Enter] To Continue...")
              val temp = UserInput.userInputInt()
            }
            else if(analysisIntInput ==6){
              spark.sql("SELECT bookTitle, bookAuthor, ratingCount FROM book ORDER BY ratingCount ASC LIMIT 5").show()
              print("[Enter] To Continue...")
              val temp = UserInput.userInputInt()
            }
          }
        }

      }

      spark.close()
    }
}
