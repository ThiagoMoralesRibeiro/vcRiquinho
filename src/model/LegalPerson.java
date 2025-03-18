package model;

public class LegalPerson extends User{
  private String cnpj;

  public LegalPerson(String name, String email, String cnpj){
    super(name, email);
    this.cnpj = cnpj;
  }

  public String getCnpj(){
    return cnpj;
  }
}
