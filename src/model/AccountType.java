package model;

public enum AccountType {
  CHECKING {
    @Override
    public double incomeCalc(double cash, double cdi, int days) {
      // For CHECKING account, income is simply the cash (no interest)
      return cash;
    }

    @Override
    public double incomeCalc(double cash, double cdi, int months, boolean isLegal) {
      // CHECKING doesn't support income calculation by months
      throw new UnsupportedOperationException("Método não suportado para este tipo de conta.");
    }
  },

  CDI {
    @Override
    public double incomeCalc(double cash, double cdi, int days) {
      // For CDI account, income is based on daily calculation
      double income = cash * Math.pow(1 + (cdi / 30), days);
      double tax = income * 0.0007;
      return income - tax;
    }

    @Override
    public double incomeCalc(double cash, double cdi, int months, boolean isLegal) {
      // CDI doesn't support monthly calculations
      throw new UnsupportedOperationException("Método não suportado para este tipo de conta.");
    }
  },

  AUTO {
    @Override
    public double incomeCalc(double cash, double cdi, int days) {
      // AUTO account supports income calculation by days
      double income = cash * Math.pow(1 + (cdi / 30), days);
      double tax = income * 0.0007;
      return income - tax;
    }

    @Override
    public double incomeCalc(double cash, double cdi, int months, boolean isLegal) {
      // For AUTO account, the income is calculated monthly with legal tax condition
      double income = cash * Math.pow(1 + cdi, months);
      double tax = isLegal ? income * 0.0015 : income * 0.001;
      return income - tax;
    }
  };

  // Abstract methods that must be implemented by each enum constant
  public abstract double incomeCalc(double cash, double cdi, int days);

  public abstract double incomeCalc(double cash, double cdi, int months, boolean isLegal);
}
