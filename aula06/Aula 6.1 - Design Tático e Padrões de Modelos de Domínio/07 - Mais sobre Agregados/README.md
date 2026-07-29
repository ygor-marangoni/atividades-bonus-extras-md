# Mais sobre Agregados

## Identificação

- Aula: 6.1
- Tema: fronteiras de consistência

## Solução

Em uma reserva de hospedagem, Reserva pode ser a raiz de um agregado que inclui período, hóspede e status. A regra “não confirmar sem pagamento aprovado” é verificada pela raiz. Já o calendário de uma hospedagem não deve carregar todas as reservas como objetos internos em memória; ele pode consultar identificadores ou usar uma política/serviço para detectar conflito.

Agregados pequenos favorecem transações mais claras. A fronteira deve refletir invariantes que precisam permanecer consistentes imediatamente, não apenas relações existentes no banco.

