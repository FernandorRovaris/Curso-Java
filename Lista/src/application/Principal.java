package application;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import model.Funcionario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * Created by desenv4 on 30/06/2021.
 */
public class Principal {

    public static void main(String[] args){

        List<Funcionario> listFunc =  new ArrayList<>();

        Scanner sc =  new Scanner(System.in);

        System.out.println("quantos funcionarios serao registrados?: ");


        int contFunc = sc.nextInt();

        for (int i = 0; i < contFunc; i++){
            System.out.println("id:");
            int id = sc.nextInt();
            System.out.println("Nome:");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.println("Salario:");
            double salario = sc.nextDouble();
            listFunc.add(new Funcionario(id, nome, salario));
        }

        System.out.println("id do funcionario almento?");
        int id = sc.nextInt();
        System.out.println("porcento almento?");
        double percent = sc.nextDouble();
        try {
            listFunc.stream().
                    filter(var -> var.getId() == id).
                    findFirst().
                    orElse(null).
                    almento(percent);
        }catch (Exception e){
            System.out.println("id nao existe");
        }

        for (Funcionario func : listFunc){
            System.out.println(func);
        }

    }

}
