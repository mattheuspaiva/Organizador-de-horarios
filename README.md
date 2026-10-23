Técnica utilizada:

Nosso projeto utiliza a técnica de Backtracking, que consiste em testar diferentes possibilidades e voltar atrás nas escolhas que impedem encontrar uma solução válida.

O algoritmo tenta distribuir as aulas nos horários e nas salas disponíveis. Quando percebe que não pode continuar com uma determinada combinação, volta atrás e tenta outra. Esse processo se repete até encontrar uma grade válida ou concluir que não existe solução.

Restrições implementadas, programa verifica as seguintes restrições:

-Cada disciplina deve ter exatamente duas aulas em horários diferentes.
-Um professor não pode ministrar duas aulas no mesmo horário.
-Uma sala não pode receber duas aulas no mesmo horário.
-Redes e Programação Web devem ser alocadas exclusivamente em laboratórios.
-Os horários disponíveis de cada professor devem ser respeitados.
-Os bloqueios de disponibilidade das salas devem ser respeitados.

Quando encontra uma solução válida, o programa apresenta a grade de horários. Caso contrário, informa que não foi possível distribuir as aulas respeitando todas as regras.

Pseudocódigo:

<pre>
Início
    Criar as listas de disciplinas, professores, salas e horários.

    Iniciar a busca por uma grade válida.

    Função buscar(índice):
        Se todas as aulas foram alocadas:
            Retornar verdadeiro.

        Selecionar a próxima aula.

        Para cada horário:
            Para cada sala:
                Se a alocação respeitar todas as restrições:
                    Alocar a aula.

                    Se a busca pela próxima aula encontrar uma solução:
                        Retornar verdadeiro.

                    Caso contrário:
                        Desfazer a alocação.
                        Registrar um retrocesso.

        Retornar falso.

    Se a busca retornar verdadeiro:
        Exibir a grade de horários.
    Caso contrário:
        Exibir uma mensagem informando que não existe solução.

    Exibir os indicadores de busca e retrocesso.
Fim
</pre>

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Inocencio-Ferraz">
        <img src="https://github.com/Inocencio-Ferraz.png" width="100px;" alt="Inocencio-Ferraz"/><br />
        <b>Inocencio-Ferraz</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/clebio0901">
        <img src="https://github.com/clebio0901.png" width="100px;" alt="Clebio-Luis"/><br />
        <b>Clebio-Luis</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/RaineCarla">
        <img src="https://github.com/RaineCarla.png" width="100px;" alt="RaineCarla"/><br />
        <b>RaineCarla</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/mattheuspaiva">
        <img src="https://github.com/mattheuspaiva.png" width="100px;" alt="mattheuspaiva"/><br />
        <b>mattheuspaiva</b>
      </a>
    </td>
  </tr>
</table>
