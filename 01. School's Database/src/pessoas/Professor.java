package pessoas;

public class Professor extends Pessoa {

  private String registration;
  private String subject;

  public Professor(String name, String email, String number, String registration, String subject) {
    super(name, email, number);
    this.registration = registration;
    this.subject = subject;
  }

  public String getRegistration() {
    return registration;
  }

  public String getSubject() {
    return subject;
  }
}
