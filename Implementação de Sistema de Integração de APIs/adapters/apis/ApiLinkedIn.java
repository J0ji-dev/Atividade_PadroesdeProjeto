package adapters.apis;

import interfaces.ApiMidiaSocial;

public class ApiLinkedIn implements ApiMidiaSocial {
    @Override
    public String publicarPost(String conteudo, String midia, String accessToken) {
        System.out.println("Publicando no LinkedIn: " + conteudo);
        return "LINKEDIN_" + System.currentTimeMillis();
    }
    
    @Override
    public String agendarPost(String conteudo, String midia, long timestamp, String accessToken) {
        System.out.println("Agendando no LinkedIn para: " + timestamp);
        return "LINKEDIN_SCHEDULED_" + System.currentTimeMillis();
    }
    
    @Override
    public String obterMetricas(String postId, String accessToken) {
        System.out.println("Obtendo métricas do LinkedIn para: " + postId);
        return "{\"visualizacoes\": 1200, \"reacoes\": 85, \"comentarios\": 15}";
    }
    
    @Override
    public boolean deletarPost(String postId, String accessToken) {
        System.out.println("Deletando post do LinkedIn: " + postId);
        return true;
    }
}