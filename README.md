# Sudoku Game - Java Swing

Este projeto é uma implementação do clássico jogo **Sudoku** desenvolvida em Java, utilizando a biblioteca **Swing** para a interface gráfica. O sistema conta com geração dinâmica de tabuleiros, diferentes níveis de dificuldade e uma lógica de validação em tempo real.

---

## Funcionalidades

* **Geração Aleatória**: Cada partida é única, graças a um algoritmo que preenche o tabuleiro respeitando as regras do Sudoku e depois remove números para criar o desafio.
* **Níveis de Dificuldade**: O jogador pode escolher entre os modos:
    * **Fácil**: 20 espaços vazios.
    * **Médio**: 40 espaços vazios.
    * **Difícil**: 60 espaços vazios.
* **Validação de Jogadas**: O sistema verifica se o número inserido está correto de acordo com a solução gerada.
* **Contador de Erros**: Exibe na tela a quantidade de tentativas incorretas durante a partida.
* **Interface Responsiva**: O design utiliza `GridLayout` e `BorderLayout` para manter a organização visual.

---

## Estrutura do Projeto

O código está organizado seguindo princípios de Programação Orientada a Objetos (POO):

1.  **`Main.java`**: O ponto de entrada da aplicação que inicia a `TelaInicial`.
2.  **`TelaInicial.java`**: Gerencia o menu principal e a seleção de dificuldade.
3.  **`Sudoku.java`**: Controla a interface do tabuleiro, a interação com as células e a lógica de vitória.
4.  **`SudokuGenerator.java`**: Motor lógico que utiliza **Backtracking** para gerar tabuleiros válidos e remover dígitos.

---

## Tecnologias Utilizadas

* **Linguagem**: Java
* **Interface Gráfica**: Java Swing (JFrame, JPanel, JButton, JLabel)
* **Lógica**: Algoritmos de recursividade e manipulação de matrizes bidimensionais.

---

## Como Jogar

1.  Certifique-se de ter o **JDK** instalado em sua máquina.
2.  Compile e execute a classe `Main.java`.
3.  No menu inicial, selecione a dificuldade.
4.  **Para preencher uma célula**:
    * Clique em um dos números no painel inferior (1 a 9).
