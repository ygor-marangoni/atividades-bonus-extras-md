# Implementando um Value Object

## Identificação

- Aula: 6.1
- Tema: Value Object
- Linguagem: Java

## Ideia do exemplo

Usei um período de reserva para representar um objeto de valor. Ele é definido pelas datas de entrada e saída; não existe um código próprio que o diferencie. Por isso, dois períodos com as mesmas datas devem ser considerados equivalentes.

## Estrutura

| Arquivo | Responsabilidade |
|---|---|
| `PeriodoReserva.java` | Valida as datas e verifica conflito entre dois períodos. |
| `Main.java` | Cria dois períodos de exemplo e apresenta o resultado. |

## O que o código demonstra

- Imutabilidade: as datas são definidas na criação do objeto;
- Validação: a saída precisa ser posterior à entrada;
- Comparação por valor: `equals` e `hashCode` usam as datas;
- Regra do domínio: dois períodos entram em conflito quando se sobrepõem.

## Resultado esperado

```text
Conflito: true
```

Os períodos de 4 a 7 de setembro e de 6 a 9 de setembro possuem datas sobrepostas; por isso, o conflito é verdadeiro.
