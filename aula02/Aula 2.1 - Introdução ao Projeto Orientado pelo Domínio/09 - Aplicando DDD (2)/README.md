# Aplicando DDD (2): contextos e termos compartilhados

## Enunciado

Identificar elementos do domínio central ligados aos domínios do entorno, termos comuns com significados distintos e repetir o exercício para um sistema de entregas de comida.

## Transporte de passageiros

No transporte, eu ligaria a corrida aos domínios de localização, pagamento, suporte e avaliação. O despacho depende da posição informada pela localização; a finalização da corrida gera a cobrança; suporte e avaliação precisam saber o que ocorreu, mas não deveriam alterar a escolha do motorista.

Eu tomaria cuidado com o termo **viagem**. Para o passageiro, ele pode significar a solicitação de deslocamento; para o motorista, uma oportunidade de atendimento; para o financeiro, uma referência de cobrança. Como os significados não são idênticos, eu registraria o termo de acordo com o contexto em vez de tentar usar uma definição universal.

## Entregas de comida

Ao repetir o exercício para entregas, eu colocaria **pedido**, **preparo**, **coleta** e **entrega** no domínio central. Restaurante, entregador, cliente, pagamento e avaliação seriam contextos relacionados.

Também encontrei uma ambiguidade no termo **pedido**: para o restaurante, é trabalho a ser preparado; para o pagamento, é uma cobrança; para o cliente, é a compra que ele acompanha. Reconhecer essas diferenças me parece mais útil do que forçar todos a usar o mesmo objeto. O contexto define quais dados e regras realmente importam em cada situação.
