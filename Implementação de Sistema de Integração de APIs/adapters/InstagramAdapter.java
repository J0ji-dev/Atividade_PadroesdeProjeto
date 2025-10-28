package adapters;

import interfaces.GerenciadorMidiaSocial;
import interfaces.ApiMidiaSocial;
import adapters.apis.ApiInstagram;
import models.*;
import config.Configuracao;

public class InstagramAdapter implements GerenciadorMidiaSocial {
    private ApiMidiaSocial apiInstagram;
    private Configuracao config;
    
    public InstagramAdapter(Configuracao config) {
        this.apiInstagram = new ApiInstagram();
        this.config = config;
    }
    
    @Override
    public RespostaPublicacao publicar(Conteudo conteudo) {
        try {
            String accessToken = config.getAccessToken("instagram");
            String postId = apiInstagram.publicarPost(
                conteudo.getTexto(), 
                conteudo.getMidiaUrl(), 
                accessToken
            );
            
            return new RespostaPublicacao(
                true, 
                "Publicado com sucesso no Instagram", 
                postId, 
                "instagram", 
                System.currentTimeMillis()
            );
        } catch (Exception e) {
            return new RespostaPublicacao(
                false, 
                "Erro ao publicar no Instagram: " + e.getMessage(), 
                null, 
                "instagram", 
                System.currentTimeMillis()
            );
        }
    }
    
    @Override
    public RespostaPublicacao agendarPublicacao(Conteudo conteudo, long timestamp) {
        try {
            String accessToken = config.getAccessToken("instagram");
            String postId = apiInstagram.agendarPost(
                conteudo.getTexto(), 
                conteudo.getMidiaUrl(), 
                timestamp, 
                accessToken
            );
            
            return new RespostaPublicacao(
                true, 
                "Agendado com sucesso no Instagram", 
                postId, 
                "instagram", 
                timestamp
            );
        } catch (Exception e) {
            return new RespostaPublicacao(
                false, 
                "Erro ao agendar no Instagram: " + e.getMessage(), 
                null, 
                "instagram", 
                timestamp
            );
        }
    }
    
    @Override
    public Estatisticas obterEstatisticas(String publicacaoId) {
        try {
            String accessToken = config.getAccessToken("instagram");
            String metricas = apiInstagram.obterMetricas(publicacaoId, accessToken);
            // Simulação de parsing das métricas
            return new Estatisticas(500, 0, 45, 2500, 0.22);
        } catch (Exception e) {
            return new Estatisticas(0, 0, 0, 0, 0.0);
        }
    }
    
    @Override
    public boolean deletarPublicacao(String publicacaoId) {
        try {
            String accessToken = config.getAccessToken("instagram");
            return apiInstagram.deletarPost(publicacaoId, accessToken);
        } catch (Exception e) {
            return false;
        }
    }
}