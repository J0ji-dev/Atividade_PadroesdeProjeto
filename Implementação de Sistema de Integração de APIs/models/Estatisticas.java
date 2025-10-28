package models;

public class Estatisticas {
    private int curtidas;
    private int compartilhamentos;
    private int comentarios;
    private int visualizacoes;
    private double taxaEngajamento;
    
    public Estatisticas(int curtidas, int compartilhamentos, int comentarios, int visualizacoes, double taxaEngajamento) {
        this.curtidas = curtidas;
        this.compartilhamentos = compartilhamentos;
        this.comentarios = comentarios;
        this.visualizacoes = visualizacoes;
        this.taxaEngajamento = taxaEngajamento;
    }
    
    // Getters
    public int getCurtidas() { return curtidas; }
    public int getCompartilhamentos() { return compartilhamentos; }
    public int getComentarios() { return comentarios; }
    public int getVisualizacoes() { return visualizacoes; }
    public double getTaxaEngajamento() { return taxaEngajamento; }
}