# Fábrica — Sistema de RH / Folha de Pagamento

## 1. Contexto

A atividade pede a implementação de uma **fábrica** capaz de gerar uma **folha de pagamento** para um funcionário.

A folha deve considerar:

- Funcionário;
- Quantidade de horas trabalhadas;
- Salário base;
- Horas extras;
- Aplicação de impostos.

O padrão utilizado é o **Factory Method / Fábrica**, pois a responsabilidade de criar a folha de pagamento fica concentrada em uma classe específica, evitando que o código principal precise saber todos os detalhes da criação e dos cálculos.

---

## 2. Ideia da solução

A solução terá as seguintes classes:

| Classe | Responsabilidade |
|---|---|
| `Funcionario` | Armazena os dados do funcionário |
| `FolhaPagamento` | Representa a folha gerada |
| `FolhaPagamentoFactory` | Fábrica responsável por criar a folha |
| `Main` | Classe principal para testar o funcionamento |

---

## 3. Código Java

```java
class Funcionario {
    private String nome;
    private double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
```

```java
class FolhaPagamento {
    private Funcionario funcionario;
    private int horasTrabalhadas;
    private int horasExtras;
    private double valorHorasExtras;
    private double imposto;
    private double salarioBruto;
    private double salarioLiquido;

    public FolhaPagamento(
            Funcionario funcionario,
            int horasTrabalhadas,
            int horasExtras,
            double valorHorasExtras,
            double imposto,
            double salarioBruto,
            double salarioLiquido
    ) {
        this.funcionario = funcionario;
        this.horasTrabalhadas = horasTrabalhadas;
        this.horasExtras = horasExtras;
        this.valorHorasExtras = valorHorasExtras;
        this.imposto = imposto;
        this.salarioBruto = salarioBruto;
        this.salarioLiquido = salarioLiquido;
    }

    public void exibirFolha() {
        System.out.println("===== FOLHA DE PAGAMENTO =====");
        System.out.println("Funcionário: " + funcionario.getNome());
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
        System.out.println("Horas extras: " + horasExtras);
        System.out.println("Salário base: R$ " + funcionario.getSalarioBase());
        System.out.println("Valor das horas extras: R$ " + valorHorasExtras);
        System.out.println("Salário bruto: R$ " + salarioBruto);
        System.out.println("Imposto: R$ " + imposto);
        System.out.println("Salário líquido: R$ " + salarioLiquido);
    }
}
```

```java
class FolhaPagamentoFactory {

    public static FolhaPagamento gerarFolha(Funcionario funcionario, int horasTrabalhadas) {
        int cargaHorariaPadrao = 160;
        int horasExtras = 0;

        if (horasTrabalhadas > cargaHorariaPadrao) {
            horasExtras = horasTrabalhadas - cargaHorariaPadrao;
        }

        double valorHora = funcionario.getSalarioBase() / cargaHorariaPadrao;
        double valorHoraExtra = valorHora * 1.5;
        double valorHorasExtras = horasExtras * valorHoraExtra;

        double salarioBruto = funcionario.getSalarioBase() + valorHorasExtras;
        double imposto = salarioBruto * 0.10;
        double salarioLiquido = salarioBruto - imposto;

        return new FolhaPagamento(
                funcionario,
                horasTrabalhadas,
                horasExtras,
                valorHorasExtras,
                imposto,
                salarioBruto,
                salarioLiquido
        );
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("João Silva", 3000.00);

        FolhaPagamento folha = FolhaPagamentoFactory.gerarFolha(funcionario, 170);

        folha.exibirFolha();
    }
}
```

---

## 4. Explicação

A classe `Funcionario` guarda os dados básicos do funcionário, como nome e salário base.

A classe `FolhaPagamento` representa o resultado final da folha, contendo as horas trabalhadas, horas extras, imposto, salário bruto e salário líquido.

A classe `FolhaPagamentoFactory` é a fábrica. Ela recebe o funcionário e a quantidade de horas trabalhadas, faz os cálculos necessários e retorna uma folha de pagamento pronta.

No exemplo, foi considerada uma carga horária padrão de **160 horas**. Caso o funcionário trabalhe mais que isso, as horas adicionais são tratadas como **horas extras**.

O valor da hora extra foi calculado como **50% maior** que a hora normal.

Também foi aplicado um imposto de **10%** sobre o salário bruto.

---

## 5. Exemplo de cálculo

Considerando:

- Salário base: R$ 3000,00;
- Horas trabalhadas: 170 horas;
- Carga horária padrão: 160 horas;
- Horas extras: 10 horas;
- Imposto: 10%.

Cálculos:

```text
Valor da hora = 3000 / 160
Valor da hora = 18,75

Valor da hora extra = 18,75 * 1,5
Valor da hora extra = 28,125

Valor total das horas extras = 10 * 28,125
Valor total das horas extras = 281,25

Salário bruto = 3000 + 281,25
Salário bruto = 3281,25

Imposto = 3281,25 * 0,10
Imposto = 328,125

Salário líquido = 3281,25 - 328,125
Salário líquido = 2953,125
```

---

## 6. Conclusão

O padrão de criação **Fábrica** foi aplicado porque a criação da folha de pagamento foi centralizada na classe `FolhaPagamentoFactory`.

Assim, o código principal fica mais simples, organizado e com menor dependência das regras internas de cálculo.

Em vez de criar a folha manualmente no `Main`, o sistema apenas solicita à fábrica:

```java
FolhaPagamento folha = FolhaPagamentoFactory.gerarFolha(funcionario, 170);
```

Dessa forma, caso as regras de imposto, horas extras ou salário sejam alteradas futuramente, basta modificar a fábrica, sem precisar alterar todo o sistema.
