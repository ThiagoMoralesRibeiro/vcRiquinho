package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.InvestmentProduct;

public class InvestmentProductController {
  private List<InvestmentProduct> products;

  public InvestmentProductController() {
    this.products = new ArrayList<>();
  }

  public void create(InvestmentProduct product) {
    try {
      products.add(product);
      System.out.println("Produto cadastrado com sucesso");

    } catch (Exception e) {
      System.out.println("Erro");
    }
  }

  public InvestmentProduct readById(String id) {
    // Evitando NullPointerException
    Optional<InvestmentProduct> product = products.stream()
        .filter(c -> c.getId().equalsIgnoreCase(id))
        .findFirst();
    return product.orElse(null);
  }

  public void readAll() {
    if (products.isEmpty()) {
      System.out.println("Nenhum produto na lista");
      return;
    }

    System.out.println("---Lista de Produtos---");
    for (int i = 0; i < products.size(); i++) {
      System.out.println(products.get(i));
    }
  }

  public boolean update(InvestmentProduct product, String id) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getId().equalsIgnoreCase(id)) {
        products.set(i, product);
        System.out.println("Produto atualizado com sucesso!");
        return true;
      }
    }
    System.out.println("Produto não encontrado.");
    return false;
  }

  public boolean delete(String id) {
    return products.removeIf(product -> product.getId().equalsIgnoreCase(id));
  }
}
