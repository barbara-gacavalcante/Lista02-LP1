package pessoas;

import java.util.ArrayList;

public class Aluno extends Pessoa {
  private String registration;
  private ArrayList<Pais> responsaveis = new ArrayList<Pais>();

  public Aluno(String name, String registration, ArrayList<Pais> responsaveis) {
    super(name);
    this.registration = registration;
    this.responsaveis = new ArrayList<>(responsaveis);
  }

  public String getRegistration() {
    return registration;
  }

  public ArrayList<Pais> getResponsaveis() {
    return responsaveis;
  }

  public void print() {
    System.out.println("Nome: " + name + "\nMatrícula: " + registration);
    System.out.println("Responsaveis: ");
    for (Pais e : responsaveis) {
      System.out.println("Nome: " + e.getName() + "\nEmail: " + e.getEmail() + "\nNúmero: " + e.getNumber() + "\n");
    }
  }
}
