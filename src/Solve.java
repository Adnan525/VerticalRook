import java.util.*;

public class Solve {
    public static PossibleMove getAllMoves(List<List<Integer>> player1Pos,List<List<Integer>> player2Pos, int boardSize)
    {
        int numFoundMove = 0;
        Map<List<Integer>, List<List<Integer>>> validMoves = new HashMap<>();

        Map<List<Integer>, String> tempPlayer1Map = new HashMap<>();
        //player1 change to map
        for(List<Integer> li: player1Pos)
        {
            tempPlayer1Map.put(li, "");
        }

        //getting move for player 2
        for(List<Integer> li: player2Pos)
        {
            List<List<Integer>> temp = new ArrayList<>();
            //value x will change since i need to change the value for row
            //check forward move
            if(li.get(0)+1<boardSize && !tempPlayer1Map.containsKey(Arrays.asList(li.get(0)+1, li.get(1))))
            {
                numFoundMove++;
                temp.add(Arrays.asList(li.get(0)+1, li.get(1)));
            }
            //check back move
            if(li.get(0)-1>=0 && !tempPlayer1Map.containsKey(Arrays.asList(li.get(0)-1, li.get(1))))
            {
                numFoundMove++;
                temp.add(Arrays.asList(li.get(0)-1, li.get(1)));
            }

            validMoves.put(li, temp);

        }
        return new PossibleMove(numFoundMove, validMoves);
    }

    public static String solve(List<List<Integer>> player1Pos,List<List<Integer>> player2Pos, int boardSize, int counter)
    {
        Integer least = Integer.MAX_VALUE;
        List<List<Integer>> takeMove = new ArrayList<>();

        //moves for player 2, first move
        PossibleMove choicesForPlayer2 = getAllMoves(player1Pos, player2Pos, boardSize);

        if(choicesForPlayer2.numMoves ==0)
        {
            if(counter%2 == 0)
                return "player-2";
            else
                return "player-1";
        }

        for(List<Integer> pos: choicesForPlayer2.moves.keySet())
        {
            for(List<Integer> mov : choicesForPlayer2.moves.get(pos))
            {
                swapMove(player2Pos, pos, mov);
                PossibleMove possibleOpponentMove = getAllMoves(player2Pos, player1Pos, boardSize);
                if(possibleOpponentMove.numMoves<least)
                {
                    least = possibleOpponentMove.numMoves;
                    takeMove.clear();
                    takeMove.add(pos);
                    takeMove.add(mov);
                }
                swapMove(player2Pos, mov, pos);
            }
        }
        swapMove(player2Pos, takeMove.get(0), takeMove.get(1));

        return solve(player2Pos, player1Pos, boardSize, counter+1);

    }
    public static void swapMove(List<List<Integer>> pos, List<Integer> replace, List<Integer> value)
    {
        pos.remove(replace);
        pos.add(value);
    }


    //hacker rank function, absolutuely useless for the time being.
    //their rook assignment on the board is eccentric
    public static String verticalRooks(List<Integer> r1, List<Integer> r2, int n, int counter) {
        // Write your code here
        List<List<Integer>> player1 = new ArrayList<>();
        List<List<Integer>> player2 = new ArrayList<>();
        for(int i = 0; i<=r1.size()-1; i++)
        {
            player1.add(Arrays.asList(i, r1.get(i)));
            player2.add(Arrays.asList(i, r2.get(i)));
        }
        String result = solve(player1, player2, n, counter);
        return result;
    }
}
