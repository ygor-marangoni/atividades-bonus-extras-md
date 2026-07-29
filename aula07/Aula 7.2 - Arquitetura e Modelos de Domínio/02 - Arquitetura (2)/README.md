# Arquitetura (2)

## Projeto analisado

Para esta atividade, retornei ao projeto **Pizza Express**, um catálogo digital com painel administrativo. Pelo README do projeto, ele possui frontend em Next.js, API em Express com TypeScript, PostgreSQL para dados transacionais, Elasticsearch para busca e Docker Compose para iniciar os serviços de forma integrada.

## Estilo arquitetural utilizado

Eu identifico uma arquitetura cliente-servidor, separada em frontend e backend. O frontend cuida da interface; a API concentra o acesso às regras e aos dados; PostgreSQL e Elasticsearch assumem responsabilidades diferentes de persistência e busca. O Docker Compose também ajuda a tratar o ambiente como um conjunto de serviços que precisam iniciar na ordem correta.

## Dificuldades percebidas

O ponto que considero mais trabalhoso nessa organização é manter a integração entre várias partes: interface, API, banco, busca e variáveis de ambiente. Uma mudança em produto ou categoria, por exemplo, pode exigir ajuste no backend, no banco e na indexação da busca. Também é preciso cuidar para que dados usados no catálogo e dados usados na pesquisa não fiquem inconsistentes.

## Como eu melhoraria

Eu organizaria o backend cada vez mais por capacidades do negócio, como `catalogo`, `produto`, `categoria` e `administracao`, em vez de deixar a lógica espalhada apenas por tipo técnico. Dentro de cada módulo, eu manteria próximos os casos de uso, validações e acesso aos dados daquela funcionalidade.

Para a integração com Elasticsearch, eu usaria uma fronteira clara: a alteração no catálogo gera uma atualização de índice por um serviço específico, sem permitir que a regra de produto dependa diretamente dos detalhes do mecanismo de busca. Essa separação facilita testar mudanças e trocar detalhes técnicos sem reescrever o que o catálogo significa para o negócio.

## Referência

- [README do projeto Pizza Express](https://github.com/ygor-marangoni/catalogo-pizza-express)
