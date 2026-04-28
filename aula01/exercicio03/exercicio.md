# EXEMPLO: MODELOS COMPUTACIONAIS

## 1. A partir do exemplo do código do MergeSort, tente escrever seu entendimento sobre o funcionamento geral do algoritmo:

A partir do código, entendi que o **MergeSort** é um algoritmo de ordenação que trabalha dividindo o vetor em partes menores para depois reorganizá-las em ordem.

Primeiro, o algoritmo verifica se o vetor ainda pode ser dividido. Caso possa, ele separa o vetor em duas partes, geralmente uma metade esquerda e uma metade direita. Esse processo continua acontecendo várias vezes, até chegar em partes bem pequenas, com apenas um elemento.

Depois dessa divisão, o algoritmo começa a juntar novamente essas partes. Nesse momento, ele compara os valores de cada lado e vai colocando os menores elementos primeiro, formando um vetor ordenado.

Então, meu entendimento é que o **MergeSort** não ordena tudo de uma vez. Ele primeiro divide o problema em partes menores e depois resolve cada parte, juntando tudo no final de forma organizada.

---

## 2. Refletir:

### Foi fácil entender o algoritmo a partir do código?

Não foi totalmente fácil entender apenas olhando para o código. Como o **MergeSort** usa recursão, algumas partes ficam mais difíceis de acompanhar, principalmente porque a função chama ela mesma várias vezes.

Ao olhar só para o código, nem sempre fica claro em qual momento o vetor está sendo dividido e em qual momento ele está sendo juntado novamente. Por isso, pode ser confuso entender o fluxo completo apenas lendo as instruções.

### Usou conhecimento anterior sobre o algoritmo?

Sim. Usei conhecimentos anteriores que tive nas aulas de **Estruturas de Dados I**, principalmente sobre vetores, ordenação e recursão.

Esses conteúdos ajudaram a entender melhor o que estava acontecendo no código, porque eu já tinha uma noção de como um vetor pode ser percorrido, dividido e reorganizado. Também ajudou saber que a recursão funciona como várias chamadas da mesma função, até chegar em uma condição de parada.

### Há formas melhores de entender o algoritmo? Quais?

Sim. Uma forma melhor de entender o **MergeSort** seria por meio de **modelagem**, representando o funcionamento do algoritmo antes de analisar apenas o código.

Por exemplo, um diagrama mostrando o vetor sendo dividido em partes menores e depois sendo unido novamente em ordem ajudaria bastante. Também seria útil fazer um teste de mesa com poucos números, acompanhando passo a passo cada divisão e cada comparação.

Além disso, animações ou representações visuais poderiam facilitar a compreensão, porque mostram o comportamento do algoritmo de forma mais concreta. Assim, a modelagem ajuda a transformar o código em uma representação mais clara do processo, facilitando o entendimento do funcionamento geral do **MergeSort**.