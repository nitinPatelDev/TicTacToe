# TicTacToe

Introduction to Tic Tac Toe digital version building tutorials
Game rules: draw lines, take turns, mark X or O, win with a row, column, or diagonal
Objective: create a digital version of the game with same logic
Requirements:
Visible board with markable boxes
Display area with title and player scores
Ability to determine winner after marking boxes
Requirements will be bifurcated into two parts:
Visible board and display area
Game logic to mark boxes and determine winner

Tic Tac Toe Building UI

 Building a user interface (UI) for a Tic Tac Toe game using JavaFX.
The speaker suggests viewers create a new project and name it Tic Tac Toe.
The UI will use a BorderPane layout to position components in top, left, center, right, and bottom areas.
The requirements for the UI include a board with clickable boxes, a display area with a title and scoreboard, and a design similar to an image provided by the speaker.
The speaker explains why a BorderPane layout is chosen over a simple pane.
The speaker suggests viewers try different pane layouts to understand their functionality.
The speaker demonstrates how to refactor the code and rename the project to Tic Tac Toe.

Tic Tac Toe Board Click Logic
The UI is discussed in detail, including the header, scoreboard, and grid of buttons.
The text on the buttons is modified to be larger.
Gaps are added to the grid pane to improve the appearance.
The requirements for the project are listed, including knowing the winner, updating the score, and resetting the board.
A function is created for handling button clicks, which takes the clicked button as a parameter.
Logic is written to alternate between placing X's and O's on the buttons based on whose turn it is.

Tic Tac Toe Logical Completion
The basic game has been completed, and it's time to work on the appearance of the game.
The winner condition has been created, but the column and diagonal conditions still need to be worked on.
If someone wins, the scoreboard needs to be updated, and the board needs to be reset.
A method called "update score" is created to update the score of the winner.
Two private variables are created to store the score counters of each player.
The "reset board" method is created to set the text of the buttons to nothing, so the game can start again.
A for loop is written to set the button text to nothing.

