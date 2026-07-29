# Aplicando DDD (1)

## Identificação

- Aula: 2.1
- Tema: aplicação inicial do DDD
- Tipo: modelagem de domínio

## Solução

No sistema Tower Defender, o núcleo do domínio é a execução de uma partida: posicionar torres, consumir recursos, iniciar ondas e avaliar derrota ou vitória. Um primeiro vocabulário é:

- **Partida:** sessão com mapa, recursos e estado.
- **Onda:** conjunto ordenado de inimigos a ser liberado.
- **Torre:** defesa posicionada que possui alcance e efeito.
- **Recurso:** saldo gasto em construções e melhorias.

Regra central: uma torre só pode ser posicionada em local permitido e se a partida tiver recursos suficientes. Essa regra pertence à partida, e não à interface gráfica.

## Resultado

O recorte concentra as regras de jogo antes de decidir motor gráfico, persistência ou formato das telas.

