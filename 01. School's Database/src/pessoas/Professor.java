package pessoas;

public class Professor extends Pessoa {

  private String registration;
  private String subject;

  public Professor(String name, String registration, String subject) {
    super(name);
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
