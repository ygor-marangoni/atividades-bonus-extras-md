# Arquitetura (1)

## Artigo analisado

**Data Management in Microservices: State of the Practice, Challenges, and Research Directions**

O artigo discute como aplicações em microsserviços organizam e mantêm seus dados. A análise parte de literatura, projetos de código aberto e respostas de profissionais e pesquisadores para mostrar quais práticas são mais comuns e quais problemas ainda permanecem abertos.

## Estilos e padrões identificados

O texto usa a arquitetura monolítica como contraste. Nela, módulos e dados costumam estar reunidos, o que simplifica consultas e transações internas. Já nos microsserviços, a aplicação é dividida em serviços independentes, que podem ser implantados e escalados separadamente.

Os padrões que considerei mais importantes foram:

| Estilo ou padrão | Como aparece no artigo |
|---|---|
| Microsserviços | Serviços menores, com responsabilidades próprias e evolução independente. |
| Banco de dados por microsserviço | Cada serviço controla seu estado por tabelas privadas, schema próprio ou banco separado. |
| Persistência poliglota | Serviços podem escolher tecnologias de armazenamento adequadas ao seu tipo de dado. |
| Arquitetura orientada a eventos | Eventos assíncronos permitem comunicação com menor acoplamento direto. |
| Sagas | Coordenam processos que passam por vários serviços sem depender de uma transação única. |
| Orquestração e coreografia | Duas formas de coordenar os passos de um fluxo distribuído. |
| BASE e consistência eventual | Aceita que partes do sistema possam ficar temporariamente divergentes até convergirem. |

## Vantagens apontadas pelos autores

Os autores apontam a escalabilidade por decomposição funcional como uma motivação relevante para microsserviços. Um serviço de busca ou catálogo, por exemplo, pode receber mais recursos sem obrigar o sistema inteiro a crescer junto.

O artigo também destaca a evolução independente dos dados. Quando cada serviço controla o próprio schema ou banco, uma alteração interna não precisa expor detalhes para todos os outros serviços. Isso favorece autonomia e reduz parte do acoplamento.

Outra vantagem apresentada é o isolamento de falhas. A separação entre serviços e bancos pode limitar o impacto de uma indisponibilidade. A arquitetura orientada a eventos também reduz dependências diretas entre etapas que não precisam ocorrer na mesma chamada síncrona.

## Desvantagens e desafios apontados pelos autores

Os autores mostram que o custo dessa autonomia é a distribuição dos dados. Regras que antes poderiam ser garantidas por uma transação ou chave estrangeira passam a exigir coordenação na aplicação. Consultas que precisam combinar pedido, pagamento, estoque e cliente também podem depender de várias chamadas ou de dados replicados.

O artigo destaca ainda o desafio da consistência. Eventos podem chegar fora de ordem, uma atualização pode levar algum tempo para aparecer em outro serviço e uma operação pode falhar no meio do fluxo. Sagas, filas, cache, replicação e APIs ajudam, mas aumentam a necessidade de observabilidade, tratamento de falhas e testes de cenários distribuídos.

O 2-Phase Commit é uma solução tradicional para transações distribuídas, mas o artigo mostra que ele aparece pouco na prática de microsserviços. Isso reforça a ideia de que consistência eventual e compensações são mais comuns nesse estilo arquitetural.

## Minha conclusão

Eu concluo que microsserviços não são apenas um monolito dividido em várias aplicações. A parte mais difícil está no dado: definir quem é responsável por cada informação, como as mudanças se propagam e quando uma inconsistência temporária é aceitável.

Eu usaria esse estilo quando houver necessidade real de autonomia, escala ou evolução independente. Em sistemas menores, um monolito modular pode oferecer menos complexidade e resolver o problema de forma mais direta.

## Referência

- **Data Management in Microservices: State of the Practice, Challenges, and Research Directions.**
