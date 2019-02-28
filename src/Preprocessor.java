import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Preprocessor {
    // creates all slides
    static ArrayList<Slide> preprocess(HashSet<Picture> verticles, HashSet<Picture> horizontals) {
        ArrayList<Slide> result = new ArrayList<>();

        ArrayList<Picture> pictures = new ArrayList<>();
        for (Picture p : verticles) {
            pictures.add(p);
        }
        class picComparator implements Comparator<Picture> {

            @Override
            public int compare(Picture picture, Picture t1) {
                return picture.getSize() - t1.getSize();
            }
        }
        Collections.sort(pictures, new picComparator());

        while (pictures.size() > 1) {
            result.add(new Slide(pictures.remove(0), pictures.remove(pictures.size() - 1)));
        }
        if (pictures.size() == 1) {
            result.add(new Slide(pictures.get(0)));
        }

        for (Picture p : horizontals) {
            result.add(new Slide(p));
        }

        return result;
    }

}