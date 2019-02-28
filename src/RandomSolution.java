import java.util.ArrayList;
import java.util.Random;

public class RandomSolution {
    static Random random = new Random();

    static SlideShow generate(ArrayList<Picture> pictures) {
        int size = pictures.size();
        ArrayList<Integer> taken = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            taken.add(0);
        }

        SlideShow SS = new SlideShow();
        for (int i = 0; i < size; i++) {
            int j = random.nextInt(size + 1);
            while (taken.get(j) == 1) {
                j = (j + 1) % size;
            }
            SS.addSlide(new Slide(pictures.get(j)));
            taken.set(j, 1);
        }
        return SS;
    }
}
