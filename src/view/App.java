package view;

import controller.AccountController;
import controller.InvestmentProductController;
import controller.UserController;
import model.Account;
import model.LegalPerson;
import model.NaturalPerson;
import model.User;
import model.AccountType;
import model.InvestmentProduct;
import model.InvestmentType;

public class App {
  public static void main(String[] args) {
    // Dados ilustrativos para fins de teste
    double[] cash = { 1000, 2000, 3000 };
    double cdi = 0.01; // CDI mensal (arredondando pra 1% ao mes)
    double incomeMensalInvest = 0.01;
    int days = 30;
    int months = 3;
    int[] periods = { 30, 60, 90, 180 };

    UserController userController = new UserController();
    AccountController accountController = new AccountController();
    InvestmentProductController productController = new InvestmentProductController();

    LegalPerson lp = new LegalPerson("Atelier da Cristina", "sac@ateliercristina.com", "11237772000168");
    NaturalPerson np = new NaturalPerson("Robson Nunes", "robinho123@hotmail.com", "15475308802");

    Account accountChecking = new Account(123456789, AccountType.CHECKING, 1245);
    Account accountCdi = new Account(234456865, AccountType.CDI, 2345);
    Account accountAuto = new Account(123876126, AccountType.AUTO, 7678);

    InvestmentProduct product = new InvestmentProduct("KNRI11", "Kinea Renda Imobiliária",
        "KNRI11 é um FII de perfil renda e valorização, sendo uma opção atrativa para investidores que buscam distribuição periódica de dividendos e proteção patrimonial atrelada ao mercado imobiliário.",
        0.0087, InvestmentType.VARIABLE_INCOME, 0);

    System.out.printf("Simulação do Investimento (%s): R$ %.2f%n", product.getId(), product.simulateReturn(1000, 3));

    accountChecking.deposit(cash[0]);
    accountCdi.deposit(cash[1]);
    accountAuto.deposit(cash[2]);

    accountController.create(accountChecking);
    Account teste = accountController.readById(accountChecking.getNumber());
    System.out.println(teste.toString());

    np.syncAccount(accountChecking);
    lp.syncAccount(accountCdi);

    userController.create(lp);
    userController.create(np);

    userController.readAll();

    System.out.println("Simulação de Rendimento:");

    for (int i = 0; i < periods.length; i++) {
      System.out.println("\n Periodo: " + periods[i] + " dias");

      System.out.println("Conta Corrente: " + accountChecking.incomeCalc(cdi, periods[i]));
      System.out.printf("Conta CDI: %.2f%n", accountCdi.incomeCalc(cdi, periods[i]));
      System.out.printf("Conta Investimento PF: %.2f%n", accountAuto.incomeCalc(incomeMensalInvest, periods[i], false));
      System.out.printf("Conta Investimento PJ: %.2f%n", accountAuto.incomeCalc(incomeMensalInvest, periods[i], true));
    }

  }
}
