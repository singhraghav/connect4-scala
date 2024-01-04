# Connect4 Game in Scala

This project is a console-based implementation of the classic game Connect4, written in Scala. The game is played on a vertical grid of 6x7, and the goal is to be the first to connect four of your colored discs in a row, column, or diagonal.

## How to Play

Once you start the Game the console will have menu loaded up

```text
  ______   ______   .__   __. .__   __.  _______   ______ .___________.    _  _
 /      | /  __  \  |  \ |  | |  \ |  | |   ____| /      ||           |   | || |
|  ,----'|  |  |  | |   \|  | |   \|  | |  |__   |  ,----'`---|  |----`   | || |_
|  |     |  |  |  | |  . `  | |  . `  | |   __|  |  |         |  |        |__   _|
|  `----.|  `--'  | |  |\   | |  |\   | |  |____ |  `----.    |  |           | |
 \______| \______/  |__| \__| |__| \__| |_______| \______|    |__|           |_|

* New Game
* Quit

new game
```

### Starting a new Game

Selecting new game will move you to initializing screen where you can add player details and start the game

```text
   _   _   _   _   _   _   _   _   _   _   _   _
  / \ / \ / \ / \ / \ / \ / \ / \ / \ / \ / \ / \
 | I | n | i | t | i | a | l | i | z | i | n | g |
 |___|___|___|___|___|___|___|___|___|___|___|___|


* Add Player
* Quit

add player

   _   _   _   _   _   _   _   _   _   _   _   _
  / \ / \ / \ / \ / \ / \ / \ / \ / \ / \ / \ / \
 | I | n | i | t | i | a | l | i | z | i | n | g |
 |___|___|___|___|___|___|___|___|___|___|___|___|


* Enter Player 1 Name and One Character Code For Board Piece Color separated by ',': e.g - Raghav,R


Raghav,R
Initialized Players:
- [ Name : Raghav , Color : R ]

* Enter Player 2 Name and One Character Code For Board Piece Color separated by ',': e.g - Raghav,R


Ankit,W

Initialized Players:
- [ Name : Ankit , Color : W ]
- [ Name : Raghav , Color : R ]

* Start Game
* Quit

start game
```

### Gameplay
Once the game starts it will show you the grid and the player details who's turn it is

```text
- [ Name : Ankit , Color : W ] turn to play

Select the column in which you want to drop the piece or type `menu` and confirm with <enter>

   1     2     3     4     5     6     7   
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬


1

- [ Name : Raghav , Color : R ] turn to play

Select the column in which you want to drop the piece or type `menu` and confirm with <enter>

   1     2     3     4     5     6     7   
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  W  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬

2
- [ Name : Ankit , Color : W ] turn to play

Select the column in which you want to drop the piece or type `menu` and confirm with <enter>

   1     2     3     4     5     6     7   
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  W  ║  R  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
```

You can keep playing until one of the player wins or the game draws.

```text
The game ended with - [ Name : Raghav , Color : R ] win.

Press <enter> to continue.

   1     2     3     4     5     6     7   
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  W  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  R  ║  R  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  W  ║  W  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  R  ║  W  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  W  ║  R  ║  W  ║  W  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  W  ║  R  ║  R  ║  R  ║  R  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬

```

Pressing enter once the game ends will move you to the main screen which comes up when the game starts.

### Leaving in Middle of the Game
While the game is running and you wish to exit you can go to menu and choose to quit, resume or start a new game

```text
- [ Name : Raghav , Color : R ] turn to play

Select the column in which you want to drop the piece or type `menu` and confirm with <enter>

   1     2     3     4     5     6     7   
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  W  ║  -  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  R  ║  R  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  W  ║  W  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  R  ║  W  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  W  ║  R  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬
║  W  ║  R  ║  -  ║  -  ║  -  ║  -  ║  -  ║
╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬

menu
  ______   ______   .__   __. .__   __.  _______   ______ .___________.    _  _
 /      | /  __  \  |  \ |  | |  \ |  | |   ____| /      ||           |   | || |
|  ,----'|  |  |  | |   \|  | |   \|  | |  |__   |  ,----'`---|  |----`   | || |_
|  |     |  |  |  | |  . `  | |  . `  | |   __|  |  |         |  |        |__   _|
|  `----.|  `--'  | |  |\   | |  |\   | |  |____ |  `----.    |  |           | |
 \______| \______/  |__| \__| |__| \__| |_______| \______|    |__|           |_|


* Resume
* New Game
* Quit
```

## Credits

This project was inspired by and built upon the concepts learned from [Jorge Vasquez](https://github.com/jorge-vasquez-2301)
book, Mastering modularity in ZIO where he created Tic Tac Toe using ZIO. I'd like to express my gratitude for the valuable knowledge shared in this book.