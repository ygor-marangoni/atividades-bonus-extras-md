# Domínio Central: serviço de entrega de comidas

## Enunciado

Considerando o desenvolvimento de um serviço de entrega de comidas, indicar os conceitos que pertencem ao domínio central, justificar a escolha e apontar conceitos importantes que ficam fora dele.

## Minha proposta

Eu considero que o domínio central de um serviço de entrega está na capacidade de transformar a intenção de compra em uma entrega viável. Para mim, os conceitos mais importantes são **pedido**, **itens do pedido**, **restaurante**, **aceite**, **tempo de preparo**, **entregador disponível**, **rota de entrega** e **estado do pedido**.

Eu colocaria esses elementos no centro porque eles definem a experiência que diferencia o serviço: saber se o restaurante consegue atender, prever o prazo, coordenar preparo e coleta e informar o cliente sobre o que está acontecendo. Uma regra como “não atribuir um entregador antes do aceite do restaurante” faz parte diretamente dessa proposta de valor.

Pagamento, autenticação, envio de notificações, armazenamento de imagens e emissão de nota fiscal também são importantes, mas eu os trataria como domínios de suporte ou genéricos. Eles permitem que o serviço opere, porém não explicam por si só a coordenação entre cliente, restaurante e entregador. Essa separação me ajuda a concentrar esforço de modelagem onde as decisões de negócio são mais sensíveis.
