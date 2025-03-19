package model;

public enum InvestmentType {
  FIXED_INCOME("Renda Fixa", "Investimento com retorno previsivel") {
    @Override
    public double calcReturn(double value, double monthlyReturn, int months, int carency) {
      if (months < carency) {
        System.out.println("O investimento está dentro do período de carência. Nenhum rendimento será gerado.");
        return 0;
      }
      return value * Math.pow(1 + monthlyReturn, months);
    }
  },

  VARIABLE_INCOME("Renda Variavel", "Investimento com retorno pouco previsivel") {
    @Override
    public double calcReturn(double value, double monthlyReturn, int months, int carency) {
      return value * Math.pow(1 + monthlyReturn, months);
    }

  };

  private final String name;
  private final String desc;

  InvestmentType(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }

  public abstract double calcReturn(double value, double monthlyReturn, int months, int carency);
}

