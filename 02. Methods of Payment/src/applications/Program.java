/* Alunos: 
 * 		Bárbara Geovanna Alves Cavalcante (20220055021)
 * 		Samuel da Silva Ferreira (20220054946)
 */

package applications;

import java.util.Locale;
import java.util.Scanner;
import entities.*;

public class Program {

	public static void main(String[] args) {
		try {
			
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner (System.in);
			
			System.out.println("Escolha o método de pagamento:\n1. Cartão de crédito\t2.Transferência bancária\t3.Boleto bancário");
			int op = sc.nextInt();
			
			switch(op){
			case 1:
				System.out.print("Número do cartão: ");
				int numero = sc.nextInt();
				sc.nextLine();
				System.out.print("Nome do titular: ");
				String nome = sc.nextLine();
				System.out.println("CVV (xxx): ");
				int cvv = sc.nextInt();
				System.out.print("Limite do cartão: ");
				double limite = sc.nextDouble();
				System.out.print("Valor a ser pago: ");
				double valor = sc.nextDouble();
				CreditCard cartao = new CreditCard(numero, nome, cvv, limite, valor);
				
				if(cartao.verificarLimite(limite, valor)) {
					cartao.realizarPagamento();
					cartao.gerarRecibo();
				} else {
					System.out.println("O limite do cartão é insuficiente.");
				}
				break;
			case 2: 
				System.out.print("Conta de origem (xxxxxx): ");
				int contaDeOrigem = sc.nextInt();
				System.out.print("Saldo da conta: ");
				double saldo = sc.nextDouble();
				System.out.print("Conta de destino (xxxxxx): ");
				int contaDeDestino = sc.nextInt();
				System.out.print("Valor a ser pago: ");
				double valor2 = sc.nextDouble();
				
				BankTransfer bt = new BankTransfer(contaDeOrigem, contaDeDestino, valor2, saldo);
				
				if(bt.verificarSaldo(valor2, saldo)) {
					bt.realizarPagamento();
					bt.gerarRecibo();
				} else {
					System.out.println("O saldo da conta é insuficiente.");
				}
				break;
			case 3: 
				System.out.print("Codigo de barras (xxxxxx): ");
				int cod = sc.nextInt();
				System.out.print("Valor a ser pago: ");
				double valor3 = sc.nextDouble();
				
				Ticket boleto = new Ticket(cod, valor3);
				
				boleto.realizarPagamento();
				boleto.gerarRecibo();
				break;
			default:
				System.out.println("Operação inválida.");
				break;
			}
			
			
			sc.close();
		} catch (RuntimeException e) {
			System.out.println("Unexpected Error, try again.");
		}

	}

}
