# Mais sobre Objetos de Valor (2)

## Identificação

- Aula: 6.1
- Tema: igualdade e imutabilidade

## Solução

No Pizza Express, `Quantidade` pode ser um Value Object que só aceita valores positivos. Uma quantidade de 2 unidades é igual a outra quantidade de 2 unidades, mesmo que tenham sido criadas em momentos distintos. Alterar um pedido cria uma nova quantidade em vez de modificar o valor anterior.

Essa decisão reduz estados intermediários inválidos e torna as regras explícitas. O objeto não precisa de uma tabela própria nem de um identificador quando só representa esse valor no contexto do pedido.

