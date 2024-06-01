public class Current_Account extends Account implements Account_methods {
    public Current_Account() {
        super();
        deposit();
        withdraw();
        deductZakat();
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
            case 0:
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
            case 0 :
                return;
            case 1 :
            System.out.println("Your balance before withdraw is : " + getOpening_balance());
            System.out.print("Enter the balance which you want to withdraw : ");
            double withdraw = in.nextDouble();
            if (withdraw > 0) {
                opening_balance = opening_balance - withdraw;
            }
            System.out.println("Your balance after withdraw is : " + getOpening_balance());
            break;
        }
    }
    @Override
    public void deductZakat() {
        if (filer == false) {
            System.out.println("There is not deduction for Zakaat");
        }
        if (filer == true) {
            double i = opening_balance * 0.025;
            opening_balance = opening_balance - i;
            System.out.println("Zaakat Deduction for one year : " + i);
            System.out.println("Your balance after Zaakat deduction : " + opening_balance);
        }
    }
}