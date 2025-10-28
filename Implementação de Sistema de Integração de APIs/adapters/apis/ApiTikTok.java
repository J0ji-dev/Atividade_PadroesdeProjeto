package adapters.apis;

import interfaces.ApiMidiaSocial;

public class ApiTikTok implements ApiMidiaSocial {
    @Override
    public String publicarPost(String conteudo, String midia, String accessToken) {
        System.out.println("Publicando no TikTok: " + conteudo);
        return "TIKTOK_" + System.currentTimeMillis();
    }
    
    @Override
    public String agendarPost(String conteudo, String midia, long timestamp, String accessToken) {
        System.out.println("Agendando no TikTok para: " + timestamp);
        return "TIKTOK_SCHEDULED_" + System.currentTimeMillis();
    }
    
    @Override
    public String obterMetricas(String postId, String accessToken) {
        System.out.println("Obtendo métricas do TikTok para: " + postId);
        return "{\"visualizacoes\": 50000, \"curtidas\": 2500, \"comentarios\": 300}";
    }
    
    @Override
    public boolean deletarPost(String postId, String accessToken) {
        System.out.println("Deletando post do TikTok: " + postId);
        return true;
    }
}