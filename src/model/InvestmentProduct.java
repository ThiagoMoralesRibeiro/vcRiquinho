package model;

public class InvestmentProduct {
  private String id;
  private String desc;
  private String name;
  private double interestRate;
  private InvestmentType type;
  private int carency;

  public InvestmentProduct(String id, String name, String desc, double interestRate, InvestmentType type, int carency) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.interestRate = interestRate;
    this.type = type;
    this.carency = carency;
  }

  public double simulateReturn(double amount, int months) {
    return type.calcReturn(amount, interestRate, months, carency);
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public InvestmentType getType() {
    return type;
  }

  public int getCarency() {
    return carency;
  }

}
