import java.util.List;
import java.util.Map;

public class PossibleMove {
    Integer numMoves;
    Map<List<Integer>, List<List<Integer>>> moves;
    public PossibleMove(Integer n, Map<List<Integer>, List<List<Integer>>> list)
    {
        this.numMoves = n;
        this.moves = list;
    }
}
