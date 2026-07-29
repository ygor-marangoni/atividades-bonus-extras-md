# Implementando uma Entidade

## Identificação

- Aula: 6.1
- Tema: Entidade
- Linguagem: Java

## Ideia do exemplo

Usei um chamado de manutenção como entidade. Mesmo que o estado do chamado seja alterado, ele continua sendo o mesmo chamado porque mantém seu código de identificação.

## Estrutura

| Arquivo | Responsabilidade |
|---|---|
| `Chamado.java` | Representa o chamado, seu código, descrição e status. |
| `Main.java` | Cria um chamado, conclui o atendimento e imprime o estado final. |

## O que o código demonstra

- Identidade: o código `CH-001` distingue o chamado;
- Estado: o chamado começa como `ABERTO`;
- Comportamento: `concluir()` realiza a mudança de estado;
- Encapsulamento: o status não é modificado diretamente fora da entidade.

## Resultado esperado

```text
CH-001 - CONCLUIDO
```

O exemplo mostra que a identidade permanece a mesma antes e depois da mudança de estado.
