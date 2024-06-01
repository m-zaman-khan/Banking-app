import java.util.ArrayList;
import java.util.Scanner;

public class Main_Account {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Account a = new Account();
        ArrayList<Current_Account> ca = new ArrayList<>();
        ArrayList<Investment_Account> ia = new ArrayList<>();
        ArrayList<Saving_Account> sa = new ArrayList<>();
        int ch;
        do {
            System.out.println("Press 1 to create Current Account ");
            System.out.println("Press 2 to create Saving Account ");
            System.out.println("Press 3 to create Investment Account ");
            System.out.print("Enter your Choice : ");
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    ca.add(new Current_Account());
                }
                case 2 -> {
                    sa.add(new Saving_Account());
                }
                case 3 -> {
                    ia.add(new Investment_Account());
                }
            }
            System.out.println();
            System.out.print("Dear Accountant! Do you want to create another account?");
            System.out.print(" if yes then press 1 otherwise press 0 : ");
            ch = in.nextInt();
            System.out.println("\n");
        } while (ch != 0);
        System.out.println("Total profit of all accounts paid by bank : "+Account.getTotalProfitPaid(sa,ia));
    }
}
