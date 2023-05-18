package sistema;

import pessoas.*;

public class SysControl {

  public void registrar(Sistema sys, Aluno a) {
    sys.register(a);
  }

  public void registrarProf(Sistema sys, Professor p) {
    sys.registerProf(p);
  }
}
