# Implementando um Value Object

## Identificação

- Aula: 6.1
- Tipo: Java

## Solução

`PeriodoReserva` é imutável e não possui identidade própria: dois períodos com as mesmas datas são equivalentes. A validação fica no construtor e `conflitaCom` representa uma operação do próprio valor.

## Resultado

Ao executar `Main`, a saída é `Conflito: true`.

