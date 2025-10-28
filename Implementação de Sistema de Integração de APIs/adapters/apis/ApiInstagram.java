package adapters.apis;

import interfaces.ApiMidiaSocial;

public class ApiInstagram implements ApiMidiaSocial {
    @Override
    public String publicarPost(String conteudo, String midia, String accessToken) {
        System.out.println("Publicando no Instagram: " + conteudo);
        return "INSTAGRAM_" + System.currentTimeMillis();
    }
    
    @Override
    public String agendarPost(String conteudo, String midia, long timestamp, String accessToken) {
        System.out.println("Agendando no Instagram para: " + timestamp);
        return "INSTAGRAM_SCHEDULED_" + System.currentTimeMillis();
    }
    
    @Override
    public String obterMetricas(String postId, String accessToken) {
        System.out.println("Obtendo métricas do Instagram para: " + postId);
        return "{\"curtidas\": 500, \"comentarios\": 45, \"salvos\": 12}";
    }
    
    @Override
    public boolean deletarPost(String postId, String accessToken) {
        System.out.println("Deletando post do Instagram: " + postId);
        return true;
    }
}