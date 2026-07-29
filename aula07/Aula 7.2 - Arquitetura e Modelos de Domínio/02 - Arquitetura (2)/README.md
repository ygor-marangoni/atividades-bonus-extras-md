# Arquitetura (2)

## Identificação

- Aula: 7.2
- Tema: análise de organização de projeto
- Tipo: proposta de melhoria

## Solução

Em um projeto organizado apenas por tecnologia — `controllers`, `services`, `repositories` — é comum que as regras de uma funcionalidade fiquem espalhadas. Para o Pizza Express, uma melhoria é organizar primeiro por capacidade de negócio: `pedido`, `cardapio` e `entrega`. Dentro de `pedido`, os casos de uso, entidades e adaptadores podem ficar próximos.

Isso não elimina camadas; apenas torna mais visível onde uma mudança deve ocorrer. Uma alteração na regra de cancelamento passa a ser encontrada no módulo de pedido, em vez de exigir busca por várias pastas técnicas.

## Resultado

A arquitetura passa a apoiar a linguagem do domínio e reduz o acoplamento acidental entre funcionalidades sem relação.

