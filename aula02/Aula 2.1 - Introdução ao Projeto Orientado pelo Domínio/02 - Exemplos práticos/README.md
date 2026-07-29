# Exemplos práticos

## Identificação

- Aula: 2.1
- Tema: Projeto Orientado pelo Domínio
- Tipo: análise

## Objetivo

Reconhecer situações em que regras do negócio merecem aparecer explicitamente no modelo.

## Solução

No Pizza Express, um pedido não pode ser tratado somente como uma lista de itens. Há regras como tamanho permitido de sabores, limite de área de entrega, horário de funcionamento, cupom aplicável e cancelamento antes do início do preparo. Um CRUD de pedidos consegue guardar dados, mas não expressa com clareza essas decisões.

No Aprender+, uma inscrição depende de vaga, pré-requisito, período de matrícula e situação acadêmica. Em ambos os casos, o domínio orienta os nomes e as operações: `confirmarPedido`, `iniciarPreparo`, `matricular` e `validarPreRequisito` comunicam intenção melhor do que comandos genéricos de atualizar registros.

## Reflexão pessoal

Os exemplos reforçaram que DDD não é uma camada extra obrigatória; ele faz mais sentido quando as regras são relevantes e mudam o comportamento do sistema.

