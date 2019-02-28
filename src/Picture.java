import java.util.Comparator;
import java.util.List;

public class Picture {
    private boolean dir; // TRUE = HORIZONTAL
    private int id;
    private List<Integer> tags;
    private int size;

    Picture (boolean dir, int id, List<Integer> tags) {
        this.dir = dir;
        this.id = id;
        this.tags = tags;
        this.size = tags.size();
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

    int getSize() {
        return this.size = size;
    }

    boolean getDir() {
        return this.dir;
    }
}
