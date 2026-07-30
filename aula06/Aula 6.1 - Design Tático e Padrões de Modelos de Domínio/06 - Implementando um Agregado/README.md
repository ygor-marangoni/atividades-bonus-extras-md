# Implementando um Agregado

`Reserva` e a raiz do agregado de reserva de passagens. Ela coordena `Passageiro` e `Voo` e concentra a operacao `confirmar()`.

A invariante e aplicada antes da mudanca de estado: uma reserva so e confirmada se `Voo.estaLotado()` for falso. Ao confirmar, o agregado ocupa um assento e marca a reserva como confirmada.

Execute no diretorio `src`: `javac *.java` e `java Main`.
