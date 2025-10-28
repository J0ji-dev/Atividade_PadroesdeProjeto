package adapters;

import interfaces.GerenciadorMidiaSocial;
import interfaces.ApiMidiaSocial;
import adapters.apis.ApiTwitter;
import models.*;
import config.Configuracao;

public class TwitterAdapter implements GerenciadorMidiaSocial {
    private ApiMidiaSocial apiTwitter;
    private Configuracao config;
    
    public TwitterAdapter(Configuracao config) {
        this.apiTwitter = new ApiTwitter();
        this.config = config;
    }
    
    @Override
    public RespostaPublicacao publicar(Conteudo conteudo) {
        try {
            String accessToken = config.getAccessToken("twitter");
            String postId = apiTwitter.publicarPost(
                formatarConteudo(conteudo), 
                conteudo.getMidiaUrl(), 
                accessToken
            );
            
            return new RespostaPublicacao(
                true, 
                "Publicado com sucesso no Twitter", 
                postId, 
                "twitter", 
                System.currentTimeMillis()
            );
        } catch (Exception e) {
            return new RespostaPublicacao(
                false, 
                "Erro ao publicar no Twitter: " + e.getMessage(), 
                null, 
                "twitter", 
                System.currentTimeMillis()
            );
        }
    }
    
    @Override
    public RespostaPublicacao agendarPublicacao(Conteudo conteudo, long timestamp) {
        try {
            String accessToken = config.getAccessToken("twitter");
            String postId = apiTwitter.agendarPost(
                formatarConteudo(conteudo), 
                conteudo.getMidiaUrl(), 
                timestamp, 
                accessToken
            );
            
            return new RespostaPublicacao(
                true, 
                "Agendado com sucesso no Twitter", 
                postId, 
                "twitter", 
                timestamp
            );
        } catch (Exception e) {
            return new RespostaPublicacao(
                false, 
                "Erro ao agendar no Twitter: " + e.getMessage(), 
                null, 
                "twitter", 
                timestamp
            );
        }
    }
    
    @Override
    public Estatisticas obterEstatisticas(String publicacaoId) {
        try {
            String accessToken = config.getAccessToken("twitter");
            String metricas = apiTwitter.obterMetricas(publicacaoId, accessToken);
            // Simulação de parsing das métricas
            return new Estatisticas(150, 25, 10, 1000, 0.15);
        } catch (Exception e) {
            return new Estatisticas(0, 0, 0, 0, 0.0);
        }
    }
    
    @Override
    public boolean deletarPublicacao(String publicacaoId) {
        try {
            String accessToken = config.getAccessToken("twitter");
            return apiTwitter.deletarPost(publicacaoId, accessToken);
        } catch (Exception e) {
            return false;
        }
    }
    
    private String formatarConteudo(Conteudo conteudo) {
        StringBuilder sb = new StringBuilder();
        sb.append(conteudo.getTexto());
        
        if (conteudo.getHashtags() != null) {
            for (String hashtag : conteudo.getHashtags()) {
                sb.append(" #").append(hashtag);
            }
        }
        
        return sb.toString();
    }
}