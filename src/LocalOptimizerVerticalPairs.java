import java.util.List;
import java.util.Random;

public class LocalOptimizerVerticalPairs {
    private Random random = new Random();
    private List<Slide> slides;


    public void optimize(List<Slide> slides, int noIterations) {
        this.slides = slides;

        for (int i = 0; i < noIterations; i++) {
            optimizeOnce();
        }


    }

    private void optimizeOnce() {
        int swapFirst = random.nextInt(slides.size());
        int swapSecond = random.nextInt(slides.size());

        while (swapSecond == swapFirst) {
            swapSecond = random.nextInt(slides.size());
        }

        singleOptimizeSwap(swapFirst, swapSecond);
    }


    private void singleOptimizeSwap(int i, int j) {
        Slide slide1 = slides.get(i);
        Slide slide2 = slides.get(j);

        int currentScore = getScore(i) + getScore(j);

        Picture pic = slide1.getPicture2();
        slide1.setPicture2(slide2.getPicture1());
        slide2.setPicture1(pic);
        int scoreSwap1 = getScore(i) + getScore(j);

        pic = slide1.getPicture2();
        slide1.setPicture2(slide2.getPicture2());
        slide2.setPicture2(pic);
        int scoreSwap2 = getScore(i) + getScore(j);

        if (scoreSwap2 > scoreSwap1 && scoreSwap2 > currentScore) {
            return;
        }

        if (scoreSwap1 > currentScore) {
            pic = slide1.getPicture2();
            slide1.setPicture2(slide2.getPicture2());
            slide2.setPicture2(pic);
            return;
        }

        pic = slide1.getPicture2();
        slide1.setPicture2(slide2.getPicture1());
        slide2.setPicture1(pic);
    }

    private int getScore(int i) {
        return slides.get(i).getTags().size();
    }
}
