class bankaccount {
    int balance;
    int deposite(int amount){
        balance += amount;
        return balance;
    }
    int deposite(int amount1,int amount2){
        balance += (amount1 + amount2);
        return balance;
    }
    int withdraw(int amount){
        balance -= amount;
        return balance;
    }
}

public class Bankacountclass{
    public static void main(String[] args){
        bankaccount account = new bankaccount();
        System.out.println("Balance after deposite: " + account.deposite(1000));
        System.out.println("Balance after deposite: " + account.deposite(500, 200));
        System.out.println("Balance after withdraw: " + account.withdraw(300));
    }
}
