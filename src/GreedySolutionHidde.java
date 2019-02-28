import java.util.*;

public class GreedySolutionHidde {
    static Random random = new Random();

    static SlideShow generate(HashMap<Integer, ArrayList<Picture>> map) {
        SlideShow SS = new SlideShow();
        Set<Integer> keys = map.keySet();
        List<Integer> keyList = new ArrayList<>(keys);

        keyList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer < t1 ? 1 : -1;
            }
        });








    }

}
