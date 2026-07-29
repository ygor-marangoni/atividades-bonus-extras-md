# Arquitetura (2)

## Projeto analisado

Para esta atividade, selecionei o projeto **Pizza Express**, uma aplicação de catálogo digital com painel administrativo.

### Tecnologias utilizadas

| Camada | Tecnologia | Responsabilidade |
|---|---|---|
| Frontend | **Next.js** | Interface do cliente e painel administrativo |
| Backend | **Express com TypeScript** | API e regras de negócio |
| Banco de dados | **PostgreSQL** | Armazenamento dos dados transacionais |
| Busca | **Elasticsearch** | Pesquisa de produtos e categorias |
| Infraestrutura | **Docker Compose** | Integração e inicialização dos serviços |

---

## Estilo arquitetural utilizado

O projeto segue uma arquitetura **cliente-servidor**, com separação entre frontend e backend.

Também apresenta uma organização em camadas:

```text
Frontend
   ↓
API REST
   ↓
Regras de negócio
   ↓
PostgreSQL
```

O frontend realiza requisições para a API, enquanto o backend concentra as regras de negócio e o acesso aos dados.

O **PostgreSQL** mantém os dados principais da aplicação, enquanto o **Elasticsearch** funciona como uma estrutura especializada para busca.

---

## Dificuldades encontradas

A principal dificuldade foi manter a integração e a consistência entre:

- interface;
- API;
- banco de dados;
- mecanismo de busca;
- variáveis de ambiente.

Uma alteração em produtos ou categorias pode exigir mudanças em diferentes partes do sistema e também a atualização do índice do Elasticsearch.

Isso aumenta o risco de:

- duplicação de regras;
- falhas de sincronização;
- inconsistência entre catálogo e pesquisa;
- maior esforço de manutenção.

---

## 4. Como o projeto poderia ser melhorado

Eu reorganizaria o backend em módulos de negócio, como:

```text
catalogo/
pedidos/
clientes/
administracao/
```

Dentro de cada módulo, ficariam próximos:

- casos de uso;
- validações;
- serviços;
- repositórios;
- regras relacionadas à funcionalidade.

Essa abordagem se aproxima de uma **arquitetura modular**, reduzindo o acoplamento entre as funcionalidades e facilitando a manutenção.

---

## Integração com o Elasticsearch

A integração com o Elasticsearch também poderia ser **orientada a eventos**.

Exemplo:

```text
Produto criado ou alterado
          ↓
Evento gerado
          ↓
Serviço de indexação
          ↓
Elasticsearch atualizado
```

Dessa forma, a regra de negócio do produto não dependeria diretamente dos detalhes do Elasticsearch.

### Benefícios

- maior separação de responsabilidades;
- facilidade para testar as regras de negócio;
- redução do acoplamento;
- manutenção mais simples;
- possibilidade de trocar o mecanismo de busca no futuro.

---

## Conclusão

A arquitetura atual atende ao funcionamento da aplicação, mas pode evoluir para uma estrutura mais modular e desacoplada.

A separação por capacidades do negócio e o uso de eventos para atualizar o mecanismo de busca ajudariam a reduzir inconsistências e tornar o sistema mais fácil de manter e expandir.

---

## Referência

- [Projeto Pizza Express](https://github.com/ygor-marangoni/catalogo-pizza-express)
