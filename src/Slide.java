import java.util.HashSet;
import java.util.Set;

public class Slide {
    Picture[] pictures;
    boolean taken = false;
    public Slide(Picture p1) {
        pictures = new Picture[] {p1};
    }
    public Slide(Picture p1, Picture p2) {
        pictures = new Picture[] {p1, p2};
<<<<<<< HEAD
    }
=======
   }
>>>>>>> c5699ff2c3a18a9ccb24b635d2a1f6bf644fcaa6

    @Override
    public String toString() {
        if (this.pictures.length == 1) {
            return "" + this.pictures[0].getId();
        }

        return "" + this.pictures[0].getId() + " " + this.pictures[1].getId();
    }

    public boolean isTaken() {
        return this.taken;
    }

    public void take() {
        this.taken = true;
    }
    public Picture getPicture1() {
        return pictures[0];
    }

    public Picture getPicture2() {
        return pictures[1];
    }

    public void setPicture1(Picture picture) {
        pictures[0] = picture;
    }


    public void setPicture2(Picture picture) {
        pictures[1] = picture;
    }


    public Set<Integer> getTags() {
        Set<Integer> tags = new HashSet<>();
        for (Picture p : pictures) {
            tags.addAll(p.getTags());
        }
        return tags;
    }

}
