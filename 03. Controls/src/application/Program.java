/* Alunos: 
 * 		Bárbara Geovanna Alves Cavalcante (20220055021)
 * 		Samuel da Silva Ferreira (20220054946)
 */

package application;

import java.util.Scanner;
import entities.ControleRemoto;
import entities.Televisao;

public class Program {

	public static void main(String[] args) {
		
		try {
			
			Scanner sc = new Scanner (System.in);
			
			int op;
			
			Televisao tv = new Televisao();
			
			ControleRemoto controleRemoto = new ControleRemoto(tv);
			
			do {
				System.out.println("\n\n\nEscolha uma operação: ");
				System.out.print("\n1. Aumentar o volume;"
						+ "\n2. Diminuir o volume;"
						+ "\n3. Aumentar o número do canal;"
						+ "\n4. Diminuir o número do canal;"
						+ "\n5. Trocar para um canal indicado;"
						+ "\n6. Consultar informações;"
						+ "\n7. Sair."
						+ "\n\nSua resposta: ");
				op = sc.nextInt();
				
				if(op != 6 && op != 7) {
					System.out.println("\n====================================================\n");
					System.out.println("Status atuais: ");
					System.out.println("\nVolume: " + controleRemoto.consultarVolume());
	                System.out.println("Canal: " + controleRemoto.consultarCanal());
	                System.out.println("\n====================================================\n\n\n");
				}
				
				switch (op) {
                case 1:
                	System.out.println("====================================================\n");
                	System.out.println("\nAumentando...");          	
                    controleRemoto.aumentarVolume();
                    System.out.println("\nVolume atualizado: " + controleRemoto.consultarVolume());
                    System.out.println("\n====================================================");
                    break;
                case 2:
                	System.out.println("====================================================\n");
                	System.out.println("\nDiminuindo...");
                    controleRemoto.diminuirVolume();
                    System.out.println("\nVolume atualizado: " + controleRemoto.consultarVolume());
                    System.out.println("\n====================================================");
                    break;
                case 3:
                	System.out.println("====================================================\n");
                	System.out.println("\nAumentando...");
                    controleRemoto.aumentarCanal();
                    System.out.println("\nCanal atualizado: " + controleRemoto.consultarCanal());
                    System.out.println("\n====================================================");
                    break;
                case 4:
                	System.out.println("====================================================\n");
                	System.out.println("\nDiminuindo...");
                    controleRemoto.diminuirCanal();
                    System.out.println("\nCanal atualizado: " + controleRemoto.consultarCanal());
                    System.out.println("\n====================================================");
                    break;
                case 5:
                	System.out.println("====================================================\n");
                    System.out.print("\nA qual canal você gostaria de assistir agora? ");
                    int novoCanal = sc.nextInt();
                    controleRemoto.trocarCanal(novoCanal);
        			System.out.println("\nCanal atualizado: " + controleRemoto.consultarCanal());
                    System.out.println("\n====================================================");
                    break;
                case 6:
                	System.out.println("====================================================\n");
                    System.out.println("\nVolume atualizado: " + controleRemoto.consultarVolume());
                    System.out.println("Canal atualizado: " + controleRemoto.consultarCanal());
                    System.out.println("\n====================================================");
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Operação inválida."); 
                    break;
            }
        } while (op != 7);
			
			sc.close();
			
		} catch (RuntimeException e) {
			System.out.println("Unexpected error, try again.");
		}

	}

}
