package application;

import java.util.Scanner;

import entities.ControleRemoto;
import entities.Televisao;

public class Program {

	public static void main(String[] args) {
		
		try {
			
			Scanner sc = new Scanner (System.in);
			
			int op;
			
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
				
				Televisao tv = new Televisao();
				
				ControleRemoto controleRemoto = new ControleRemoto(tv);
			
				System.out.println("\nVolume atual: " + controleRemoto.consultarVolume());
                System.out.println("Canal atual: " + controleRemoto.consultarCanal());
				
				switch (op) {
                case 1:
                	System.out.println("\nAumentando...");          	
                    controleRemoto.aumentarVolume();
                    System.out.println("\nVolume atual: " + controleRemoto.consultarVolume());
                    break;
                case 2:
                	System.out.println("\nDiminuindo...");
                    controleRemoto.diminuirVolume();
                    System.out.println("\nVolume atual: " + controleRemoto.consultarVolume());
                    break;
                case 3:
                	System.out.println("\nAumentando...");
                    controleRemoto.aumentarCanal();
                    System.out.println("\nCanal atual: " + controleRemoto.consultarCanal());
                    break;
                case 4:
                	System.out.println("\nDiminuindo...");
                    controleRemoto.diminuirCanal();
                    System.out.println("\nCanal atual: " + controleRemoto.consultarCanal());
                    break;
                case 5:
                    System.out.print("\nA qual canal você gostaria de assistir agora? ");
                    int novoCanal = sc.nextInt();
                    controleRemoto.trocarCanal(novoCanal);
                    System.out.println("\nCanal atual: " + controleRemoto.consultarCanal());
                    break;
                case 6:
                    System.out.println("\nVolume atual: " + controleRemoto.consultarVolume());
                    System.out.println("Canal atual: " + controleRemoto.consultarCanal());
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
