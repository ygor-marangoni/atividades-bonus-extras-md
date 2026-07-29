# Implementando um Repositório

## Enunciado

Implementar um repositório para o agregado `ContaBancaria`, com persistência usando Hibernate ou outro mecanismo conhecido e uma operação de busca por contas com saldo negativo.

## Solução adotada

Eu usei um arquivo serializado como mecanismo de persistência. A escolha permite demonstrar o padrão Repository sem adicionar dependências de framework ao exemplo. A classe `ContaBancariaRepositorioArquivo` concentra a leitura e a gravação das contas; o restante do código não precisa conhecer os detalhes do arquivo.

## Estrutura

| Elemento | Responsabilidade |
|---|---|
| `ContaBancaria` | Representa número, titular e saldo da conta. |
| `ContaBancariaRepositorio` | Define as operações de persistência e consulta. |
| `ContaBancariaRepositorioArquivo` | Salva e recupera contas do arquivo `contas-bancarias.dat`. |
| `buscarComSaldoNegativo()` | Retorna apenas as contas cujo saldo é menor que zero. |

## Código

[Abrir implementação Java](src/Main.java)

## Resultado esperado

```text
002 - Caio - R$ -75.50
```

O exemplo registra duas contas e mostra somente a que está com saldo negativo.
