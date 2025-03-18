package model;

public class NaturalPerson extends User{
  private String cpf;

  public NaturalPerson(String name, String email, String cpf) {
    super(name, email);
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }




}
