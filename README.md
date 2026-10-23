Técnica utilizada:

Nosso projeto utiliza a técnica de Backtracking, que basicamente consiste em testar possibilidades e volta atrás em escolhas que impedem encontrar uma solução válida.
O algoritmo tenta distribuir as aulas nos horários e nas salas disponíveis. Quando percebe que não consegue continuar, volta atrás e tenta outra combinação. Esse processo se repete até encontrar uma grade válida ou concluir que não há solução.

Restrições implementadas:
O programa vai verificar as seguintes restrições:

- Cada disciplina deve ter exatamente duas aulas em horários diferentes.
- Um professor não pode ministrar duas aulas no mesmo horário.
- Uma sala não pode receber duas aulas no mesmo horário.
- Redes e Programação Web devem ser alocadas exclusivamente em laboratórios.
- Os horários disponíveis de cada professor devem ser respeitados.
- Os bloqueios de disponibilidade das salas devem ser respeitados.

Quando encontra uma solução válida, o programa apresenta a grade de horários. Caso contrário, informa que não foi possível distribuir as aulas respeitando todas as regras.