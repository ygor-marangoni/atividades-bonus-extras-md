# Modelos Mentais (1)

## Identificação

- Aula: 1.2
- Tema: divergência de entendimento
- Tipo: estudo de caso

## Enunciado

Identificar modelos mentais distintos em uma situação cotidiana de software.

## Solução

No sistema acadêmico, uma estudante entende “matrícula confirmada” como a possibilidade de frequentar a turma. A secretaria pode entender o mesmo termo como a aprovação documental; a tesouraria, como a compensação financeira; e a coordenação, como a existência de vaga e pré-requisitos atendidos. Se o sistema tiver apenas um campo booleano chamado `matriculaConfirmada`, ele esconderá etapas importantes.

Uma alternativa é nomear os fatos separadamente: documentação validada, pagamento conciliado, vaga reservada e matrícula efetivada. Assim, cada área reconhece o seu critério e a equipe pode definir a regra que permite frequentar a disciplina.

## Reflexão pessoal

O caso mostra que uma palavra aparentemente objetiva pode concentrar várias decisões. A maior lição foi perguntar “confirmada para quem e sob qual regra?”.

