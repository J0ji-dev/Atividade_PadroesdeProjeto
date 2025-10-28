##ESTRUTURA DO PROJETO:
Implementação de Sistema de Integração de APIs/
├── interfaces/
│   ├── GerenciadorMidiaSocial.java
│   └── ApiMidiaSocial.java
├── adapters/
│   ├── TwitterAdapter.java
│   ├── InstagramAdapter.java
│   ├── LinkedInAdapter.java
│   ├── TikTokAdapter.java
│   └── apis/
│       ├── ApiTwitter.java
│       ├── ApiInstagram.java
│       ├── ApiLinkedIn.java
│       └── ApiTikTok.java
├── models/
│   ├── Conteudo.java
│   ├── Publicacao.java
│   ├── Estatisticas.java
│   └── RespostaPublicacao.java
├── factories/
│   └── SocialMediaFactory.java
├── config/
│   └── Configuracao.java
└── main/
    └── SistemaMidiaSocial.jav
