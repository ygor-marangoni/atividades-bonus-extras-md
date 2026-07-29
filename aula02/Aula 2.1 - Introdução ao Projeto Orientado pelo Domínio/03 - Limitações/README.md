# Limitações do DDD

## Enunciado

Pesquisar situações em que DDD não foi aplicado com sucesso, comentar as causas apontadas e indicar alternativas para lidar com a situação.

## Análise

Eu não trato DDD como uma solução que falha ou funciona sozinha. O que encontrei com mais frequência são situações em que ele foi adotado como um conjunto de padrões, sem que existisse um domínio complexo para justificar o custo.

Um caso típico é um sistema interno com poucos fluxos, regras estáveis e quase todo o trabalho concentrado em cadastro e consulta. Se eu criasse agregados, fábricas, eventos, repositórios e vários contextos nesse cenário, aumentaria a quantidade de código sem melhorar uma decisão relevante. A causa seria a escolha de uma técnica maior do que o problema.

Outra dificuldade acontece quando a equipe modela isolada das pessoas que conhecem a operação. Nesse caso, os nomes podem parecer corretos no código, mas não correspondem ao trabalho real. O resultado é uma linguagem ubíqua apenas no papel e regras descobertas tarde demais.

Como alternativa, eu começaria com um recorte pequeno: descreveria os fluxos mais críticos, validaria os termos com as pessoas da área e manteria o modelo simples enquanto a complexidade não surgisse. Para domínios essencialmente administrativos, uma arquitetura CRUD bem organizada pode ser suficiente. Eu passaria a usar técnicas mais completas de DDD quando regras, exceções e mudanças frequentes exigissem essa disciplina.
