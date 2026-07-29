# Ygor Marangoni Sgarioni

*Modelagem de Domínio*

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/ygor-marangoni/atividades-bonus-extras-md)

Este é um repositório individual de atividades bônus da disciplina. Informações pessoais não confirmadas, como e-mail, não foram incluídas.

# Atividades bônus extras: Modelagem de Domínio.

Repositorio para organizar as atividades bonus extras da disciplina de Modelagem de Dominio.

## Organizacao

As atividades serao registradas por aula, seguindo uma estrutura semelhante ao repositorio usado no periodo anterior:

- `aula01`
- `aula02`
- `aula04`
- `aula05`
- `aula06`
- `aula07`

As informações de autoavaliação estão neste próprio README.

## Identificação do projeto

- Estudante: Ygor Marangoni Sgarioni
- Disciplina: Modelagem de Domínio
- Objetivo: registrar atividades bônus individuais, seus artefatos e a evolução do estudo de Modelagem de Domínio.

## Organização e índice

Os registros anteriores foram mantidos em seus caminhos originais. As atividades criadas posteriormente usam diretórios identificados por aula e atividade; os documentos centrais organizam a navegação sem mover ou reescrever os materiais já registrados.

| Aula | Situação resumida | Índice |
|---|---|---|
| Aula 1 | Registros existentes, novos modelos mentais e pendências de enunciado | [aula01](aula01/) |
| Aula 2 | Analogia existente e atividades de DDD complementares | [aula02](aula02/) |
| Aula 4 | Subdomínios e diferencial competitivo | [aula04](aula04/) |
| Aula 5 | Context mapping e padrões de integração | [aula05](aula05/) |
| Aula 6 | Aula 6.1 e registros existentes da Aula 6.2 | [aula06](aula06/) |
| Aula 7 | Arquitetura e modelo de domínio | [aula07](aula07/) |

As aulas estão organizadas diretamente nas pastas listadas acima.

## Executando exemplos Java

Os exemplos novos de Java não usam Maven ou Gradle. A partir de uma pasta de atividade, compile os arquivos de `src/` para um diretório temporário e execute `Main`:

```powershell
javac -d $env:TEMP\md-build .\src\*.java
java -cp $env:TEMP\md-build Main
```

Os registros são individuais e devem ser revisados pelo estudante antes da entrega final.

## Autoavaliação das atividades

| Aula | Atividade | Autoavaliação | Situação |
|---|---|---:|---|
| 1.1 | Conceito de modelos; Exemplos de modelos gerais; Representando modelos computacionais; Por que modelar? | 3 | Registradas |
| 1.1 | Conceitos básicos (1) e (2) | 3 | Um registro existente requer confirmação de vínculo |
| 1.2 | Netflix (1), (2), (3); Uber (1), (2); Modelos Mentais (1), (2) | 3 | Registros organizados |
| 1.3 | Origens e Evolução (1) e (2) | 3 | Enunciados pendentes; não declaradas concluídas |
| 2.1 | Analogia; Exemplos práticos; Limitações; Domínio Central; Linguagem Ubíqua | 4 | Registros organizados |
| 2.1 | Reflexão (1), Aplicando DDD (1) e (2) | 4 | Registros organizados |
| 2.1 | Reflexão (2) | 4 | Enunciado pendente; não declarada concluída |
| 4.1 | Diferencial Competitivo; Subdomínios (1) e (2) | 5 | Registros organizados |
| 5.1 | ContextMapper; Parceria/SK; CF/ACL; ACL/OHS/PL; C/S/SW/SK | 5 | Nove atividades organizadas |
| 6.1 | Value Object; Objetos de Valor; Entidade; Agregado | 5 | Sete atividades organizadas, com fontes Java nas implementações |
| 6.2 | Serviço; Evento; Fábrica; Repositório e aprofundamentos | 5 | Oito atividades organizadas, com fontes Java |
| 7.2 | Arquitetura (1) e (2) | 5 | Registros organizados |

Os critérios usados são: nota 5 para 100% das atividades da aula registradas; 4 para 80% ou mais; 3 para 50% ou mais; 2 para 30% ou mais; 1 para 10% ou mais; e 0 abaixo disso. Atividades cujo enunciado não foi identificado não são consideradas concluídas.

## Pendências

- Aula 1.3 — Origens e Evolução (1) e (2): enunciados necessários.
- Aula 2.1 — Reflexão (2): enunciado necessário.
- A compilação dos exemplos Java depende de um ambiente com JDK (`javac`).
