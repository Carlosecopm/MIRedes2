package org.example.model;

public class Lixeira {

    private int id;
    private String nome;
    private int capacidade;

    private float quantidade = 0;

    private boolean disponivel = true;

    public Lixeira(String nome, float capacidade, float quantidade, boolean disponivel) {

    }

    public Lixeira(int id, String nome, int capacidade, float quantidade, boolean disponivel, boolean controle) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        this.controle = controle;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isControle() {
        return controle;
    }

    public void setControle(boolean controle) {
        this.controle = controle;
    }

    private boolean controle = true;

    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }
}
