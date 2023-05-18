package sistema;

import pessoas.*;

public interface SysInterface {

  public void register(Aluno a);

  public void registerProf(Professor p);

  public void printAluno(Aluno a);

  public void printResponsavel(Aluno a);

  public void printAlunoAll();

  public void printResponsavelAll();

  public Aluno findAluno(String name);
}
