import java.util.Scanner;

public class Investment_Account extends Account implements Account_methods {
    public static double profit;
    Scanner in = new Scanner(System.in);

    public Investment_Account() {
        super();
        deposit();
        investment();
        withdraw();
        deductZakat();
        getTotalEarning();
    }

    double investment() {
        int y = year();
        double p;
        if (y == 1) {
            p = opening_balance * 0.10;
            opening_balance = opening_balance + p;
            System.out.println("Your Investment profit for one year would be : " + opening_balance);
            profit = p;
            return p;
        } else if (y == 3) {
            p = opening_balance * 0.12;
            opening_balance = opening_balance + p;
            System.out.println("Your Investment profit for first year would be : " + opening_balance);
            double nd = opening_balance * 0.12;
            opening_balance = opening_balance + nd;
            System.out.println("Your Investment profit for second year would be : " + opening_balance);
            double third = opening_balance * 0.12;
            opening_balance = opening_balance + third;
            System.out.println("Your Investment profit for third year would be : " + opening_balance);
            profit = p + nd + third;
            return p + nd + third;
        } else if (y == 5) {
            p = opening_balance * 0.14;
            opening_balance = opening_balance + p;
            System.out.println("Your Investment profit for first year would be : " + opening_balance);
            double nd = opening_balance * 0.14;
            opening_balance = opening_balance + nd;
            System.out.println("Your Investment profit for second year would be : " + opening_balance);
            double third = opening_balance * 0.14;
            opening_balance = opening_balance + third;
            System.out.println("Your Investment profit for third year would be : " + opening_balance);
            double th = opening_balance * 0.14;
            opening_balance = opening_balance + th;
            System.out.println("Your Investment profit for fourth year would be : " + opening_balance);
            double fifth = opening_balance * 0.14;
            opening_balance = opening_balance + fifth;
            System.out.println("Your Investment profit for fifth year would be : " + opening_balance);
            profit = p + nd + third + th + fifth;
            return p + nd + third + th + fifth;
        }
        return 0;
    }

    int year() {
        System.out.print("For how many years you want to create an account : ");
        int y = in.nextInt();
        while (y != 1 && y != 3 && y != 5) {
            System.out.print("Invalid Entry! Enter Again : ");
            y = in.nextInt();
        }
        return y;
    }

    @Override
    public void deposit() {
        System.out.println();
        System.out.println("Do you want to Deposit an amount ");
        System.out.print("Press 1 for yes or 0 for no : ");
        int j= in.nextInt();
        while (j!=0 && j!=1)
        {
            System.out.print("Invalid Entry! Enter again: ");
            j = in.nextInt();
        }
        switch (j) {
            case 0 :
                return;
            case 1 :
            System.out.println("Your balance before deposit is : " + getOpening_balance());
            System.out.print("Enter the balance which you want to deposit : ");
            double deposit = in.nextDouble();
            if (deposit > 0) {
                opening_balance = opening_balance + deposit;
            }
            System.out.println("Your balance after deposit is : " + getOpening_balance());
            break;
        }
    }

    @Override
    public void withdraw() {
        System.out.println();
        System.out.println("Do you want to withdraw an amount ");
        System.out.print("Press 1 for yes or 0 for no : ");
        int j= in.nextInt();
        while (j!=0 && j!=1)
        {
            System.out.print("Invalid Entry! Enter again: ");
            j = in.nextInt();
        }
        switch (j) {
            case 0:
                return;
            case 1:
            System.out.println("Your balance before withdraw is : " + getOpening_balance());
            System.out.print("Enter the balance which you want to withdraw : ");
            double withdraw = in.nextDouble();
            if (withdraw > 0) {
                double w = withdraw * 0.04;
                withdraw = withdraw + w;
                opening_balance = opening_balance - withdraw;
            }
            System.out.println("Your balance after withdraw is : " + opening_balance);
            if (filer == false) {
                double i = profit * 0.04;
                profit = profit - i;
                System.out.println("Deduction : " + i);
                System.out.println("4% deduct on your profit because you are non-filer and now your profit is : " + profit);
                opening_balance = opening_balance - i;
                System.out.println("Your balance after deduction is : " + opening_balance);
            }
            if (filer == true) {
                double i = profit * 0.02;
                profit = profit - i;
                System.out.println("Deduction : " + i);
                System.out.println("2% deduct on your profit because you are filer and now your profit is : " + profit);
                opening_balance = opening_balance - i;
                System.out.println("Your balance after deduction is : " + opening_balance);
            }
            break;
        }
    }

    @Override
    public void deductZakat() {
        if (filer == false) {
            System.out.println();
            System.out.println("There is not deduction for Zakaat");
        }
        if (filer == true) {
            System.out.println();
            double i = opening_balance * 0.025;
            opening_balance = opening_balance - i;
            System.out.println("Zaakat Deduction for one year : " + i);
            System.out.println("Your balance after Zaakat deduction : " + opening_balance);
        }
    }

    public void getTotalEarning() {
        System.out.println();
        if(filer==false)
        {
            double i =profit*0.25;
            profit=profit-i;
            System.out.println("Deduction from profit : "+i);
            System.out.println("25% deduct on your profit because you are non-filer and now your profit is : "+profit);
            opening_balance=opening_balance-i;
            System.out.println("Your balance after deduction is : "+opening_balance);
        }
        if(filer==true)
        {
            double i =profit*0.15;
            profit=profit-i;
            System.out.println("Deduction : "+i);
            System.out.println("15% deduct on your profit because you are filer and now your profit is : "+profit);
            opening_balance=opening_balance-i;
            System.out.println("Your balance after deduction is : "+opening_balance);
        }
        System.out.println("Your total profit or earning is : "+profit);
        System.out.println("Do you want to reinvest ");
        System.out.print("If yes press 1 otherwise press 0 : ");
        int j= in.nextInt();
        while (j!=0 && j!=1)
        {
            System.out.print("Invalid Entry! Enter again: ");
            j = in.nextInt();
        }
        switch (j){
            case 0:
                break;
            case 1:
                deposit();
                investment();
                getTotalEarning();
                break;
        }
    }
}