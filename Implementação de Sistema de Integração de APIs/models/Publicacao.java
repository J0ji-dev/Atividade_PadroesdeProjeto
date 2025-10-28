package models;

public class Publicacao {
    private String id;
    private String plataforma;
    private Conteudo conteudo;
    private long dataPublicacao;
    private String status;
    
    public Publicacao(String id, String plataforma, Conteudo conteudo, long dataPublicacao, String status) {
        this.id = id;
        this.plataforma = plataforma;
        this.conteudo = conteudo;
        this.dataPublicacao = dataPublicacao;
        this.status = status;
    }
    
    // Getters e Setters
    public String getId() { return id; }
    public String getPlataforma() { return plataforma; }
    public Conteudo getConteudo() { return conteudo; }
    public long getDataPublicacao() { return dataPublicacao; }
    public String getStatus() { return status; }
}