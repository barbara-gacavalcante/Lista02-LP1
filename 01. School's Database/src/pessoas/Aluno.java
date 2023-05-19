package pessoas;

import java.util.ArrayList;

public class Aluno extends Pessoa {
  private String registration;
  private ArrayList<Pais> responsaveis = new ArrayList<Pais>();

  public Aluno(String name, String number, String email, String registration, ArrayList<Pais> responsaveis) {
    super(name, number, email);
    this.registration = registration;
    this.responsaveis = new ArrayList<>(responsaveis);
  }

  public String getRegistration() {
    return registration;
  }

  public ArrayList<Pais> getResponsaveis() {
    return responsaveis;
  }
}
