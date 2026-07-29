# ACL, OHS e PL (2)

## Identificação

- Aula: 5.1
- Tema: aplicação de padrões de integração
- Tipo: proposta

## Solução

Para o Pizza Express, o contexto Cardápio pode oferecer um OHS `consultarItensDisponiveis`. A PL define campos como identificador, nome comercial, preço vigente e indisponibilidade. O contexto Pedidos mantém uma ACL que transforma a resposta em `ItemSelecionável`, validando preço e disponibilidade antes de aceitar um pedido.

Se o Cardápio trocar o fornecedor de dados ou alterar campos internos, a mudança fica limitada ao serviço publicado. Se Pedidos mudar seus invariantes, a tradução continua protegendo o modelo de pedido.

