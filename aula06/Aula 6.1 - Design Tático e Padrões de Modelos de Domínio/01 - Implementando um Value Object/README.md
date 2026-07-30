# Implementando um Value Object

Foram criadas duas versoes imutaveis de CPF: `Cpf`, com a estrutura classica de classes Java, e `CpfRecord`, usando `record`.

Ambas removem a pontuacao recebida e exigem exatamente 11 digitos. A classe tradicional implementa `equals` e `hashCode` por valor; no record isso e gerado automaticamente.

Para executar:

```bash
cd src
javac *.java
java Main
```
