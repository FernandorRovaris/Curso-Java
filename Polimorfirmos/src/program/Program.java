package program;

import entities.Employee;
import entities.OutsourcedEmployee;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by desenv4 on 02/07/2021.
 */
public class Program {

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter thr number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Employeee #" + i + " data");
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Hours:");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            if (ch == 'y'){
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                list.add(new OutsourcedEmployee(nome, hours, valuePerHour, additionalCharge));
            }else {
                list.add(new Employee(nome, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("PAYMENTS: ");

        for (Employee emp : list){
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }


        sc.close();
    }
}
