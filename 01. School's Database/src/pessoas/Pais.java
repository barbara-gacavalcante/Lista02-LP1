package pessoas;

public class Pais extends Pessoa {
  private String email;
  private String number;

  public Pais(String name, String email, String number) {
    super(name);
    this.email = email;
    this.number = number;
  }

  public String getEmail() {
    return email;
  }

  public String getNumber() {
    return number;
  }
}
