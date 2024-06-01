import java.util.ArrayList;
import java.util.Scanner;

public class Account  {
    Scanner in = new Scanner(System.in);
    private int id;
    public double opening_balance;
    private String accountHolder_Name;
    private int age;
    public boolean filer;
    public boolean zakat;

    public Account() {
        setAccountHolder_Name(accountHolder_Name);
        setId(id);
        setOpening_balance(opening_balance);
        setAge(age);
        setFiler(filer);
        setZakat(zakat);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.print("Enter your ID : ");
        this.id = in.nextInt();
    }

    public double getOpening_balance() {
        return opening_balance;
    }

    public void setOpening_balance(double opening_balance) {
        System.out.print("Enter your Account opening Balance : ");
        this.opening_balance = in.nextDouble();
    }

    public String getAccountHolder_Name() {
        return accountHolder_Name;
    }

    public void setAccountHolder_Name(String accountHolder_Name) {
        System.out.print("Enter your Name : ");
        this.accountHolder_Name = in.nextLine();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.print("Enter your age : ");
        this.age = in.nextInt();
    }

    public void setFiler(boolean filer) {
        System.out.print("If you are filer press 1 otherwise press 0 : ");
        int f = in.nextInt();
        while (f!=0 && f!=1)
        {
            System.out.print("Invalid Entry! Enter again: ");
            f = in.nextInt();
        }
        if(f==0)
        {
            this.filer=false;
        }if(f==1){
            this.filer=true;
        }
    }

    public void setZakat(boolean zakat) {
        System.out.print("If you want to pay zakat press 1 otherwise 0 : ");
        int z = in.nextInt();
        while (z!=0 && z!=1)
        {
            System.out.print("Invalid Entry! Enter again: ");
            z = in.nextInt();
        }
        if(z==0)
        {
            this.filer=false;
        }if(z==1){
            this.filer=true;
        }
    }


    public static double getTotalProfitPaid(ArrayList<Saving_Account> s, ArrayList<Investment_Account> a){
        double p = 0;
        double in=0;
        for (int i =0; i< s.size() ;i++)
        {
           p += s.get(i).p;
        }
        for (int j=0; j< a.size();j++)
        {
            in += a.get(j).profit;
        }
        return in+p;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", opening_balance=" + opening_balance +
                ", accountHolder_Name='" + accountHolder_Name + '\'' +
                ", age=" + age +
                '}';
    }
}
