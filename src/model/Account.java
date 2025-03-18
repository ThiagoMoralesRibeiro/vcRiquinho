
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

  // For accounts that have incomeCalc based on days
  public double incomeCalc(double cdi, int days) {
    return type.incomeCalc(cash, cdi, days);
  }

  // For accounts that have incomeCalc based on months, such as AUTO
  public double incomeCalc(double cdi, int months, boolean isLegal) {
    if (type == AccountType.AUTO) {
      return type.incomeCalc(cash, cdi, months, isLegal);
    }
    // For other account types that do not support this calculation
    throw new UnsupportedOperationException("Este método não é suportado para este tipo de conta.");
  }
}
