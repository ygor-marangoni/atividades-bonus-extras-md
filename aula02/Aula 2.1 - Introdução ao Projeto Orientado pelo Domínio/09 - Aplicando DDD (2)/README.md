# Aplicando DDD (2)

## Identificação

- Aula: 2.1
- Tema: colaboração e descoberta do domínio
- Tipo: cenário de eventos

## Solução

Para o Tower Defender, uma conversa baseada em eventos pode começar assim:

```text
Partida criada → mapa escolhido → onda iniciada → inimigo eliminado
→ recurso concedido → torre melhorada → última onda concluída → vitória registrada
```

Dois pontos exigem confirmação com a pessoa responsável pelo jogo: se o recurso é concedido imediatamente após cada eliminação ou ao final da onda; e se a vitória ocorre quando a última onda termina ou após uma condição adicional. Essas dúvidas viram regras explícitas antes da implementação.

## Reflexão pessoal

Listar eventos em ordem ajudou a perceber lacunas que uma lista de classes esconderia. Eu usaria essa dinâmica para alinhar regra, interface e testes.

