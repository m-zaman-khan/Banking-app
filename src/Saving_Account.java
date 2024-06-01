public class Saving_Account extends Account implements Account_methods {
    public static double p;
    public Saving_Account() {
          super();
          deposit();
          profit();
          withdraw();
          deductZakat();
          getTotalEarning();
    }
    double profit()
{
    if(getAge() < 35)
    {  return young_saver(); }
    else if(getAge() > 35 && getAge() < 50)
    {   return adult_saver();  }
    else if(getAge() > 50)
    {  return seniorCitizen_saver(); }
    return 0;
}

double young_saver()
{
    double ans = opening_balance * 0.06;
    opening_balance = opening_balance + ans;
    System.out.println("Adding profit of young saver in balance : "+opening_balance);
    System.out.println("Congratulations! Your Young Saver Account is Opened Successfully ");
    p=ans;
    return ans;
}
double adult_saver(){
    double ans = opening_balance * 0.07;
    opening_balance = opening_balance + ans;
    System.out.println("Adding profit of adult saver in balance : "+opening_balance);
    System.out.println("Congratulations! Your Adult Saver Account is Opened Successfully ");
    p=ans;
    return ans;
}
double seniorCitizen_saver(){
    double ans = opening_balance * 0.08;
    opening_balance = opening_balance + ans;
    System.out.println("Adding profit of Senior Citizen saver in balance : "+opening_balance);
    System.out.println("Congratulations! Your Senior Citizen Saver Account is Opened Successfully ");
    p=ans;
    return ans;
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
            case 1:
            System.out.println("Your balance before deposit is : " + getOpening_balance());
            System.out.print("Enter the balance which you want to deposit : ");
            double deposit = in.nextDouble();
            if (deposit > 0) {
                opening_balance = opening_balance + deposit;
            }
            System.out.println("Your balance after deposit is : " + getOpening_balance());
            break;
        }}

    @Override
    public void withdraw(){
        System.out.println();
        System.out.println("Do you want to withdraw an amount ");
        System.out.print("Press 1 for yes or 0 for no : ");
        int j= in.nextInt();
        while (j!=0 && j!=1)
        {
            System.out.print("Invalid Entry! Enter again: ");
            j = in.nextInt();
        }
        switch (j){
            case 0 :
                return;
            case 1 :
                System.out.println("Your balance before withdraw is : "+getOpening_balance());
                System.out.print("Enter the balance which you want to withdraw : ");
                double withdraw = in.nextDouble();
                if(withdraw>0){
                    opening_balance=opening_balance-withdraw;}
                System.out.println("Your balance after withdraw is : "+getOpening_balance());
                if(filer==false)
                {
                    double i =p*0.04;
                    p=p-i;
                    System.out.println("Deduction : "+i);
                    System.out.println("4% deduct on your profit because you are non-filer and now your profit is : "+p);
                    opening_balance=opening_balance-i;
                    System.out.println("Your balance after deduction is : "+opening_balance);
                }
                if(filer==true)
                {
                    double i =p*0.02;
                    p=p-i;
                    System.out.println("Deduction : "+i);
                    System.out.println("2% deduct on your profit because you are filer and now your profit is : "+p);
                    opening_balance=opening_balance-i;
                    System.out.println("Your balance after deduction is : "+opening_balance);
                }
                break;
        }

    }

    @Override
    public void deductZakat() {
        if(filer==false)
        {
            System.out.println();
            System.out.println("There is not deduction for Zakaat");
        }
        if(filer==true)
        {
            double i =opening_balance*0.025;
            opening_balance=opening_balance-i;
            System.out.println();
            System.out.println("Zaakat Deduction for one year : "+i);
            System.out.println("Your balance after Zaakat deduction : "+opening_balance);
        }
    }

    public void getTotalEarning() {
        System.out.println();
        if(filer==false)
        {
            double i =p*0.25;
            p=p-i;
            System.out.println("Deduction from profit : "+i);
            System.out.println("25% deduct on your profit because you are non-filer and now your profit is : "+p);
            opening_balance=opening_balance-i;
            System.out.println("Your balance after deduction is : "+opening_balance);
        }
        if(filer==true)
        {
            double i =p*0.15;
            p=p-i;
            System.out.println("Deduction : "+i);
            System.out.println("15% deduct on your profit because you are filer and now your profit is : "+p);
            opening_balance=opening_balance-i;
            System.out.println("Your balance after deduction is : "+opening_balance);
        }
        System.out.println("Now! Your total profit or earning is : "+p);
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
                return;
            case 1:
                deposit();
                getTotalEarning();
                break;
        }
    }
}