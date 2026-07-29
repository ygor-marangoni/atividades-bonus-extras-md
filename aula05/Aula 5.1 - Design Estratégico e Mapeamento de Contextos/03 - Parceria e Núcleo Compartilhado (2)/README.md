# Parceria e Núcleo Compartilhado (2)

## Identificação

- Aula: 5.1
- Tema: decisão de integração
- Tipo: estudo de caso

## Solução

No Merco, Pedidos e Logística precisam coordenar a data de retirada. As equipes podem atuar em parceria para alinhar a evolução do fluxo. Um pequeno núcleo compartilhado poderia conter somente `JanelaDeRetirada` (início, fim e fuso), pois ambos dependem da mesma definição. O pedido, o roteiro do entregador e as políticas de preço não devem entrar nesse núcleo.

Antes de adotá-lo, as equipes devem definir responsáveis, testes de compatibilidade e procedimento de versão. Se essa coordenação não for viável, um contrato publicado é mais seguro que compartilhar o modelo interno.

