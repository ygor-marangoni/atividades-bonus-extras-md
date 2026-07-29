# Auditoria final

## Arquivos existentes preservados

Os hashes do inventário inicial foram comparados ao final. Somente `README.md` e `avaliacao.md` mudaram entre os arquivos já versionados, alterações expressamente permitidas. Nenhum arquivo de atividade anterior foi alterado.

- `aula01/exercicio01/exercicio.md`
- `aula01/exercicio02/exercicio.md`
- `aula01/exercicio03/exercicio.md`
- `aula01/exercicio04/`
- `aula01/exercicio06/`
- `aula01/exercicio07/`
- `aula02/exercicio01/exercicio.md`
- `aula04/exercicio 01/exercicio.md`
- `aula06/aula6.2/` (todos os arquivos Java, Markdown e `.class` existentes)

## Atividades novas criadas

| Aula | Atividades | Caminho | Tipo de artefato | Validação |
|---|---|---|---|---|
| 1.2 | Netflix (2) e (3), Uber (1) e (2), Modelos Mentais (1) e (2) | `aula01/atividade-*` | Markdown e Mermaid | links locais verificados; Mermaid revisado como texto |
| 2.1 | Exemplos práticos, Limitações, Domínio Central, Linguagem Ubíqua, Reflexão (1), Aplicando DDD (1) e (2) | `aula02/atividade-*` | Markdown | links locais verificados |
| 4.1 | Diferencial Competitivo; Subdomínios (2) | `aula04/atividade-*` | Markdown | links locais verificados |
| 5.1 | ContextMapper e oito atividades de padrões | `aula05/atividade-*` | Markdown, Mermaid e CML | CML não validado pela ferramenta, que não está instalada |
| 6.1 | Sete atividades de padrões táticos | `aula06/atividade-*` | Markdown e Java | fontes revisadas; compilação bloqueada por ausência de JDK |
| 7.2 | Arquitetura (1) e (2) | `aula07/atividade-*` | Markdown e Mermaid | links locais verificados; Mermaid revisado como texto |

Foram criadas **33 atividades novas**.

## Atividades existentes possivelmente incompletas

- Aula 1.1 — Conceitos básicos (1) e (2): `aula01/exercicio06/exercicio.md` pode abranger uma ou ambas as partes; requer conferência do enunciado.
- Aula 1.2 — Como funciona a Netflix? (1): `aula01/exercicio07/exercicio.md` não referencia o diagrama existente.

## Atividades pendentes por falta de enunciado

- Aula 1.3 — Origens e Evolução (1).
- Aula 1.3 — Origens e Evolução (2).
- Aula 2.1 — Reflexão (2).

Essas atividades não foram criadas nem declaradas concluídas.

## Códigos testados

| Arquivo | Comando tentado | Resultado real |
|---|---|---|
| `aula06/atividade-01-value-object/src/*.java` | `javac -encoding UTF-8 -d %TEMP%/md-build ...` | não executado: `javac` não foi encontrado |
| `aula06/atividade-04-entidade/src/*.java` | `javac -encoding UTF-8 -d %TEMP%/md-build ...` | não executado: `javac` não foi encontrado |
| `aula06/atividade-06-agregado/src/*.java` | `javac -encoding UTF-8 -d %TEMP%/md-build ...` | não executado: `javac` não foi encontrado |

## Diagramas criados

- Mermaid em `aula01/atividade-02-netflix-modelo/`, `aula01/atividade-05-uber-estados/` e `aula07/atividade-01-arquitetura/`; revisados como blocos Mermaid, sem renderizador instalado.
- CML e Mermaid em `aula05/atividade-01-contextmapper/`; a ausência do ContextMapper impediu validação pela ferramenta.

## Documentos centrais

- `README.md`: ampliado, preservando seu conteúdo anterior.
- `RELATORIO.md`: criado como índice comentado.
- `avaliacao.md`: preenchido com todo o inventário.
- `apresentacao/ROTEIRO_VIDEO.md`: criado.
- `PENDENCIAS_MANUAIS.md`: criado e atualizado.

## Alterações evitadas

Confirma-se que nenhum arquivo de atividade antigo foi reescrito, movido ou apagado; nenhum conteúdo do repositório de outro estudante foi copiado; nenhuma data retroativa foi inventada; e nenhuma atividade sem enunciado identificado foi declarada concluída.

