# Reflexão (2): evitando uma grande bola de lama

## Enunciado

Observar o modelo do estudo de caso, avaliar se ele caminha para uma “Grande Bola de Lama” e indicar como lidar com a situação.

## Minha reflexão

Ao observar um diagrama com muitos conceitos ligados diretamente entre si, eu entendo o risco de uma **Grande Bola de Lama**: não fica claro onde uma responsabilidade termina e a outra começa. Um termo como calendário, tarefa ou item de backlog pode começar simples, mas passa a concentrar regras de equipe, produto, planejamento, permissões e notificações.

Eu não concluiria que um diagrama grande está automaticamente errado. Porém, eu investigaria quais relações são indispensáveis e quais surgiram apenas porque foi mais rápido conectar tudo no mesmo modelo. Se uma alteração no calendário pode quebrar a regra de um produto ou se uma permissão conhece detalhes de uma sprint, eu consideraria isso um sinal de acoplamento excessivo.

Para lidar com o problema, eu começaria pelo vocabulário e pelos fluxos mais importantes. Depois, separaria as responsabilidades em contextos menores, com contratos claros entre eles. Também evitaria compartilhar entidades apenas por conveniência; cada contexto pode manter a representação necessária para sua própria regra. Assim, eu reduziria o impacto de mudanças sem perder a visão do todo.
