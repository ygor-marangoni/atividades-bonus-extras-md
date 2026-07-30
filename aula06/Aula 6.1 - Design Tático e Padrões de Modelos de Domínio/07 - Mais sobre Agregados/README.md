# Mais sobre Agregados

## Sistema bancario

`ContaBancaria` e a raiz do agregado. Os metodos `depositar()` e `sacar()` sao a unica forma de alterar o saldo. A invariante de que o saldo nunca fica negativo e garantida antes do saque.

## Sistema de bibliotecas

`Biblioteca` e a raiz do agregado. `LivroInterno` e privado, portanto nao pode ser emprestado diretamente: somente `Biblioteca.emprestar()` muda sua disponibilidade. `Isbn` e o Value Object imutavel usado como identificador do livro.

Execute no diretorio `src`: `javac *.java` e `java Main`.
