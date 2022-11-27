import java.util.*;
class Account
{
    String Name;
    String User_name;
    String Passwd;
    String Account;
    float balnc = 0.0f;
    int transaction = 0;

    public Account(String c, String d, String e, String f) //parameterized constructor for registering the account of the customer
    {
        Name = c;
        User_name = d;
        Passwd = e;
        Account  = f;
        System.out.println("Account Created Successfully\n");
    }
    public boolean signin()
     {
         boolean isLogin = false;
         Scanner sc = new Scanner(System.in);
             System.out.print("\nEnter Your Username - ");
             String Username = sc.nextLine();
             if ( Username.equals(User_name) ) {
                     System.out.print("\nEnter Your Password - ");
                     String pass = sc.nextLine();
                     if ( pass.equals(pass) ) {
                         System.out.print("\n!!Logined successful!!");
                         isLogin = true;
                     }
                     else {
                         System.out.println("\n@Incorrect Password@");
                     }

             }
             else {
                 System.out.println("Username not found\n");

         }
         return isLogin;

    }
    public void deposit()
    {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter amount to deposit:\n");
        float money = sc.nextFloat();
        if(money <= 0.0)
        {
            System.out.println("Enter valid amount\n");
            transaction++;

        }
        else {
            balnc = balnc + money;
            System.out.println(money + " deposited successfully\n");
            transaction++;

        }


    }
    public void current_bal()
    {
        System.out.println("Your current balance is " + balnc + " rupees only\n");
        transaction++;
    }
    public void transaction_history()
    {
        System.out.println("Transactions done in this session is " + transaction);
    }
    public void transfer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the recepient name : \n");
        String receiver = sc.nextLine();
        System.out.println("Enter the amount to be transferred: \n");
        float transfer_amount = sc.nextFloat();
        if(transfer_amount > 0 && balnc > transfer_amount) {
            System.out.println("Enter the Account Number of the recepient:\n");
            String receiver_acc = sc.next();
            balnc = balnc - transfer_amount;
            System.out.println("Amount " + transfer_amount + " transferred successfully");
            transaction++; 
        }
        else
        {
            System.out.println("Your current balance is low or enter the valid amount\n");
            transaction++;
        }

    }
    public void withdrawl()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdrawl : \n");
        float withdraw = sc.nextFloat();
        if(withdraw >= balnc)
        {
            System.out.println("Low Balance!!!" + "" + "\n");
        }
        else
        {
            System.out.println(withdraw + " withdrawn successfully\n");
            balnc = balnc - withdraw;
        }
    }


}

public class AtmInterface {
    public static void main(String args[])
    {
        System.out.println("Welcome to the DDFC Bank!!!");
        boolean operation = false;

            System.out.println("Enter your choice: \n1.Banking \n2.Exit\n");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Enter your name:\n");
                String name = sc.next();
                System.out.println("\n");
                System.out.println("Enter the user name:\n");
                String usr_nm = sc.next();
                System.out.println("Enter the password:\n");
                String pwd = sc.next();
                System.out.println("Enter your account number:\n");
                String accn = sc.next();
                Account a = new Account(name, usr_nm, pwd, accn);
                System.out.println("Do you want to login: Yes/No\n");
                String want = sc.next();
                if (want.equalsIgnoreCase("Yes")) {
                    if (a.signin()) {
                        System.out.println("Please select the banking options\n");
                        boolean finished = false; 
                        while (!finished) {
                            System.out.println("\n1.Deposit \n2.Withdrawl \n3. Bank Balance  \n4.Transactions \n 5.Transfer \n");
                            int opt = sc.nextInt();
                            switch (opt) {
                                case 1:
                                    a.deposit();
                                    break;
                                case 2:
                                    a.withdrawl();
                                    break;
                                case 3:
                                    a.current_bal();
                                    break;
                                case 4:
                                    a.transaction_history();
                                    break;
                                case 5:
                                    a.transfer();
                                    break;
                                default:
                                    finished = true;
                                    operation = true;
                                    break;

                            }
                        }
                    }

                } else {
                    System.out.println("Thank You! and Have a nice day!!!\n");
                }

            } else {
                System.out.println("Thank You! Have a nice day\n");
            }

    }
}
