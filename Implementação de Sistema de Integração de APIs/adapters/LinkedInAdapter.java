package adapters;

import interfaces.GerenciadorMidiaSocial;
import interfaces.ApiMidiaSocial;
import adapters.apis.ApiLinkedIn;
import models.*;
import config.Configuracao;

public class LinkedInAdapter implements GerenciadorMidiaSocial {
    private ApiMidiaSocial apiLinkedIn;
    private Configuracao config;
    
    public LinkedInAdapter(Configuracao config) {
        this.apiLinkedIn = new ApiLinkedIn();
        this.config = config;
    }
    
    @Override
    public RespostaPublicacao publicar(Conteudo conteudo) {
        try {
            String accessToken = config.getAccessToken("linkedin");
            String postId = apiLinkedIn.publicarPost(
                formatarConteudoLinkedIn(conteudo), 
                conteudo.getMidiaUrl(), 
                accessToken
            );
            
            return new RespostaPublicacao(
                true, 
                "Publicado com sucesso no LinkedIn", 
                postId, 
                "linkedin", 
                System.currentTimeMillis()
            );
        } catch (Exception e) {
            return new RespostaPublicacao(
                false, 
                "Erro ao publicar no LinkedIn: " + e.getMessage(), 
                null, 
                "linkedin", 
                System.currentTimeMillis()
            );
        }
    }
    
    @Override
    public RespostaPublicacao agendarPublicacao(Conteudo conteudo, long timestamp) {
        try {
            String accessToken = config.getAccessToken("linkedin");
            String postId = apiLinkedIn.agendarPost(
                formatarConteudoLinkedIn(conteudo), 
                conteudo.getMidiaUrl(), 
                timestamp, 
                accessToken
            );
            
            return new RespostaPublicacao(
                true, 
                "Agendado com sucesso no LinkedIn", 
                postId, 
                "linkedin", 
                timestamp
            );
        } catch (Exception e) {
            return new RespostaPublicacao(
                false, 
                "Erro ao agendar no LinkedIn: " + e.getMessage(), 
                null, 
                "linkedin", 
                timestamp
            );
        }
    }
    
    @Override
    public Estatisticas obterEstatisticas(String publicacaoId) {
        try {
            String accessToken = config.getAccessToken("linkedin");
            String metricas = apiLinkedIn.obterMetricas(publicacaoId, accessToken);
            // Simulação de parsing das métricas específicas do LinkedIn
            return new Estatisticas(85, 12, 15, 1200, 0.09);
        } catch (Exception e) {
            return new Estatisticas(0, 0, 0, 0, 0.0);
        }
    }
    
    @Override
    public boolean deletarPublicacao(String publicacaoId) {
        try {
            String accessToken = config.getAccessToken("linkedin");
            return apiLinkedIn.deletarPost(publicacaoId, accessToken);
        } catch (Exception e) {
            return false;
        }
    }
    
    private String formatarConteudoLinkedIn(Conteudo conteudo) {
        StringBuilder sb = new StringBuilder();
        sb.append(conteudo.getTexto());
        
        // LinkedIn é mais profissional - formatação diferente
        if (conteudo.getHashtags() != null && conteudo.getHashtags().length > 0) {
            sb.append("\n\n");
            for (String hashtag : conteudo.getHashtags()) {
                sb.append("#").append(hashtag).append(" ");
            }
        }
        
        if (conteudo.getLocalizacao() != null && !conteudo.getLocalizacao().isEmpty()) {
            sb.append("\n📍 ").append(conteudo.getLocalizacao());
        }
        
        return sb.toString();
    }
}