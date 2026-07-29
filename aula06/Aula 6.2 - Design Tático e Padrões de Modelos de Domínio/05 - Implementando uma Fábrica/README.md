# Implementando uma Fábrica

## Enunciado

Implementar uma fábrica para gerar uma folha de pagamento de um funcionário, considerando salário base, horas trabalhadas, horas extras e impostos.

## Solução

Usei `FolhaPagamentoFactory` para concentrar os cálculos e a criação da folha. A fábrica recebe o funcionário e a quantidade de horas trabalhadas, identifica as horas extras acima de 160 horas mensais, calcula o adicional de 50% e aplica uma alíquota de imposto de 10% sobre o salário bruto.

Os valores monetários são tratados com `BigDecimal`, evitando imprecisões de ponto flutuante.

## Estrutura

| Classe | Responsabilidade |
|---|---|
| `Funcionario` | Mantém nome e salário base. |
| `FolhaPagamento` | Representa o resultado dos cálculos. |
| `FolhaPagamentoFactory` | Cria a folha e aplica as regras de cálculo. |
| `Main` | Executa um exemplo com 172 horas trabalhadas. |

## Código

[Abrir implementação Java](src/Main.java)

## Resultado esperado

O programa mostra a funcionária, as horas extras, o salário bruto, o imposto e o salário líquido calculados pela fábrica.
