import java.util.ArrayList;
import java.util.List;

public class SlideShow {
    List<Slide> slides;

    SlideShow() {
        this.slides = new ArrayList<>();
    }

    SlideShow(List<Slide> slides) {
        this.slides = slides;
    }

    void output(String location) {
        int n = location.length();
        // TODO: write n, write newline
        for (Slide s: this.slides) {
            for (Picture p: s.pictures) {
                // TODO: write p
            }
            // TODO: write newline
        }
    }
}
