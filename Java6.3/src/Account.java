
public class Account {
    int balance= 1000;

    public int getBal(){
        return balance;
    }

    public void withdraw(int bal){
        balance= balance-bal;
    }

    public void deposit(int bal){
        balance= balance+bal;
    }
}