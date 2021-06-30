package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by desenv4 on 30/06/2021.
 */
public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account account;

        System.out.println("Enter account number: ");
        int number =  sc.nextInt();
        System.out.println("Enter account holder");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.println("Is there an initial deposit (y/n)?");
        char response = sc.next().charAt(0);

        if (response == 'y'){
            System.out.println("Enter initial deposit value: ");
            double initDeposit = sc.nextDouble();
            account = new Account(number, holder, initDeposit);
        }else {
            account = new Account(number, holder);
        }

        System.out.println();
        System.out.println("Account data:");
        System.out.println(account);

    }


}
