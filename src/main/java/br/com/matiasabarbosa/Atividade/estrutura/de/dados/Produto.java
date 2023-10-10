package br.com.matiasabarbosa.Atividade.estrutura.de.dados;

public class Produto {
    private int id;
    private String nome;
    private int quantidadeEstoque;

    public Produto(int id, String nome, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque += quantidade;
            System.out.println("Estoque adicionado com sucesso. Novo estoque: " + quantidadeEstoque);
        } else {
            System.out.println("A quantidade adicionada deve ser maior que zero.");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Estoque: " + quantidadeEstoque;
    }
}
