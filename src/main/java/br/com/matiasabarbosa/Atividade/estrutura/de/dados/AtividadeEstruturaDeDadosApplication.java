package br.com.matiasabarbosa.Atividade.estrutura.de.dados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AtividadeEstruturaDeDadosApplication {
	private static List<Produto> listaProdutos = new LinkedList<>();
	private static int proximoId = 1;

	public static void main(String[] args) {
		SpringApplication.run(AtividadeEstruturaDeDadosApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		Produto produto1 = new Produto(1, "Detergente", 10);

		produto1.adicionarEstoque(10);

		System.out.println(produto1);

		while (true) {
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Incluir Produto");
			System.out.println("2 - Excluir Produto");
			System.out.println("3 - Adicionar Estoque");
			System.out.println("4 - Listar Produtos");
			System.out.println("5 - Sair");

			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					incluirProduto(scanner);
					break;
				case 2:
					excluirProduto(scanner);
					break;
				case 3:
					adicionarEstoque(scanner);
					break;
				case 4:
					listarProdutos();
					break;
				case 5:
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Opção inválida!");
			}
		}
	}

	private static void incluirProduto(Scanner scanner) {
		System.out.print("Digite o nome do produto: ");
		String nome = scanner.next();
		System.out.print("Digite a quantidade em estoque: ");
		int quantidadeEstoque = scanner.nextInt();

		Produto produto = new Produto(proximoId++, nome, quantidadeEstoque);
		listaProdutos.add(produto);
		System.out.println("Produto cadastrado com sucesso!");
	}

	private static void excluirProduto(Scanner scanner) {
		System.out.print("Digite o ID do produto a ser excluído: ");
		int id = scanner.nextInt();

		for (Produto produto : listaProdutos) {
			if (produto.getId() == id) {
				listaProdutos.remove(produto);
				System.out.println("Produto removido com sucesso!");
				return;
			}
		}

		System.out.println("Produto não encontrado!");
	}

	private static void adicionarEstoque(Scanner scanner) {
		System.out.print("Digite o ID do produto para adicionar estoque: ");
		int id = scanner.nextInt();

		for (Produto produto : listaProdutos) {
			if (produto.getId() == id) {
				System.out.print("Digite a quantidade a ser adicionada ao estoque: ");
				int quantidade = scanner.nextInt();
				produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
				System.out.println("Estoque atualizado com sucesso!");
				return;
			}
		}

		System.out.println("Produto não encontrado!");
	}

	private static void listarProdutos() {
		System.out.println("Lista de Produtos:");
		for (Produto produto : listaProdutos) {
			System.out.println(produto);
		}
	}
}