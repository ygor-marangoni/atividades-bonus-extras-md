# Aplicando DDD (1): transporte de passageiros

## Enunciado

Definir os elementos pertinentes ao domínio central de um serviço de transporte de passageiros com veículos de passeio e apontar os domínios relacionados.

## Minha proposta

Eu definiria o domínio central como o **despacho da corrida**. Ele começa quando o passageiro solicita o deslocamento e envolve estimar preço e tempo, encontrar um motorista compatível, acompanhar o início e o encerramento da viagem e registrar as situações que podem alterar esse fluxo.

Os elementos que eu colocaria nesse núcleo são solicitação, origem, destino, motorista elegível, aceite, corrida, trajeto estimado, status e cancelamento. Eles representam a decisão principal do serviço: transformar a necessidade de deslocamento em uma corrida possível e acompanhável.

Os domínios relacionados seriam cadastro de passageiros e motoristas, localização, pagamentos, promoções, avaliação, suporte e prevenção a fraude. Eu os manteria próximos ao núcleo, mas com responsabilidades próprias. A localização fornece dados para o despacho; o pagamento recebe o resultado da corrida; o suporte precisa consultar fatos do atendimento sem assumir as regras de alocação.
