package view;

import controller.AccountController;
import controller.InvestmentProductController;
import controller.UserController;
import model.Account;
import model.LegalPerson;
import model.NaturalPerson;
import model.User;
import model.AccountType;

public class App {
  public static void main(String[] args) {
    UserController userController = new UserController();
    AccountController accountController = new AccountController();
    InvestmentProductController productController = new InvestmentProductController();
    
    LegalPerson lp = new LegalPerson("Atelier da Cristina", "sac@ateliercristina.com", "11237772000168");
    NaturalPerson np = new NaturalPerson("Robson Nunes", "robinho123@hotmail.com", "15475308802");
    
    Account account = new Account(123456789, AccountType.CHECKING, 1245);

    np.syncAccount(account);

    //userController.create(lp);
    userController.create(np);

    userController.readAll();



    
  }
}
