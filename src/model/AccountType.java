package model;

public enum AccountType {
  CHECKING {
    @Override
    public double incomeCalc(double cash, double cdi, int days) {
      return cash;
    }

    @Override
    public double incomeCalc(double cash, double cdi, int days, boolean isLegal) {
      throw new UnsupportedOperationException("Método não suportado para este tipo de conta.");
    }
  },

  CDI {
    @Override
    public double incomeCalc(double cash, double cdi, int days) {
      double cdiDaily = cdi / 30;
      double incomeBrute = cash * Math.pow(1 + cdiDaily, days);
      double incomeLiquid = incomeBrute - cash;
      double tax = incomeLiquid * 0.0007;
      return incomeBrute - tax;
    }

    @Override
    public double incomeCalc(double cash, double cdi, int days, boolean isLegal) {
      throw new UnsupportedOperationException("Método não suportado para este tipo de conta.");
    }
  },

  AUTO {
    @Override
    public double incomeCalc(double cash, double cdi, int days) {
      double cdiDaily = cdi / 30;
      double incomeBrute = cash * Math.pow(1 + cdiDaily, days);
      double incomeLiquid = incomeBrute - cash;
      double tax = incomeLiquid * 0.0007;
      return incomeBrute - tax;
    }

    @Override
    public double incomeCalc(double cash, double cdi, int days, boolean isLegal) {
      double months = days / 30;
      double incomeBrute = cash * Math.pow(1 + cdi, months);
      double incomeLiquid = incomeBrute - cash;
      double tax = isLegal ? incomeLiquid * 0.0015 : incomeLiquid * 0.001;
      return incomeBrute - tax;
    }
  };

  public abstract double incomeCalc(double cash, double cdi, int days);

  public abstract double incomeCalc(double cash, double cdi, int months, boolean isLegal);
}
