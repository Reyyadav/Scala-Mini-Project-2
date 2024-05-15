  import scala.io.StdIn.readLine
  import scala.util.control.Breaks._
  import scala.util.Random
  
  object Main{

    var balance = 1000.0
    
    def main(args: Array[String]): Unit = {
      
      var Card_number = 12345
      var digital_pin = 1234
      
      var status = Take_Credentials(Card_number,digital_pin)
      
      
      if(status == "success")
      {
        get_transaction()
      }
      
    }
    def get_transaction():Unit={

      var input = ""
      do{
          show_menu()
          input = readLine("Enter your Options: ")
          operations(input)
      }
      while(input !="4" )
    }


    def show_menu():Unit={
      println("1. CHECK BALANCE")
      println("2. WITHDRAW CASH")
      println("3. DEPOSIT CASH")
      println("4. QUIT THE PROGRAM")
    }
    
    def operations(input:String):Unit={
          if (input == "1")
          {
            check_balance()
          }
          else if(input == "2")
          {
          var User_amount_withdraw = readLine("Enter the amount to withdraw: ").toInt
            withdraw_cash(User_amount_withdraw)
          }
          else if(input == "3")
          {
          var User_amount_deposit = readLine("Enter the amount to deposit: ").toInt
            deposit(User_amount_deposit)
          }

    }



     def Take_Credentials(Card_number:Int,digital_pin:Int):String={

      var status = "failed"

      breakable
      {
              for(w <- 1 to 3)
              {
              var User_card_number = readLine("Enter your card number: ").toInt
              var User_pin = readLine("Enter your pin: ").toInt

              if(User_card_number == Card_number && User_pin == digital_pin)
              {
                status = "success"
                println("Valid Informations,Welcome to ATM")
                break()
              }
              else 
              {
                println("Invalid card number or pin")
              }
              }
      }
      return status
    }

    def check_balance():Unit={
    println("Your balance is: ")
    println(balance)

    }
    def withdraw_cash(amount:Int):Unit={
      if(balance < amount)
      {
        println("Your balance is NOt Enough: ")
      }
      else
      {
         println("Amount has been deducted: ")
        balance = balance - amount
      }
    }
    def deposit(amount:Int):Unit={
      balance = balance + amount
      check_balance()
    }
  }
 