package com.retail_db

object Login extends App{

  var loginUsername:String = " "
  var loginPassword:String = " "

      println(s"${scala.Console.BOLD}")
      while(loginUsername != "adminUser" && loginPassword != "123") {
        print("clear")
        View.printLogo()
        println("LOGIN:  ")
        print("   Username: ")
        loginUsername = UserInput.userInputString()
        print("   Password: ")
        loginPassword = UserInput.userInputString()
        println(s"${scala.Console.RESET}")
      }
}
