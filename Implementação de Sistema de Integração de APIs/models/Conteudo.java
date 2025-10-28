package models;

public class Conteudo {
    private String texto;
    private String midiaUrl;
    private String[] hashtags;
    private String localizacao;
    
    public Conteudo(String texto, String midiaUrl, String[] hashtags, String localizacao) {
        this.texto = texto;
        this.midiaUrl = midiaUrl;
        this.hashtags = hashtags;
        this.localizacao = localizacao;
    }
    
    // Getters e Setters
    public String getTexto() { return texto; }
    public String getMidiaUrl() { return midiaUrl; }
    public String[] getHashtags() { return hashtags; }
    public String getLocalizacao() { return localizacao; }
    
    public void setTexto(String texto) { this.texto = texto; }
    public void setMidiaUrl(String midiaUrl) { this.midiaUrl = midiaUrl; }
    public void setHashtags(String[] hashtags) { this.hashtags = hashtags; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
}