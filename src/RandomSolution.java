import java.util.*;

public class RandomSolution {
    static Random random = new Random();

    static SlideShow generate(List<Picture> pictures) {
        int size = pictures.size();
        ArrayList<Integer> taken = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            taken.add(0);
        }

        Collections.shuffle(pictures);

        SlideShow SS = new SlideShow();

        for (Picture picture : pictures) {
            SS.addSlide(new Slide(picture));
        }

        return SS;
    }
}
