package semananove;

import java.util.Scanner;

public class programa {

	public static void main(String[] args) {
		
		int option = 1;
		
		Scanner scan = new Scanner(System.in);
		
		while (option != 0) {
			
			System.out.println("1 para CRIAR novo produto");
			System.out.println("2 para LISTAR todos os Produtos");
			System.out.println("3 para DELETAR um produto");
			System.out.println("0 para SAIR");
			System.out.println("Selecione uma opção: ");
			
			option = scan.nextInt();
			
			switch (option) {
			
			case 1:
				ProdutoControlador criarproduto = new ProdutoControlador(); 
				criarproduto.criarProduto();
				break;
									
			case 2:
				ProdutoControlador listarproduto = new ProdutoControlador(); 
				listarproduto.listarProduto();
				break;
			
			case 3:
				ProdutoControlador deletarproduto = new ProdutoControlador();
				deletarproduto.deletarProduto();
				break;
				
			case 0:
				System.out.println("Tchau!");
				break;
				
			}
		}
	}

}
