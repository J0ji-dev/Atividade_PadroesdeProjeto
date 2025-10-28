package models;

public class RespostaPublicacao {
    private boolean sucesso;
    private String mensagem;
    private String idPublicacao;
    private String plataforma;
    private long timestamp;
    
    public RespostaPublicacao(boolean sucesso, String mensagem, String idPublicacao, String plataforma, long timestamp) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.idPublicacao = idPublicacao;
        this.plataforma = plataforma;
        this.timestamp = timestamp;
    }
    
    // Getters
    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
    public String getIdPublicacao() { return idPublicacao; }
    public String getPlataforma() { return plataforma; }
    public long getTimestamp() { return timestamp; }
}