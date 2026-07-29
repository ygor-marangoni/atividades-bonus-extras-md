# Atividade — Repositório Básico

## Tema

Implementar um **Repositório** para um Sistema Bancário com a classe `ContaBancaria`.

A ideia do padrão **Repository** é separar a regra de negócio da forma como os dados são salvos ou buscados.

Neste exemplo, vamos fazer de forma simples, usando uma lista em memória.

---

## 1. Classe ContaBancaria

```java
public class ContaBancaria {

    private String numero;
    private String titular;
    private double saldo;

    public ContaBancaria(String numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean saldoNegativo() {
        return saldo < 0;
    }
}
```

---

## 2. Interface ContaBancariaRepositorio

A interface define o que o repositório deve fazer.

```java
import java.util.List;

public interface ContaBancariaRepositorio {

    void salvar(ContaBancaria conta);

    ContaBancaria buscarPorNumero(String numero);

    List<ContaBancaria> buscarContasComSaldoNegativo();
}
```

---

## 3. Implementação do Repositório

Aqui usamos uma `ArrayList` para simular o banco de dados.

```java
import java.util.ArrayList;
import java.util.List;

public class ContaBancariaRepositorioMemoria implements ContaBancariaRepositorio {

    private List<ContaBancaria> contas = new ArrayList<>();

    @Override
    public void salvar(ContaBancaria conta) {
        contas.add(conta);
    }

    @Override
    public ContaBancaria buscarPorNumero(String numero) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }

        return null;
    }

    @Override
    public List<ContaBancaria> buscarContasComSaldoNegativo() {
        List<ContaBancaria> contasNegativas = new ArrayList<>();

        for (ContaBancaria conta : contas) {
            if (conta.saldoNegativo()) {
                contasNegativas.add(conta);
            }
        }

        return contasNegativas;
    }
}
```

---

## 4. Classe Principal

```java
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ContaBancariaRepositorio repositorio = new ContaBancariaRepositorioMemoria();

        ContaBancaria conta1 = new ContaBancaria("001", "João", 500.00);
        ContaBancaria conta2 = new ContaBancaria("002", "Maria", -150.00);
        ContaBancaria conta3 = new ContaBancaria("003", "Pedro", -50.00);

        repositorio.salvar(conta1);
        repositorio.salvar(conta2);
        repositorio.salvar(conta3);

        List<ContaBancaria> contasNegativas =
                repositorio.buscarContasComSaldoNegativo();

        System.out.println("Contas com saldo negativo:");

        for (ContaBancaria conta : contasNegativas) {
            System.out.println("Número: " + conta.getNumero());
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println("-------------------------");
        }
    }
}
```

---

## 5. Explicação

Neste exemplo, a classe `ContaBancaria` representa o domínio do sistema bancário.

A interface `ContaBancariaRepositorio` define os métodos principais:

- salvar uma conta;
- buscar uma conta pelo número;
- buscar contas com saldo negativo.

A classe `ContaBancariaRepositorioMemoria` implementa esses métodos usando uma lista.

O método mais importante da atividade é:

```java
buscarContasComSaldoNegativo();
```

Ele percorre todas as contas e retorna apenas aquelas que possuem saldo menor que zero.

---

## Conclusão

O padrão **Repository** ajuda a organizar o código porque concentra as operações de busca e salvamento em uma classe específica.

Mesmo usando uma lista simples, a ideia principal já aparece: o sistema usa o repositório sem precisar saber exatamente como os dados são armazenados.
