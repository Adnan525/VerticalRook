import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<List<Integer>> player1 = new ArrayList<>();
        List<List<Integer>> player2 = new ArrayList<>();

        player1.add(Arrays.asList(2,0));
        player1.add(Arrays.asList(2,1));
        player1.add(Arrays.asList(2,2));
        player1.add(Arrays.asList(2,3));

        player2.add(Arrays.asList(3,0));
        player2.add(Arrays.asList(3,1));
        player2.add(Arrays.asList(3,2));
        player2.add(Arrays.asList(3,3));

//        PossibleMove test = Solve.getAllMoves(player1, player2, 4);
//        System.out.println(test.numMoves);
//        for(List<Integer> key : test.moves.keySet())
//        {
//            for(List<Integer> value: test.moves.get(key))
//            {
//                System.out.println("("+key.get(0)+","+key.get(1)+") ==> ("+value.get(0)+","+value.get(1)+")");
//            }
//        }

        System.out.println(Solve.solve(player1, player2, 4, 1));
    }
}
