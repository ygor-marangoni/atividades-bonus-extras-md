# DDD: Por quê?

## Enunciado

1. Compare e comente como se dá a construção de estradas:
   - Feitas sobre caminhos antigos de carroças;
   - Planejadas para atender diversas demandas de uma cidade, como meio ambiente, fluxo, eficiência, economia, entre outras.

2. Quais modelos/projetos podem ser pensados para cada situação?

3. Qual dará o melhor resultado aos interessados? Analise os impactos das opções.

---

## 1. Comparação sobre a construção de estradas

A construção de estradas pode ser comparada ao desenvolvimento de sistemas. Em alguns casos, uma estrada é feita apenas aproveitando um caminho antigo, sem muito planejamento. Em outros, ela é projetada de forma estratégica, considerando as necessidades reais da cidade e das pessoas que irão utilizá-la.

Essa comparação ajuda a entender o motivo do uso do **DDD (Domain-Driven Design)**. O DDD defende que um sistema deve ser construído a partir do entendimento do domínio, ou seja, das regras, necessidades e problemas reais do negócio.

### Estradas feitas sobre caminhos antigos de carroças

As estradas feitas sobre caminhos antigos de carroças surgem a partir de rotas que já eram utilizadas no passado. Esses caminhos eram criados de forma prática, conforme a necessidade imediata das pessoas, sem estudos profundos sobre segurança, fluxo, crescimento urbano ou impacto ambiental.

Com o tempo, esses caminhos podem ser pavimentados e melhorados, mas continuam carregando limitações da rota original.

No desenvolvimento de software, isso acontece quando um sistema apenas copia processos antigos, como planilhas, formulários manuais ou controles improvisados.

Exemplo:

> Uma empresa controlava pedidos em uma planilha. Depois, cria um sistema que funciona praticamente como uma planilha digital.

Nesse caso, o sistema pode até funcionar inicialmente, mas tende a manter problemas antigos, como processos confusos, retrabalho e pouca eficiência.

### Estradas planejadas para atender demandas da cidade

As estradas planejadas são pensadas com base em estudos e necessidades reais. Antes da construção, são analisados fatores como fluxo de veículos, segurança, meio ambiente, custo, economia, transporte público, crescimento da cidade e eficiência no deslocamento.

Esse tipo de estrada não é feito apenas porque já existia um caminho. Ela é projetada para resolver melhor os problemas atuais e futuros.

No software, isso se aproxima da ideia do DDD. Antes de desenvolver o sistema, busca-se entender o domínio, as regras de negócio, os usuários e os impactos da solução.

Exemplo:

> Antes de criar uma tela de pedidos, entende-se como um pedido nasce, quem pode aprovar, quando pode ser cancelado, quando gera pagamento, quando movimenta estoque e quem precisa ser notificado.

Assim, o sistema deixa de ser apenas uma cópia do processo antigo e passa a representar melhor a realidade do negócio.

---

## 2. Modelos ou projetos para cada situação

### Modelo para estradas feitas sobre caminhos antigos

Nesse tipo de situação, o projeto tende a ser mais simples e adaptativo. A ideia principal é melhorar algo que já existe, sem alterar profundamente sua estrutura.

Algumas ações possíveis seriam:

- Pavimentar o caminho existente;
- Alargar partes da estrada;
- Corrigir curvas perigosas;
- Tapar buracos;
- Adicionar sinalização;
- Fazer melhorias pontuais.

No desenvolvimento de software, esse modelo se parece com:

- Automatizar uma planilha existente;
- Criar telas simples de cadastro;
- Copiar o fluxo antigo da empresa;
- Resolver apenas uma necessidade imediata;
- Fazer pequenas melhorias em processos já existentes.

Esse tipo de projeto pode ser útil quando o problema é simples, o orçamento é limitado ou há urgência na entrega. Porém, ele pode não resolver a causa real dos problemas.

### Modelo para estradas planejadas

Nesse caso, o projeto é mais estratégico e completo. Antes da execução, são realizados estudos e planejamentos para garantir que a estrada atenda bem aos interessados.

Algumas ações possíveis seriam:

- Estudo de tráfego;
- Estudo ambiental;
- Planejamento urbano;
- Análise de custo-benefício;
- Projeção de crescimento da cidade;
- Integração com transporte público;
- Planejamento de segurança;
- Plano de manutenção futura.

No desenvolvimento de software com DDD, isso se relaciona com:

- Entender o domínio do sistema;
- Conversar com especialistas do negócio;
- Identificar regras importantes;
- Definir entidades e processos;
- Criar uma linguagem comum entre equipe técnica e usuários;
- Modelar o sistema antes da implementação;
- Pensar na evolução futura da solução.

Esse modelo exige mais tempo no início, mas tende a gerar um sistema mais organizado, eficiente e preparado para mudanças.

---

## 3. Melhor resultado aos interessados e análise dos impactos

De modo geral, a estrada planejada tende a oferecer o melhor resultado aos interessados, pois considera as necessidades atuais e futuras da cidade. Ela leva em conta não apenas o caminho mais rápido de construir, mas também fatores como segurança, eficiência, economia, meio ambiente e crescimento urbano.

A estrada feita sobre caminhos antigos pode ser mais rápida e barata no começo. Porém, ela pode gerar problemas no futuro, como congestionamentos, curvas perigosas, manutenção constante, dificuldade de expansão e baixa eficiência.

No desenvolvimento de software, acontece algo parecido. Um sistema feito apenas copiando processos antigos pode parecer mais simples inicialmente, mas pode gerar impactos negativos, como:

- Código difícil de manter;
- Regras de negócio espalhadas;
- Retrabalho;
- Baixa adaptação a mudanças;
- Experiência ruim para os usuários;
- Solução pouco alinhada ao problema real.

Já um sistema desenvolvido com base no DDD tende a gerar impactos positivos, como:

- Melhor compreensão do negócio;
- Sistema mais alinhado às necessidades dos usuários;
- Menos retrabalho;
- Maior facilidade de manutenção;
- Melhor organização das regras;
- Maior capacidade de evolução;
- Decisões técnicas mais coerentes com o domínio.

Portanto, a opção planejada costuma entregar mais valor aos interessados, mesmo exigindo mais análise no início.

---

## Conclusão

A estrada feita sobre caminhos antigos de carroças representa uma solução baseada na adaptação do passado e no improviso. Já a estrada planejada representa uma solução pensada de forma estratégica, considerando diversos fatores e interessados.

No contexto do DDD, essa comparação mostra que desenvolver um sistema não deve ser apenas transformar processos antigos em telas ou tabelas. O ideal é entender o domínio, suas regras e necessidades, para construir uma solução mais eficiente, organizada e preparada para evoluir.

Assim, o DDD se justifica porque ajuda a criar sistemas mais próximos da realidade do negócio, reduzindo problemas futuros e aumentando o valor entregue aos usuários e demais interessados.