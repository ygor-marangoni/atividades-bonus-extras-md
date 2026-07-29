# Por que modelar?

## Modelos escolhidos

Escolhi o diagrama entidade-relacionamento, o wireframe e o diagrama de estados de uma entrega. Cada um mostra uma parte diferente de um sistema: os dados, a interação com a pessoa usuária e as mudanças de situação ao longo do processo.

## Relação com os propósitos da modelagem

O diagrama entidade-relacionamento ajuda principalmente na análise e no projeto, pois deixa visível quais informações precisam existir e como se relacionam. Também facilita a documentação quando a equipe precisa revisar uma decisão sobre dados.

O wireframe contribui para entendimento e comunicação. Antes de programar uma tela, é possível discutir a ordem das informações, os caminhos de navegação e o que a pessoa precisa fazer. Ele não resolve regras do negócio, mas evita que a interface seja tratada como um detalhe tardio.

O diagrama de estados é útil para análise e comunicação de regras. Em uma entrega, por exemplo, um pedido pode estar aguardando confirmação, em preparo, a caminho ou concluído. Representar essas mudanças ajuda a evitar situações incoerentes, como marcar uma entrega como concluída antes de ela sair do restaurante.

## Representações complementares

Um DER não mostra com clareza a sequência de ações; para isso, eu acrescentaria um diagrama de sequência ou um fluxograma. Um wireframe não explica validações e regras; nesse caso, histórias de usuário e critérios de aceite ajudam. Já o diagrama de estados não revela a estrutura de dados; ele pode ser complementado pelo DER.

## Conclusão

Modelar não é apenas produzir diagramas. É escolher uma representação adequada para compreender um problema, conversar sobre ele e registrar decisões antes que elas virem código difícil de alterar.
