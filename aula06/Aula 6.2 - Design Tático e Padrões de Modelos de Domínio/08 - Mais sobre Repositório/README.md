# Atividade — ProdutoRepositorio

[Abrir implementação Java por arquivo serializado](src/Main.java)

## Tema

Implementar um `ProdutoRepositorio` com uma operação para buscar produtos por faixa de preço.

A interface deve ter o seguinte método:

```java
List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max);
```

A atividade pede duas formas de implementação:

1. usando Hibernate com `@NamedQuery`;
2. usando recuperação de objetos de um arquivo serializado.

---

# 1. Classe Produto

```java
import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(
    name = "Produto.buscarPorFaixaDePreco",
    query = "SELECT p FROM Produto p WHERE p.preco BETWEEN :min AND :max"
)
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String nome;

    private BigDecimal preco;

    public Produto() {
    }

    public Produto(Long id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + " | Preço: R$ " + preco;
    }
}
```

---

# 2. Interface ProdutoRepositorio

```java
import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepositorio {

    List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max);
}
```

A interface define o que o repositório precisa fazer.

Neste caso, o método deve retornar todos os produtos cujo preço esteja entre o valor mínimo e o valor máximo.

---

# 3. Implementação 1 — Hibernate com @NamedQuery

```java
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ProdutoRepositorioHibernate implements ProdutoRepositorio {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        return em.createNamedQuery("Produto.buscarPorFaixaDePreco", Produto.class)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }
}
```

## Explicação

A consulta foi definida na classe `Produto` usando `@NamedQuery`.

```java
@NamedQuery(
    name = "Produto.buscarPorFaixaDePreco",
    query = "SELECT p FROM Produto p WHERE p.preco BETWEEN :min AND :max"
)
```

Depois, no repositório, a consulta é chamada pelo nome:

```java
em.createNamedQuery("Produto.buscarPorFaixaDePreco", Produto.class)
```

Assim, o método busca apenas os produtos dentro da faixa de preço informada.

---

# 4. Implementação 2 — Arquivo serializado

Nesta implementação, os produtos são recuperados de um arquivo.

O arquivo simula um banco de dados simples.

```java
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositorioArquivo implements ProdutoRepositorio {

    private String nomeArquivo;

    public ProdutoRepositorioArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        List<Produto> produtos = carregarProdutos();
        List<Produto> produtosFiltrados = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getPreco().compareTo(min) >= 0 &&
                produto.getPreco().compareTo(max) <= 0) {

                produtosFiltrados.add(produto);
            }
        }

        return produtosFiltrados;
    }

    private List<Produto> carregarProdutos() {
        try {
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream leitor = new ObjectInputStream(arquivo);

            List<Produto> produtos = (List<Produto>) leitor.readObject();

            leitor.close();

            return produtos;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
```

---

# 5. Classe para salvar produtos no arquivo

Essa classe serve apenas para criar um arquivo com alguns produtos de exemplo.

```java
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalvarProdutosArquivo {

    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto(1L, "Teclado", new BigDecimal("120.00")));
        produtos.add(new Produto(2L, "Mouse", new BigDecimal("80.00")));
        produtos.add(new Produto(3L, "Monitor", new BigDecimal("900.00")));
        produtos.add(new Produto(4L, "Headset", new BigDecimal("250.00")));

        try {
            FileOutputStream arquivo = new FileOutputStream("produtos.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(arquivo);

            escritor.writeObject(produtos);

            escritor.close();

            System.out.println("Produtos salvos com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao salvar produtos.");
        }
    }
}
```

---

# 6. Testando a implementação com arquivo

```java
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProdutoRepositorio repositorio =
                new ProdutoRepositorioArquivo("produtos.dat");

        List<Produto> produtos =
                repositorio.buscarPorFaixaDePreco(
                        new BigDecimal("100.00"),
                        new BigDecimal("300.00")
                );

        System.out.println("Produtos encontrados:");

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
```

---

# 7. Resultado esperado

Considerando os produtos cadastrados:

```text
Teclado  - R$ 120.00
Mouse    - R$ 80.00
Monitor  - R$ 900.00
Headset  - R$ 250.00
```

Buscando produtos entre `R$ 100.00` e `R$ 300.00`, o resultado será:

```text
Produtos encontrados:
Produto: Teclado | Preço: R$ 120.00
Produto: Headset | Preço: R$ 250.00
```

---

# Conclusão

O `ProdutoRepositorio` centraliza a forma de buscar produtos.

A primeira implementação usa Hibernate com `@NamedQuery`.

A segunda implementação usa um arquivo serializado.

Mesmo usando tecnologias diferentes, o sistema continua chamando o mesmo método:

```java
buscarPorFaixaDePreco(min, max);
```

Isso mostra a vantagem do padrão Repository: trocar a forma de persistência sem mudar a regra principal do sistema.
