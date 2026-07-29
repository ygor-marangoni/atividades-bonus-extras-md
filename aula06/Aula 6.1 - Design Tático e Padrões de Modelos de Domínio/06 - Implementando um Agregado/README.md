# Implementando um Agregado

## Identificação

- Aula: 6.1
- Tema: Agregado
- Linguagem: Java

## Ideia do exemplo

Usei um pedido de pizzaria como agregado. O pedido é a raiz responsável pelos seus itens e pelo cálculo do total. Assim, qualquer inclusão passa por uma regra única, em vez de permitir que objetos externos alterem a lista diretamente.

## Estrutura

| Arquivo | Responsabilidade |
|---|---|
| `Pedido.java` | Mantém os itens do pedido, valida inclusões e calcula o total. |
| `Main.java` | Cria um pedido com duas pizzas e mostra o valor total. |

## O que o código demonstra

- Raiz do agregado: `Pedido` concentra as operações sobre os itens;
- Encapsulamento: a lista de itens é privada;
- Invariantes: preço não pode ser negativo e quantidade precisa ser maior que zero;
- Regra de negócio: o total é a soma dos subtotais dos itens.

## Resultado esperado

```text
Total: R$ 96.00
```

O pedido possui duas pizzas vegetarianas de R$ 48,00 cada.
