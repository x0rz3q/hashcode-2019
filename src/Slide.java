public class Slide {
    Picture[] pictures;

    public Slide(Picture p1) {
        pictures = new Picture[] {p1};
    }
    public Slide(Picture p1, Picture p2) {
        pictures = new Picture[] {p1, p2};
    }
}
