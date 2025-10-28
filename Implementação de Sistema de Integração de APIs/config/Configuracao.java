package config;

import java.util.HashMap;
import java.util.Map;

public class Configuracao {
    private Map<String, String> accessTokens;
    private Map<String, Boolean> plataformasAtivas;
    
    public Configuracao() {
        this.accessTokens = new HashMap<>();
        this.plataformasAtivas = new HashMap<>();
        carregarConfiguracaoPadrao();
    }
    
    private void carregarConfiguracaoPadrao() {
        // Configuração de desenvolvimento
        accessTokens.put("twitter", "twitter_dev_token");
        accessTokens.put("instagram", "instagram_dev_token");
        accessTokens.put("linkedin", "linkedin_dev_token");
        accessTokens.put("tiktok", "tiktok_dev_token");
        
        plataformasAtivas.put("twitter", true);
        plataformasAtivas.put("instagram", true);
        plataformasAtivas.put("linkedin", true);
        plataformasAtivas.put("tiktok", true);
    }
    
    public String getAccessToken(String plataforma) {
        return accessTokens.get(plataforma.toLowerCase());
    }
    
    public boolean isPlataformaAtiva(String plataforma) {
        return plataformasAtivas.getOrDefault(plataforma.toLowerCase(), false);
    }
    
    public void setAccessToken(String plataforma, String token) {
        accessTokens.put(plataforma.toLowerCase(), token);
    }
    
    public void setPlataformaAtiva(String plataforma, boolean ativa) {
        plataformasAtivas.put(plataforma.toLowerCase(), ativa);
    }
}