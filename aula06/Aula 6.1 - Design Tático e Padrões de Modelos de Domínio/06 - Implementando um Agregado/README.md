# Implementando um Agregado

## Identificação

- Aula: 6.1
- Tipo: Java

## Solução

`Pedido` é a raiz do agregado. A coleção de itens é privada e só pode ser modificada por `adicionarItem`, que protege o invariante de preço e quantidade válidos. Código externo não manipula o item diretamente.

## Resultado

O exemplo calcula `Total: R$ 96.00`.

