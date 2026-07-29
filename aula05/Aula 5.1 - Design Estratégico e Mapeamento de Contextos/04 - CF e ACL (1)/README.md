# CF e ACL (1)

## Identificação

- Aula: 5.1
- Tema: Conformist e Anti-Corruption Layer
- Tipo: análise comparativa

## Solução

No padrão **Conformist (CF)**, o contexto downstream aceita o modelo e a linguagem do upstream. Isso reduz custo de tradução, mas cria dependência semântica. Na **Anti-Corruption Layer (ACL)**, o downstream converte o contrato externo para seus próprios conceitos, preservando seu modelo.

CF pode ser aceitável quando o upstream é estável, confiável e representa de fato o mesmo conceito. ACL é preferível quando um legado usa termos ou regras que seriam prejudiciais dentro do novo contexto.

