package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by desenv4 on 30/06/2021.
 */
public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("Entre com o nome do departamento: ");
        String departmentName = sc.nextLine();
        System.out.println("Entre com as informaçoes de trabalhador: ");
        System.out.println("digite o nome do trabalhador: ");
        String workerName = sc.nextLine();
        System.out.println("level:");
        String workerLevel = sc.nextLine();
        System.out.println("Salario Base: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary,new Department(departmentName));

        System.out.println("quantos contratos");
        int n = sc.nextInt();


        for (int i = 0; i < n; i++){
            System.out.println("Contrato: " + i);
            System.out.print("Data do contrato");
            Date contracDate = sdf.parse(sc.next());
            System.out.print("valor Hora");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duracao");
            int hors = sc.nextInt();
            HourContract contract = new HourContract(contracDate, valuePerHour, hors);
            worker.addContract(contract);
        }

        System.out.println("");
        System.out.println("entrew mes ano");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("nome" + worker.getName());
        System.out.println("departamento" + worker.getDepartment().getName());
        System.out.println("Lucro" + worker.income(year,month));



        sc.close();
    }

}
