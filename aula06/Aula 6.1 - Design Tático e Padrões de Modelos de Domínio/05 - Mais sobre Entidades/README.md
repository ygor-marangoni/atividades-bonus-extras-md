# Mais sobre Entidades

## Identificação

- Aula: 6.1
- Tema: identidade e ciclo de vida

## Solução

Uma máquina do catálogo possui número de série e histórico de manutenção. Duas máquinas do mesmo modelo e ano continuam sendo entidades diferentes porque podem ter garantia, localização e manutenção distintas. Igualdade, nesse caso, deve usar a identidade do equipamento, não a lista inteira de atributos.

Uma entidade deve proteger suas próprias transições relevantes. Por exemplo, não deve ser possível marcar uma manutenção como concluída sem registrar data e responsável definidos pelas regras do domínio.

