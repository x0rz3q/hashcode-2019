import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

import static java.lang.Math.min;

public class Evaluator {
    static int evaluateSlideShow(List<Slide> solution) {
        int sum = 0;

        for (int i = 0; i < solution.size() - 1; i++) {
            sum += evaluateSlide(solution.get(i), solution.get(i+1));
        }
        return sum;
    }

    static int evaluateSlide(Slide slide1, Slide slide2) {
        HashSet<Integer> slide1tags = new HashSet<>();
        HashSet<Integer> slide2tags = new HashSet<>();

        for (Picture pic : slide1.pictures) {
            slide1tags.addAll(pic.getTags());
        }

        for (Picture pic : slide2.pictures) {
            slide2tags.addAll(pic.getTags());
        }

        Set<Integer> intersection = new HashSet<Integer>(slide1tags);
        intersection.retainAll(slide2tags);
        int inter = intersection.size();
        int a = slide1tags.size() - inter;
        int b = slide2tags.size() - inter;
        return min(min(inter, a), b);
    }



}
