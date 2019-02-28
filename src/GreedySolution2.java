import javafx.scene.control.Slider;

import java.util.*;

public class GreedySolution2 {

    ArrayList<Slide> solution;
    HashMap<Integer, ArrayList<Slide>> input;
    int maxKey;
    int diff = 10;


    public List<Slide> getGreedySolution(HashMap<Integer, ArrayList<Slide>> input, int noSlides) {
        solution = new ArrayList<>();
        this.input = input;

        maxKey = Collections.max(input.keySet());
        Slide first = input.get(maxKey).get(0);
        solution.add(first);

        first.take();

        int lastKey = maxKey;
        for (int i = 1; i < noSlides; i++) {
            lastKey = getNext(lastKey);
        }

        return solution;
    }


    private int getNext(int lastKey) {
        Slide lastSlide = solution.get(solution.size() - 1);
        int bestVal = Integer.MAX_VALUE;
        Slide bestSlide = null;
        int bestSlideKey = -1;
        for (int i = maxKey; i > lastKey - diff; i--) {
            if (input.containsKey(i)) {
                for (Slide s : input.get(i)) {
                    int currentVal = getValue(lastSlide, s, lastKey);
                    if (currentVal < bestVal) {
                        bestSlide = s;
                        bestVal = currentVal;
                        bestSlideKey = i;
                    }
                }
            }
        }
        if (bestSlide == null) {

        for (int i = lastKey - diff; i >= 0; i--) {
            if (input.containsKey(i)) {
                 bestSlide = input.get(i).get(0);
                 bestSlideKey = i;
            }
        }
        }

        solution.add(bestSlide);
        return bestSlideKey;
    }

    private int getValue(Slide lastSlide, Slide currentSlide, int lastKey) {
        HashSet<Integer> slide1tags = new HashSet<>();
        HashSet<Integer> slide2tags = new HashSet<>();

        for (Picture pic : lastSlide.pictures) {
            slide1tags.addAll(pic.getTags());
        }

        for (Picture pic : currentSlide.pictures) {
            slide2tags.addAll(pic.getTags());
        }

        Set<Integer> intersection = new HashSet<Integer>(slide1tags);
        intersection.retainAll(slide2tags);
        return Math.abs(lastKey/2 - intersection.size());
    }

}
