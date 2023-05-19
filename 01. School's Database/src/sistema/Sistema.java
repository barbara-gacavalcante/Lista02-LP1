package sistema;

import java.util.ArrayList;

import pessoas.*;

public class Sistema implements SysInterface {

  private ArrayList<Aluno> database = new ArrayList<Aluno>();
  private ArrayList<Professor> listaProfessores = new ArrayList<Professor>();

  public ArrayList<Aluno> getDatabase() {
    return database;
  }

  public Aluno getAluno(int index) {
    return database.get(index);
  }

  public void register(Aluno a) {
    database.add(a);
  }

  public void registerProf(Professor p) {
    listaProfessores.add(p);
  }

  public void printAluno(Aluno a) {
    System.out.println("Nome: " + a.getName() + "\nMatrícula: " + a.getRegistration());
    System.out.println("\nResponsaveis: ");
    printResponsavel(a);
    System.out.println("*******************************************************************************");
  }

  public void printResponsavel(Aluno a) {
    for (Pais e : a.getResponsaveis()) {
      System.out.println("\nNome: " + e.getName() + "\nEmail: " + e.getEmail() +
          "\nNúmero: " + e.getNumber() + "\n");
    }
  }

  public void printAlunoAll() {
    if (database.size() == 0) {
      System.out.println("Ainda não foram feitos nenhum cadastro no sistema.");
      return;
    }
    System.out.println("\n");
    for (int i = 0; i < database.size(); i++) {
      printAluno(database.get(i));
    }
  }

  public void printResponsavelAll() {
    if (database.size() == 0) {
      System.out.println("Ainda não foram feitos nenhum cadastro no sistema.");
      return;
    }
    for (int i = 0; i < database.size(); i++) {
      printResponsavel(database.get(i));
    }
  }

  public Aluno findAluno(String name) {
    for (int i = 0; i < database.size(); i++) {
      if (database.get(i).getName().equals(name)) {
        return database.get(i);
      }
    }
    return null;
  }

}
