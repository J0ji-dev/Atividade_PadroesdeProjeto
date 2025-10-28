package factories;

import interfaces.GerenciadorMidiaSocial;
import adapters.*;
import config.Configuracao;

public class SocialMediaFactory {
    private Configuracao config;
    
    public SocialMediaFactory(Configuracao config) {
        this.config = config;
    }
    
    public GerenciadorMidiaSocial criarGerenciador(String plataforma) {
        if (!config.isPlataformaAtiva(plataforma)) {
            throw new IllegalArgumentException("Plataforma " + plataforma + " não está configurada ou ativa");
        }
        
        switch (plataforma.toLowerCase()) {
            case "twitter":
                return new TwitterAdapter(config);
            case "instagram":
                return new InstagramAdapter(config);
            case "linkedin":
                return new LinkedInAdapter(config);
            case "tiktok":
                return new TikTokAdapter(config);
            default:
                throw new IllegalArgumentException("Plataforma não suportada: " + plataforma);
        }
    }
}