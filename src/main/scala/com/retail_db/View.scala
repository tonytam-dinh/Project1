package com.retail_db

object View {

  def printLogo(): Unit = {
    print(s"${scala.Console.CYAN}")
    val logo =
      """
        |##########################################################################################
        |#   /$$$$$$$$ /$$$$$$$              /$$$$$$$                      /$$                    #
        |#  |__  $$__/| $$__  $$            | $$__  $$                    | $$                    #
        |#     | $$   | $$  \ $$            | $$  \ $$  /$$$$$$   /$$$$$$ | $$   /$$  /$$$$$$$    #
        |#     | $$   | $$  | $$            | $$$$$$$  /$$__  $$ /$$__  $$| $$  /$$/ /$$_____/    #
        |#     | $$   | $$  | $$            | $$__  $$| $$  \ $$| $$  \ $$| $$$$$$/ |  $$$$$$     #
        |#     | $$   | $$  | $$            | $$  \ $$| $$  | $$| $$  | $$| $$_  $$  \____  $$    #
        |#     | $$   | $$$$$$$/            | $$$$$$$/|  $$$$$$/|  $$$$$$/| $$ \  $$ /$$$$$$$/    #
        |#     |__/   |_______/             |_______/  \______/  \______/ |__/  \__/|_______/     #
        |##########################################################################################
      """.stripMargin
    println(logo)
    print(s"${scala.Console.RESET}")
  }

  def printAccountMenu(): Unit = {
    println(s"${scala.Console.BOLD}")
    println("ACCOUNT MENU:  ")
    println("   [1] INSERT USER")
    println("   [2] VIEW USER")
    println("   [3] UPDATE PASS")
    println("   [0] EXIT")
    println(s"${scala.Console.RESET}")
  }
  def printMainMenu(): Unit = {
    println(s"${scala.Console.BOLD}")
    println("MAIN MENU")
    println("   [1] MANAGE ACCOUNTS")
    println("   [2] BOOK ANALYSIS")
    println("   [0] EXIT")
    println(s"${scala.Console.RESET}")
  }
  def printAnalysisMenu(): Unit = {
    println(s"${scala.Console.BOLD}")
    println("ANALYSIS MENU")
    println("   [1] HIGHEST AVG RATINGS")
    println("   [2] MOST POPULAR")
    println("   [3] GREATEST PAGE COUNT")
    println("   [4] LOWEST AVG RATING")
    println("   [5] PUBLISHER BOOK COUNT")
    println("   [6] LOWEST RATING COUNT")
    println("   [0] EXIT")
    println(s"${scala.Console.RESET}")
  }

}
