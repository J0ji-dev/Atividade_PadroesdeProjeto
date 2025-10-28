package adapters.apis;

import interfaces.ApiMidiaSocial;

public class ApiTwitter implements ApiMidiaSocial {
    @Override
    public String publicarPost(String conteudo, String midia, String accessToken) {
        System.out.println("Publicando no Twitter: " + conteudo);
        // Simulação de API
        return "TWITTER_" + System.currentTimeMillis();
    }
    
    @Override
    public String agendarPost(String conteudo, String midia, long timestamp, String accessToken) {
        System.out.println("Agendando no Twitter para: " + timestamp);
        return "TWITTER_SCHEDULED_" + System.currentTimeMillis();
    }
    
    @Override
    public String obterMetricas(String postId, String accessToken) {
        System.out.println("Obtendo métricas do Twitter para: " + postId);
        return "{\"curtidas\": 150, \"retweets\": 25, \"respostas\": 10}";
    }
    
    @Override
    public boolean deletarPost(String postId, String accessToken) {
        System.out.println("Deletando post do Twitter: " + postId);
        return true;
    }
}