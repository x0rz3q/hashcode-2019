import java.util.Random;

public class LocalOptimizer {

    private Random random = new Random();
    private Slide[] slides;

    public Slide[] optimize(Slide[] input) {
        slides = input;

        for (int i = 0; i < 100; i++ ){
            optimizeOnce();
        }

        return input;
    }


    private void optimizeOnce() {
        int swapFirst = random.nextInt(slides.length);
        int swapSecond = random.nextInt(slides.length);

        while (swapSecond == swapFirst) {
            swapSecond = random.nextInt(slides.length);
        }

        singleOptimizeSwap(swapFirst, swapSecond);
    }


    private void singleOptimizeSwap(int i, int j) {
        int oldScore = getScore(i) + getScore(j);
        swap(i, j);

        if (getScore(i) + getScore(j) < oldScore) {
            swap(i, j);
        }
    }


    private int getScore(int i) {
        int score = 0;
        if (i > 0) {
            score = Evaluator.evaluateSlide(slides[i - 1], slides[i]);
        }

        if (i < slides.length - 1) {
            score += Evaluator.evaluateSlide(slides[i], slides[i + 1]);
        }

        return score;
    }


    private void swap(int i, int j) {
        Slide slide = slides[i];
        slides[i] = slides[j];
        slides[j] = slide;
    }

}
