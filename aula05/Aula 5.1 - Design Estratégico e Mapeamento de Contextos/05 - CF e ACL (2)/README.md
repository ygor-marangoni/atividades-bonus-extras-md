# CF e ACL (2)

## Identificação

- Aula: 5.1
- Tema: escolha de padrão
- Tipo: cenário

## Solução

O catálogo de máquinas consome um serviço regulatório que publica uma classificação oficial obrigatória. Como essa classificação é a fonte normativa, aceitar o código oficial em conformidade pode ser razoável. Já ao importar dados de um sistema antigo que chama todo equipamento de “item”, a aplicação de manutenção usaria uma ACL para traduzir campos e evitar que esse vocabulário genérico contamine conceitos como Máquina, Componente e PlanoDeManutenção.

## Resultado

A escolha não é sobre “melhor padrão”, mas sobre autonomia, qualidade do modelo externo e custo de manter a tradução.

