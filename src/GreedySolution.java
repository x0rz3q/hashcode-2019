import java.util.*;

public class GreedySolution {
    static Random random = new Random();

    static SlideShow generate(HashMap<Integer, ArrayList<Slide>> map) {
        SlideShow SS = new SlideShow();
        Set<Integer> keys = map.keySet();
        List<Integer> keyList = new ArrayList<>(keys);

        keyList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer < t1 ? 1 : -1;
            }
        });


        while (true) {

        }

        int offset = 0;
        Slide S = null;
        Slide SB;
        for (int k: keyList) {
            ArrayList<Slide> slides = map.get(k);
            if (S == null) {
                S = slides.get(0);
                S.take();
                SS.addSlide(S);
                continue;
            }

            for (int i = 0; i < offset; i++) {
                for (int j = 0; j < map.get(k - i).size(); j++) {
                    Set<Integer> intersection = new HashSet<Integer>(slides.get(i).getTags());
                    intersection.retainAll(slides.get(j).getTags());

                    if (intersection.size() == k / 2) {
                        pictures.get(i).take();
                        pictures.get(j).take();
                    }
                }

            }
        }
        ArrayList<Picture> pictures;
        for (Map.Entry<Integer, ArrayList<Picture>> entry: map.entrySet()) {
            k = entry.getKey();
            pictures = entry.getValue();

            for (int i = 0; i < pictures.size(); i++) {
                if (pictures.get(i).isTaken()) continue;

                for (int j = i; j < pictures.size(); j++) {
                    if (pictures.get(j).isTaken()) continue;

                    Set<Integer> intersection = new HashSet<Integer>(pictures.get(i).getTags());
                    intersection.retainAll(pictures.get(j).getTags());
                    /**
                     * Assumption!
                     *    We can live with k/2 even when k == odd.
                     */
                    if (intersection.size() == k / 2) {
                        pictures.get(i).take();
                        pictures.get(j).take();
                    }
                }
            }
        }

        return SS;
    }
}
