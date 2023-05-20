/* Alunos: 
 * 		Bárbara Geovanna Alves Cavalcante (20220055021)
 * 		Samuel da Silva Ferreira (20220054946)
*/

import java.util.ArrayList;
import java.util.Scanner;

import pessoas.*;
import sistema.*;

public class Main {

    private static final int TOTALALUNOS = 10;
    private static final int TOTALPROFESSORES = 5;

    private static Scanner sc = new Scanner(System.in);

    private static Sistema sys = new Sistema();
    private static SysControl syscon = new SysControl();
    private static ArrayList<Pais> responsaveisTemp = new ArrayList<Pais>();

    public static void main(String[] args) throws Exception {
        UI();
    }

    public static void UI() {
        try {
            int op;
            do {
                System.out.println("\n*******************************************************************************");
                System.out.println("\nEscolha uma operação: ");
                System.out.print("\n1. Registrar aluno;"
                        + "\n2. Printar Lista de aluno;"
                        + "\n3. Printar informação de algum aluno;"
                        + "\n4. Printar lista de responsaveis;"
                        + "\n5. Registrar professores;"
                        + "\n6. Printar lista de professores;"
                        + "\n0. Sair.\n");
                op = Integer.parseInt(sc.nextLine());
                switch (op) {
                    case 1: // Registrar no sistema
                        if (checkIfFull()) {
                            System.out.println("O sistema já está cheio");
                            UI();
                        }
                        regLogic();
                        break;

                    case 2: // printar todos os alunos
                        if (!checkIfHasElement(sys)) {
                            System.out.println("Ainda não há nenhum aluno cadastrado...");
                            UI();
                        }
                        sys.printAlunoAll();
                        break;

                    case 3: // Printar algum aluno
                        if (!checkIfHasElement(sys)) {
                            System.out.println("Ainda não há nenhum aluno cadastrado...");
                            UI();
                        }
                        String name = new String();
                        int index;
                        int op2;
                        do {
                            System.out.println(
                                    "\n*******************************************************************************");
                            System.out.print("\n1. Procurar aluno pelo índice."
                                    + "\n2. Procurar aluno pelo nome."
                                    + "\n0. Voltar.\n");
                            op2 = Integer.parseInt(sc.nextLine());
                        } while (!validRange(op2, 0, 2));
                        switch (op2) {
                            case 1:
                                System.out.println(
                                        "\n*******************************************************************************");
                                System.out.println("Digite o índice do aluno a procurar: ");
                                index = Integer.parseInt(sc.nextLine());
                                if (checkIfInRange(index)) {
                                    sys.printAluno(sys.getDatabase().get(index));
                                } else {
                                    System.out.println("Não há aluno com esse índice...");
                                }

                                break;

                            case 2:
                                System.out.println(
                                        "\n*******************************************************************************");
                                System.out.println("Digite o nome do aluno a procurar: ");
                                name = sc.nextLine();
                                if (checkIfAluno(name)) {
                                    sys.printAluno(sys.findAluno(name));
                                } else
                                    System.out.println("Não há aluno com esse nome registrado...");
                                break;

                            case 0:
                            default:
                                UI();
                                break;
                        }
                        break;
                    case 4: // Printar todos os responsaveis
                        if (!checkIfHasElement(sys)) {
                            System.out.println("Ainda não há nenhum aluno cadastrado...");
                            UI();
                        }
                        sys.printResponsavelAll();
                        break;

                    case 5:
                        registerProf(sys);
                        break;

                    case 6: //
                        if (!checkIfProfessor()) {
                            System.out.println("Nenhum professor ainda foi cadastrado...");
                            UI();
                        }
                        sys.printProfessores();
                        UI();
                        break;

                    case 0:
                        System.out.println("Finalizando programa...");
                        sc.close();
                        break;
                    default:
                        System.out.println("Usuário passou algum valor inválido...");
                        UI();
                        break;
                }
            } while (validRange(op, 0, 5));
        } catch (NumberFormatException e) {
            System.out.println(e);
            UI();
        }
    }

    public static void regLogic() {
        String name = new String();
        String number = new String();
        String email = new String();
        String registration;
        String nameRes = new String();
        String emailRes = new String();
        String numberRes = new String();
        int resInt = 0;
        int resAmount = 0;
        resInt = 0;
        try {
            System.out.println("Digite o nome do aluno: ");
            name = sc.nextLine();
            do {
                System.out.println("Digite o número da matrícula (xxxxx): ");
                registration = sc.nextLine();
            } while (!checkIfValidRegistration(registration));
            System.out.println("Digite o Email do aluno: ");
            email = sc.nextLine();
            System.out.println("Digite o número de telefone do aluno: ");
            number = sc.nextLine();
            System.out.println("Quantos responsaveis serão cadastrados para esse aluno: ");
            resAmount = Integer.parseInt(sc.nextLine());
            do {
                System.out.println("Digite o nome do responsavel: ");
                nameRes = sc.nextLine();
                System.out.println("Digite o Email do responsavel: ");
                emailRes = sc.nextLine();
                System.out.println("Digite o número de telefone do responsavel: ");
                numberRes = sc.nextLine();
                Pais p = new Pais(nameRes, numberRes, emailRes);
                responsaveisTemp.add(p);
                resInt++;
            } while (resInt < resAmount);
            Aluno a = new Aluno(name, number, email, registration, responsaveisTemp);
            responsaveisTemp.clear();
            sys.register(a);
        } catch (NumberFormatException e) {
            System.out.println(e);
            regLogic();
        }
    }

    public static void registerProf(Sistema sys) {
        String name = new String();
        String number = new String();
        String email = new String();
        String registration = new String();
        String subject = new String();
        int profInt = 0;
        do {
            System.out.println("Digite o nome do Professor: ");
            name = sc.nextLine();
            do {
                System.out.println("Digite o número da matrícula do Professor (xxxxx): ");
                registration = sc.nextLine();
            } while (!checkIfValidRegistration(registration));
            System.out.println("Digite o Email do Professor: ");
            email = sc.nextLine();
            System.out.println("Digite o número de telefone do Professor: ");
            number = sc.nextLine();
            System.out.println("Digite a matéria do Professor: ");
            subject = sc.nextLine();
            Professor p = new Professor(name, number, email, registration, subject);
            syscon.registrarProf(sys, p);
            profInt++;
        } while (profInt < TOTALPROFESSORES);
    }

    public static boolean checkIfValidRegistration(String registration) {
        if (registration.length() > 5 || registration.length() < 5)
            return false;
        for (int i = 0; i < registration.length(); i++) {
            if (!Character.isDigit(registration.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean checkIfFull() {
        if (sys.getDatabase().size() < TOTALALUNOS) {
            return false;
        }
        return true;
    }

    public static boolean checkIfInRange(int i) {
        if (sys.getDatabase().size() >= i)
            return true;
        return false;
    }

    public static boolean checkIfAluno(String name) {
        for (int i = 0; i < sys.getDatabase().size(); i++) {
            if (sys.getDatabase().get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfProfessor() {
        if (sys.getListaProfessores().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean validRange(int option, int start, int end) {
        if (option <= end && option >= start)
            return true;
        return false;
    }

    public static boolean checkIfHasElement(Sistema sys) {
        if (sys.getDatabase().size() == 0)
            return false;
        return true;
    }

}
