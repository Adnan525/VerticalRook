# Vertical Rook with visualisation
## Features
- Pawn can go vertically across the board
- one column can have only one pawn from each player
- each pawn can move 1 square at a time
- Pawn can't jump or acquire same sqaure with another pawn
- Player 2 moves first
- Both players would play optimally, implying they will take the move which will result least number of opponent movers, check solve() method

I roughly followed the mini max algorithm from game theory, perhaps it's a bit more complicated that it could have been.

# Example input:
player1: List<List<Integer>>
{{0,0},{1,1},{1,2}}
player2: List<List<Integer>>
{{0,1},{0,2},{2,0}}

# Output:
1  2  2
_  1  1
2  _  _
=========
Taking move: (2,0) ==> (1,0)
1  2  2
2  1  1
 _  _  _ 
=========
Taking move: (1,1) ==> (2,1)
1  2  2
2  _  1
_  1  _
=========
Taking move: (0,1) ==> (1,1)
1  _  2
2  2  1
_  1  _
=========
Taking move: (1,2) ==> (2,2)
1  _  2
2  2  _
_  1  1
=========
Taking move: (0,2) ==> (1,2)
1  _  _
2  2  2
_  1  1
=========
Winner : player-2
