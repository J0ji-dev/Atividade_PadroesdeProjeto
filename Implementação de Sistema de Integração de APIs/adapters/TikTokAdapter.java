package adapters;

import interfaces.GerenciadorMidiaSocial;
import interfaces.ApiMidiaSocial;
import adapters.apis.ApiTikTok;
import models.*;
import config.Configuracao;

public class TikTokAdapter implements GerenciadorMidiaSocial {
    private ApiMidiaSocial apiTikTok;
    private Configuracao config;
    
    public TikTokAdapter(Configuracao config) {
        this.apiTikTok = new ApiTikTok();
        this.config = config;
    }
    
    @Override
    public RespostaPublicacao publicar(Conteudo conteudo) {
        try {
            String accessToken = config.getAccessToken("tiktok");
            String postId = apiTikTok.publicarPost(
                formatarConteudoTikTok(conteudo), 
                conteudo.getMidiaUrl(), 
                accessToken
            );
            
            return new RespostaPublicacao(
                true, 
                "Publicado com sucesso no TikTok", 
                postId, 
                "tiktok", 
                System.currentTimeMillis()
            );
        } catch (Exception e) {
            return new RespostaPublicacao(
                false, 
                "Erro ao publicar no TikTok: " + e.getMessage(), 
                null, 
                "tiktok", 
                System.currentTimeMillis()
            );
        }
    }
    
    @Override
    public RespostaPublicacao agendarPublicacao(Conteudo conteudo, long timestamp) {
        try {
            String accessToken = config.getAccessToken("tiktok");
            String postId = apiTikTok.agendarPost(
                formatarConteudoTikTok(conteudo), 
                conteudo.getMidiaUrl(), 
                timestamp, 
                accessToken
            );
            
            return new RespostaPublicacao(
                true, 
                "Agendado com sucesso no TikTok", 
                postId, 
                "tiktok", 
                timestamp
            );
        } catch (Exception e) {
            return new RespostaPublicacao(
                false, 
                "Erro ao agendar no TikTok: " + e.getMessage(), 
                null, 
                "tiktok", 
                timestamp
            );
        }
    }
    
    @Override
    public Estatisticas obterEstatisticas(String publicacaoId) {
        try {
            String accessToken = config.getAccessToken("tiktok");
            String metricas = apiTikTok.obterMetricas(publicacaoId, accessToken);
            // Simulação de parsing das métricas específicas do TikTok
            return new Estatisticas(2500, 150, 300, 50000, 0.06);
        } catch (Exception e) {
            return new Estatisticas(0, 0, 0, 0, 0.0);
        }
    }
    
    @Override
    public boolean deletarPublicacao(String publicacaoId) {
        try {
            String accessToken = config.getAccessToken("tiktok");
            return apiTikTok.deletarPost(publicacaoId, accessToken);
        } catch (Exception e) {
            return false;
        }
    }
    
    private String formatarConteudoTikTok(Conteudo conteudo) {
        StringBuilder sb = new StringBuilder();
        sb.append(conteudo.getTexto());
        
        // TikTok usa hashtags de forma diferente - mais focadas em trends
        if (conteudo.getHashtags() != null) {
            sb.append("\n");
            for (String hashtag : conteudo.getHashtags()) {
                sb.append("#").append(hashtag).append(" ");
            }
        }
        
        // Adiciona emojis e formatação típica do TikTok
        if (!sb.toString().contains("🔥") && !sb.toString().contains("💫")) {
            sb.append(" 🔥💫");
        }
        
        return sb.toString();
    }
}