import java.util.*;

public class DoExampleB {
    public static SlideShow run(HashMap<String, ArrayList<Picture>> pictures) {
        SlideShow show = new SlideShow();
        TreeSet<Integer> placed = new TreeSet<>();

        for (Map.Entry<String, ArrayList<Picture>> entry : pictures.entrySet()) {
            Iterator<Picture> iterator = entry.getValue().iterator();

            while(iterator.hasNext()) {
                Picture p1 = iterator.next();

                if (!placed.contains(p1.getId())) {
                    Picture p2 = null;

                    while (iterator.hasNext()) {
                        p2 = iterator.next();

                        if (!placed.contains(p2.getId()) && p1.getId() != p2.getId()) {
                            if (p2 != null) {
                                placed.add(p1.getId());
                                placed.add(p2.getId());

                                show.addSlide(new Slide(p1));
                                show.addSlide(new Slide(p2));
                            }
                        }
                    }
                }
            }
        }

        return show;
    }
}
