package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Account;

public class AccountController {
  private List<Account> accounts;

  public AccountController() {
    this.accounts = new ArrayList<>();
  }

  public void create(Account account) {
    try {
      accounts.add(account);
      System.out.println("Conta cadastrado com sucesso");

    } catch (Exception e) {
      System.out.println("Erro");
    }
  }

  public Account readById(int number) {
    Optional<Account> account = accounts.stream()
        .filter(a -> a.getNumber() == number).findFirst();
    return account.orElse(null);
  }

  public void readAll() {
    if (accounts.isEmpty()) {
      System.out.println("Nenhum(a) conta na lista");
      return;
    }

    System.out.println("---Lista de Contas---");
    for (int i = 0; i < accounts.size(); i++) {
      System.out.println(accounts.get(i));
    }
  }

  public boolean update(Account account, int number) {
    for (int i = 0; i < accounts.size(); i++) {
      if (accounts.get(i).getNumber() == number) {
        accounts.set(i, account);
        System.out.println("Conta atualizada com sucesso!");
        return true;
      }
    }
    System.out.println("Conta não encontrada.");
    return false;
  }

  public boolean delete(int number) {
    return accounts.removeIf(acc -> acc.getNumber() == number);
  }
}
