package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Account;
import model.User;

public class UserController {
  private List<User> customers;

  public UserController() {
    this.customers = new ArrayList<>();
  }

  public void create(User user) {
    try {
      if (user.getAccounts().isEmpty()) {
        throw new IllegalArgumentException("O usuário deve possuir pelo menos uma conta.");
      }
      customers.add(user);
      System.out.println("Cliente cadastrado com sucesso");
    } catch (IllegalArgumentException e) {
      System.out.println("Erro: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Erro inesperado: " + e.getMessage());
    }
  }

  public User readById(String name) {
    // Evitando NullPointerException
    Optional<User> customer = customers.stream()
        .filter(c -> c.getName().equalsIgnoreCase(name))
        .findFirst();
    return customer.orElse(null);
  }

  public void readAll() {
    if (customers.isEmpty()) {
      System.out.println("Nenhum cliente na lista");
      return;
    }

    System.out.println("---Lista de Clientes---");
    for (int i = 0; i < customers.size(); i++) {
      System.out.println(customers.get(i).toString());
    }
  }

  public boolean update(User user, String name) {
    for (int i = 0; i < customers.size(); i++) {
      if (customers.get(i).getName().equalsIgnoreCase(name)) {
        customers.set(i, user);
        System.out.println("Cliente atualizado com sucesso!");
        return true;
      }
    }
    System.out.println("Cliente não encontrado.");
    return false;
  }

  public boolean delete(String name) {
    return customers.removeIf(customer -> customer.getName().equalsIgnoreCase(name));
  }
}
