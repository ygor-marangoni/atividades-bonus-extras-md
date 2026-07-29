# C/S, SW e SK (2)

## Identificação

- Aula: 5.1
- Tema: decisão arquitetural entre contextos
- Tipo: estudo de caso

## Solução

No sistema acadêmico, Matrículas depende de uma lista confiável de turmas oferecidas por Oferta Acadêmica. A relação pode ser C/S: a equipe de Oferta publica alterações e considera as necessidades de Matrículas em seu planejamento. Já um módulo de campanhas institucionais pode manter sua própria lista resumida de cursos e seguir Separate Ways, pois não precisa das regras acadêmicas completas.

Um Shared Kernel poderia conter apenas o valor `CódigoDaTurma`, se as duas equipes controlarem sua evolução. Regras de elegibilidade e calendário não devem ser compartilhadas sem necessidade.

