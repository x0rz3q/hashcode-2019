import java.util.*;

public class RandomSolution {
    static Random random = new Random();

    static SlideShow generate(List<Picture> pictures) {
        Collections.shuffle(pictures);

        SlideShow SS = new SlideShow();

        for (Picture picture : pictures) {
            SS.addSlide(new Slide(picture));
        }

        return SS;
    }
}
