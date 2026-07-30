# Mais sobre Entidades

## ReservaHotel

`ReservaHotel` recebe um `UUID` como identidade. A regra de dominio fica na propria entidade: depois de `realizarCheckIn()`, `cancelar()` lancara excecao.

## ISBN, ISSN e DOI

- **ISBN** identifica uma edicao de livro. Em uma entidade `Livro`, ele pode ser a identidade natural, validada na criacao.
- **ISSN** identifica uma publicacao seriada, como revista ou jornal. Uma entidade `Periodico` pode usar ISSN para reunir suas edicoes.
- **DOI** identifica persistentemente um objeto digital, como artigo, tese ou conjunto de dados. Uma entidade `ArtigoCientifico` pode usar DOI para impedir duplicidade e direcionar para a fonte digital.

Os tres codigos funcionam bem como Value Objects: sao imutaveis, validaveis e comparados por valor. Eles tambem podem ser identidades naturais das respectivas entidades quando o dominio assim determinar.
