import javax.swing.JOptionPane;
import java.util.Locale;


/**
 * Created by desenv4 on 29/06/2021.
 */
public class Main {

    public static void main(String[] args){
        double a = 1.2555;
        JOptionPane.showMessageDialog(null,"Hello Word");
        System.out.printf("%.2f%n", a);
        Locale.setDefault(Locale.ITALIAN);
        System.out.printf("%.2f%n", a);
    }
}
