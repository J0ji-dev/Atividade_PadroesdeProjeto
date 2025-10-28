package main;

import interfaces.GerenciadorMidiaSocial;
import factories.SocialMediaFactory;
import config.Configuracao;
import models.Conteudo;
import models.RespostaPublicacao;
import models.Estatisticas;

public class SistemaMidiaSocial {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE MÍDIA SOCIAL ===\n");
        
        Configuracao config = new Configuracao();
        SocialMediaFactory factory = new SocialMediaFactory(config);
        
        Conteudo conteudoProfissional = new Conteudo(
            "Estou muito feliz em anunciar o lançamento do nosso novo produto! " +
            "Uma solução inovadora que vai revolucionar o mercado.",
            "https://exemplo.com/produto.jpg",
            new String[]{"inovacao", "tecnologia", "negocios", "carreira"},
            "São Paulo, Brasil"
        );
        
        Conteudo conteudoTikTok = new Conteudo(
            "Descubra como nossa nova feature vai facilitar seu dia a dia! 😱",
            "https://exemplo.com/video.mp4",
            new String[]{"viral", "tech", "dica", "lifehack"},
            ""
        );
        
        System.out.println("📊 TESTANDO LINKEDIN:");
        try {
            GerenciadorMidiaSocial linkedin = factory.criarGerenciador("linkedin");
            
            // Publicação
            RespostaPublicacao respostaLinkedIn = linkedin.publicar(conteudoProfissional);
            System.out.println("✅ " + respostaLinkedIn.getMensagem());
            System.out.println("   ID: " + respostaLinkedIn.getIdPublicacao());
            
            // Estatísticas
            if (respostaLinkedIn.isSucesso()) {
                Estatisticas statsLinkedIn = linkedin.obterEstatisticas(respostaLinkedIn.getIdPublicacao());
                System.out.println("   📈 Estatísticas:");
                System.out.println("   - Visualizações: " + statsLinkedIn.getVisualizacoes());
                System.out.println("   - Reações: " + statsLinkedIn.getCurtidas());
                System.out.println("   - Comentários: " + statsLinkedIn.getComentarios());
                System.out.println("   - Taxa de Engajamento: " + (statsLinkedIn.getTaxaEngajamento() * 100) + "%");
            }
            
            // Agendamento
            long amanha = System.currentTimeMillis() + (24 * 60 * 60 * 1000);
            RespostaPublicacao agendamentoLinkedIn = linkedin.agendarPublicacao(conteudoProfissional, amanha);
            System.out.println("=>" + agendamentoLinkedIn.getMensagem());
            
        } catch (Exception e) {
            System.out.println("Erro no LinkedIn: " + e.getMessage());
        }
        
        System.out.println("\nTESTANDO TIKTOK:");
        // Teste com TikTok
        try {
            GerenciadorMidiaSocial tiktok = factory.criarGerenciador("tiktok");
            
            // Publicação
            RespostaPublicacao respostaTikTok = tiktok.publicar(conteudoTikTok);
            System.out.println("✅ " + respostaTikTok.getMensagem());
            System.out.println("   ID: " + respostaTikTok.getIdPublicacao());
            
            // Estatísticas
            if (respostaTikTok.isSucesso()) {
                Estatisticas statsTikTok = tiktok.obterEstatisticas(respostaTikTok.getIdPublicacao());
                System.out.println("   ==>Estatísticas<==");
                System.out.println("   - Visualizações: " + statsTikTok.getVisualizacoes());
                System.out.println("   - Curtidas: " + statsTikTok.getCurtidas());
                System.out.println("   - Comentários: " + statsTikTok.getComentarios());
                System.out.println("   - Compartilhamentos: " + statsTikTok.getCompartilhamentos());
                System.out.println("   - Taxa de Engajamento: " + (statsTikTok.getTaxaEngajamento() * 100) + "%");
            }
            
        } catch (Exception e) {
            System.out.println("Erro no TikTok: " + e.getMessage());
        }
        
        System.out.println("\n=== TESTE CONCLUÍDO ===");
    }
}