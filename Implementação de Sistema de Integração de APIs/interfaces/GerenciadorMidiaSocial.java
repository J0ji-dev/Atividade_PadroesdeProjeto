package interfaces;

import models.Conteudo;
import models.Publicacao;
import models.Estatisticas;
import models.RespostaPublicacao;

public interface GerenciadorMidiaSocial {
    RespostaPublicacao publicar(Conteudo conteudo);
    RespostaPublicacao agendarPublicacao(Conteudo conteudo, long timestamp);
    Estatisticas obterEstatisticas(String publicacaoId);
    boolean deletarPublicacao(String publicacaoId);
}