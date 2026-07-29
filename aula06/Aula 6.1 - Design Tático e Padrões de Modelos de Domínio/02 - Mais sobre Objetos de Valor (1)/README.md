# Mais sobre Objetos de Valor (1)

## Identificação

- Aula: 6.1
- Tema: características de Value Objects

## Solução

Uma coordenada de entrega pode ser um objeto de valor formado por latitude e longitude. Sua identidade é o conjunto de valores, não um identificador artificial. Ela deve validar os limites geográficos e ser imutável para poder circular entre partes do sistema sem alteração inesperada.

Esse tipo é preferível a dois `double` soltos porque dá nome ao conceito e concentra a validação. Para dinheiro, a mesma ideia pede `BigDecimal`, evitando imprecisão de ponto flutuante.

