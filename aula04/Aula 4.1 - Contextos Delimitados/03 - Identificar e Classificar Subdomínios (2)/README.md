# Identificar e Classificar Subdomínios (2): BusVNext

## Enunciado

Identificar o domínio de negócio da BusVNext, classificar os subdomínios associados e indicar decisões de design possíveis.

## Meu entendimento do cenário

Eu entendi a BusVNext como uma empresa de transporte público que procura oferecer viagens de ônibus com uma experiência próxima à conveniência de pedir um táxi. A pessoa pode solicitar uma viagem pelo aplicativo; um ônibus próximo ajusta sua rota para buscá-la em um horário combinado. O cenário também informa que a empresa aperfeiçoa continuamente o roteamento, considera dados de trânsito em tempo real e aplica descontos para equilibrar demanda.

| Subdomínio | Classificação | Justificativa |
|---|---|---|
| Otimização de roteamento | Central | É o desafio mais específico: equilibrar trajetos, horário de partida, busca de passageiros e atrasos. |
| Decisão de alocação de ônibus | Central | Define qual veículo pode atender uma solicitação sem comprometer o serviço em andamento. |
| Política de preço e descontos | Suporte | Ajuda a equilibrar demanda e ocupação, mas depende da estratégia de roteamento. |
| Solicitação de viagem pelo aplicativo | Suporte | É necessária para iniciar o atendimento, mas não resolve sozinha o problema de mobilidade. |
| Integração com trânsito e alertas | Suporte | Fornece informações importantes para a rota, porém vem de provedores externos. |
| Autenticação, pagamento e notificações | Genérico | São capacidades comuns, que podem ser tratadas com soluções consolidadas e integrações bem definidas. |

## Decisões de design que eu consideraria

Eu manteria o mecanismo de roteamento isolado das integrações de trânsito. O roteador receberia uma representação estável de condição de via e alerta, em vez de conhecer o formato específico de cada provedor. Isso permitiria trocar ou adicionar fontes de dados sem reescrever a lógica principal.

Também separaria o contexto de operação da frota do contexto comercial. A operação decidiria se uma solicitação cabe na rota e qual impacto ela produz; o comercial decidiria sobre descontos e campanhas. Eles podem se comunicar, mas eu não deixaria uma promoção alterar diretamente a rota de um ônibus.

## Referência consultada

- Khononov, Vlad. *Learning Domain-Driven Design: Aligning Software Architecture and Business Strategy*. O'Reilly, 2021.
