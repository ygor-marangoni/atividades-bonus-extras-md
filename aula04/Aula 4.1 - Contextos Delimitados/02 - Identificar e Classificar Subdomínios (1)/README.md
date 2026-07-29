# Identificar e Classificar Subdomínios (1): Gigmaster

## Enunciado

Identificar o domínio de negócio da Gigmaster, classificar os subdomínios associados e indicar decisões de design possíveis.

## Meu entendimento do cenário

Eu identifiquei a Gigmaster como uma empresa de venda e distribuição de ingressos. Seu aplicativo procura eventos próximos que possam interessar a cada pessoa, usando informações de preferência e preservando a privacidade de quem utiliza o serviço.

| Subdomínio | Classificação | Justificativa |
|---|---|---|
| Recomendação de eventos | Central | É a parte que transforma preferências em sugestões relevantes e pode diferenciar a empresa. |
| Tratamento anônimo de preferências | Central | A proteção de privacidade está diretamente ligada à confiança necessária para usar a recomendação. |
| Experiência do aplicativo | Central | É o ponto de contato pelo qual a pessoa descobre, escolhe e compra um evento. |
| Catálogo e disponibilidade de eventos | Suporte | É essencial para operar, mas não é necessariamente exclusivo da estratégia. |
| Venda, pagamento e emissão do ingresso | Suporte | Sustenta a transação e precisa ser confiável, embora possa integrar serviços especializados. |
| Autenticação, autorização e criptografia | Genérico | São problemas recorrentes, com técnicas e serviços consolidados. |
| Contabilidade e cobrança | Genérico | São necessários ao negócio, mas não constituem o diferencial da recomendação. |

## Decisões de design que eu consideraria

Eu separaria recomendação, venda de ingressos e identidade em contextos próprios. O contexto de recomendação receberia somente dados minimizados ou anonimizados, sem precisar conhecer detalhes de cobrança. O contexto comercial cuidaria de disponibilidade, reserva e compra. Essa divisão reduz o risco de a lógica de pagamento expor ou depender das preferências musicais de uma pessoa.

Eu também criaria contratos claros para receber dados de serviços de streaming e redes sociais. Assim, uma mudança em um fornecedor externo não obrigaria o algoritmo de recomendação a absorver o formato daquele fornecedor.

## Referência consultada

- Khononov, Vlad. *Learning Domain-Driven Design: Aligning Software Architecture and Business Strategy*. O'Reilly, 2021.
