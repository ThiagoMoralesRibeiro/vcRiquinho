package model;

import java.util.List;
import java.util.ArrayList;

public class User {
  private static int count = 1;
  private int id;
  private String name;
  private String email;

  private List<Account> accounts;

  public User(String name, String email) {
    this.id = count++;
    this.name = name;
    this.email = email;
    this.accounts = new ArrayList<>();
  }

  public void syncAccount(Account account) {
    accounts.add(account);
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  @Override
  public String toString() {
    return "ID: "+ id +", usuario: " + name + ", email: " + email;
  }

}
