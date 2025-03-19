
package model;

public class Account {
  private int number;
  private int agency;
  private double cash;
  private AccountType type;

  public Account(int number, AccountType type, int agency) {
    this.number = number;
    this.type = type;
    this.agency = agency;
    this.cash = 0.0;
  }

  public int getNumber() {
    return number;
  }

  public int getAgency() {
    return agency;
  }

  public double getCash() {
    return cash;
  }

  public void deposit(double value) {
    cash += value;
  }

  @Override
  public String toString() {
    return "Numero: " + number + ", " + "Saldo: " + cash + ", Tipo: " + type + ", Agencia: " + agency;
  }

  public double incomeCalc(double cdi, int days) {
    return type.incomeCalc(cash, cdi, days);
  }

  public double incomeCalc(double cdi, int months, boolean isLegal) {
    if (type == AccountType.AUTO) {
      return type.incomeCalc(cash, cdi, months, isLegal);
    }
    throw new UnsupportedOperationException("Este método não é suportado para este tipo de conta.");
  }
}
