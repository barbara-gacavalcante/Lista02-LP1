package pessoas;

public class Pessoa {
  protected String name;
  protected String number;
  protected String email;

  public Pessoa(String name, String number, String email) {
    this.name = name;
    this.number = number;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getNumber() {
    return number;
  }

  public String getEmail() {
    return email;
  }
}
