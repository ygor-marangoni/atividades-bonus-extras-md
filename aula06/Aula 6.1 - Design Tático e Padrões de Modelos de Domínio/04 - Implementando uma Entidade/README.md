# Implementando uma Entidade

`Livro` e uma entidade identificada pelo ISBN-13. O construtor remove hifens e espacos, verifica os 13 digitos e valida o digito verificador. A identidade permanece a mesma mesmo se o titulo for alterado.

O metodo `citacaoAbnt()` gera a referencia no formato `SOBRENOME, Nome. Titulo. Editora, ano.`.

Execute no diretorio `src`: `javac *.java` e `java Main`.
