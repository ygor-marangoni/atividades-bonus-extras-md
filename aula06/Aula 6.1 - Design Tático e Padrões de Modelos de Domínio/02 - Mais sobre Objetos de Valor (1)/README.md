# Mais sobre Objetos de Valor (1)

Esta atividade possui tres Value Objects:

- `CoordenadaGps`: valida latitude de -90 a 90 e longitude de 0 a 180, conforme o enunciado, e calcula a distancia com Haversine;
- `Senha`: aceita no minimo oito caracteres e guarda somente o hash SHA-256;
- `Email`: exige `usuario@dominio` e permite somente letras, numeros, ponto e sublinhado.

Execute os fontes pelo diretorio `src` com `javac *.java` e `java Main`.
