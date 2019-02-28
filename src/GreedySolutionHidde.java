import java.util.*;

public class GreedySolutionHidde {
    static Random random = new Random();

    static List<Slide> generate(List<Slide> input) {
        SlideShow SS = new SlideShow();

        class SlideComparator implements Comparator<Slide> {

            @Override
            public int compare(Slide s1, Slide s2) {
                return s1.getTags().size() - s2.getTags().size();
            }
        }

        Collections.sort(input, new SlideComparator());

        return input;

    }

}
