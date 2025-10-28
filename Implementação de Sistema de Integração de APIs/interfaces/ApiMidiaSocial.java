package interfaces;

import models.Conteudo;

public interface ApiMidiaSocial {
    String publicarPost(String conteudo, String midia, String accessToken);
    String agendarPost(String conteudo, String midia, long timestamp, String accessToken);
    String obterMetricas(String postId, String accessToken);
    boolean deletarPost(String postId, String accessToken);
}