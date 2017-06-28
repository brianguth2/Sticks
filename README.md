# Sticks
Basic terminal game between two players.

Sticks is a game for two player hand game where each player starts with one finger. On a players turn, they can choose
which hand they want to do an action on and then do a corresponding action or split the value. If a person's hand reaches
the value of 5, it is reset to 0. If the value goes over 5, it becomes the remainder (6 goes to 1, 7 goes to 2, etc.)
If a player's hands both reach 0 then they lose.

To play just run:

javac *.java

java Sticks
