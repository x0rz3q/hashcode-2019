public class Slide {
    Picture[] pictures;

    public Slide(Picture p1) {
        pictures = new Picture[] {p1};
    }
    public Slide(Picture p1, Picture p2) {
        pictures = new Picture[] {p1, p2};
    }

    @Override
    public String toString() {
        if (this.pictures.length == 1) {
            return "" + this.pictures[0].getId();
        }

        return "" + this.pictures[0].getId() + " " + this.pictures[1].getId();
    }
}
