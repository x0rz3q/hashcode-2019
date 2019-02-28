import java.util.Comparator;
import java.util.List;

public class Picture {
    private boolean dir; // TRUE = HORIZONTAL
    private int id;
    private List<Integer> tags;

    Picture (boolean dir, int id, List<Integer> tags) {
        this.dir = dir;
        this.id = id;
        this.tags = tags;
    }

    List<Integer> getTags() {
        return this.tags;
    }

//    List<Integer> getSortedTags() {
//        return tags.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer integer, Integer t1) {
//                if (integer < t1) {
//                    return 1;
//                } else {
//                    return 0;
//                }};
//            }
//        });
//    }

    int getId() {
        return this.id;
    }

    boolean getDir() {
        return this.dir;
    }
}
