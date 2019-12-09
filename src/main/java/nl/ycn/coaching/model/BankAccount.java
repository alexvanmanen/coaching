package nl.ycn.coaching.model;

public class BankAccount {

    public BankAccount(double saldo){
        this.saldo = saldo;
    }

    private double saldo;

    public void storten(double money){
        negativeNotAllowed(money);
        this.saldo = this.saldo + money;
    }

    public void opnemen(double money) {
        negativeNotAllowed(money);
        if(saldo < money){
            throw new RuntimeException("Je mag niet in de min komen te staan");
        }
        this.saldo = this.saldo - money;
    }

    private void negativeNotAllowed(double money) {
        if (money <= 0) {
            throw new RuntimeException("Dat is niet de bedoeling");
        }
    }

    public double getSaldo(){
        return saldo;
    }
}
