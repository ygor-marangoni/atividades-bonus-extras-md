# Atividade — Implementando uma `NotaFiscalFabrica`

## 1. Ideia da solução

A atividade pede a implementação de uma **fábrica** responsável por criar uma nota fiscal.

A fábrica deve receber os dados necessários, validar se os itens não estão vazios e calcular os impostos automaticamente.

Neste exemplo, a classe `NotaFiscalFabrica` centraliza a criação da `NotaFiscal`, evitando que a lógica de validação e cálculo fique espalhada pelo sistema.

---

## 2. Código completo em Java

```java
import java.util.ArrayList;
import java.util.List;

class ItemNotaFiscal {
    private String descricao;
    private int quantidade;
    private double valorUnitario;

    public ItemNotaFiscal(String descricao, int quantidade, double valorUnitario) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double calcularSubtotal() {
        return quantidade * valorUnitario;
    }
}

class NotaFiscal {
    private String cliente;
    private List<ItemNotaFiscal> itens;
    private double subtotal;
    private double imposto;
    private double total;

    public NotaFiscal(String cliente, List<ItemNotaFiscal> itens, double subtotal, double imposto, double total) {
        this.cliente = cliente;
        this.itens = itens;
        this.subtotal = subtotal;
        this.imposto = imposto;
        this.total = total;
    }

    public void exibirNotaFiscal() {
        System.out.println("===== NOTA FISCAL =====");
        System.out.println("Cliente: " + cliente);
        System.out.println();

        for (ItemNotaFiscal item : itens) {
            System.out.println("Item: " + item.getDescricao());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("Valor unitario: R$ " + item.getValorUnitario());
            System.out.println("Subtotal do item: R$ " + item.calcularSubtotal());
            System.out.println("-----------------------");
        }

        System.out.println("Subtotal: R$ " + subtotal);
        System.out.println("Imposto: R$ " + imposto);
        System.out.println("Total: R$ " + total);
    }
}

class NotaFiscalFabrica {
    private static final double TAXA_IMPOSTO = 0.10;

    public static NotaFiscal criarNotaFiscal(String cliente, List<ItemNotaFiscal> itens) {
        validarCliente(cliente);
        validarItens(itens);

        double subtotal = calcularSubtotal(itens);
        double imposto = calcularImposto(subtotal);
        double total = subtotal + imposto;

        return new NotaFiscal(cliente, itens, subtotal, imposto, total);
    }

    private static void validarCliente(String cliente) {
        if (cliente == null || cliente.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
        }
    }

    private static void validarItens(List<ItemNotaFiscal> itens) {
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("A nota fiscal deve possuir pelo menos um item.");
        }

        for (ItemNotaFiscal item : itens) {
            if (item.getDescricao() == null || item.getDescricao().trim().isEmpty()) {
                throw new IllegalArgumentException("A descrição do item não pode ser vazia.");
            }

            if (item.getQuantidade() <= 0) {
                throw new IllegalArgumentException("A quantidade do item deve ser maior que zero.");
            }

            if (item.getValorUnitario() <= 0) {
                throw new IllegalArgumentException("O valor unitário do item deve ser maior que zero.");
            }
        }
    }

    private static double calcularSubtotal(List<ItemNotaFiscal> itens) {
        double subtotal = 0;

        for (ItemNotaFiscal item : itens) {
            subtotal += item.calcularSubtotal();
        }

        return subtotal;
    }

    private static double calcularImposto(double subtotal) {
        return subtotal * TAXA_IMPOSTO;
    }
}

public class Main {
    public static void main(String[] args) {
        List<ItemNotaFiscal> itens = new ArrayList<>();

        itens.add(new ItemNotaFiscal("Mouse Gamer", 2, 80.00));
        itens.add(new ItemNotaFiscal("Teclado Mecânico", 1, 250.00));
        itens.add(new ItemNotaFiscal("Monitor", 1, 900.00));

        NotaFiscal notaFiscal = NotaFiscalFabrica.criarNotaFiscal("Ygor Marangoni", itens);

        notaFiscal.exibirNotaFiscal();
    }
}
```

---

## 3. Explicação do padrão Fábrica aplicado

A classe `NotaFiscalFabrica` é responsável por criar objetos do tipo `NotaFiscal`.

Ela recebe o nome do cliente e a lista de itens, depois faz três etapas principais:

1. Valida se o cliente foi informado.
2. Valida se a lista de itens não está vazia.
3. Calcula automaticamente subtotal, imposto e total.

Depois disso, ela retorna uma `NotaFiscal` pronta para uso.

---

## 4. Por que isso é uma fábrica?

Porque o código principal não precisa saber todos os detalhes de criação da nota fiscal.

Em vez de fazer isso diretamente:

```java
NotaFiscal nota = new NotaFiscal(...);
```

O sistema usa a fábrica:

```java
NotaFiscal nota = NotaFiscalFabrica.criarNotaFiscal("Ygor Marangoni", itens);
```

Assim, a lógica de criação fica centralizada em um único lugar.

---

## 5. Saída esperada

```text
===== NOTA FISCAL =====
Cliente: Ygor Marangoni

Item: Mouse Gamer
Quantidade: 2
Valor unitario: R$ 80.0
Subtotal do item: R$ 160.0
-----------------------
Item: Teclado Mecânico
Quantidade: 1
Valor unitario: R$ 250.0
Subtotal do item: R$ 250.0
-----------------------
Item: Monitor
Quantidade: 1
Valor unitario: R$ 900.0
Subtotal do item: R$ 900.0
-----------------------
Subtotal: R$ 1310.0
Imposto: R$ 131.0
Total: R$ 1441.0
```

---

## 6. Conclusão

A implementação usa o padrão de criação **Fábrica** para gerar uma nota fiscal de forma organizada.

A fábrica ficou responsável por:

- Criar a nota fiscal.
- Validar os dados obrigatórios.
- Impedir itens vazios ou inválidos.
- Calcular os impostos automaticamente.
- Retornar a nota fiscal pronta para ser usada.

Com isso, o código fica mais limpo, reutilizável e fácil de manter.
