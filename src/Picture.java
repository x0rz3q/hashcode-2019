import java.util.Comparator;
import java.util.List;

public class Picture {
    private Direction dir;
    private int id;
    private List<Integer> tags;

    Picture (Direction dir, int id, List<Integer> tags) {
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
//                return integer < t1 ? 0;
//            }
//        });
//    }

    int getId() {
        return this.id;
    }

    Direction getDir() {
        return this.dir;
    }
}
