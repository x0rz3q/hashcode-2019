import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SlideShow {
    List<Slide> slides;
    private static final String lineSeperator = "\n";

    SlideShow() {
        this.slides = new ArrayList<>();
    }

    SlideShow(List<Slide> slides) {
        this.slides = slides;
    }

    void addSlide(Slide s) {
        this.slides.add(s);
    }

    void output(String location) throws Exception {
        FileWriter writer = new FileWriter(location);
        int n = this.slides.size();
        writer.write(n + lineSeperator);

        // TODO: write n, write newline
        for (Slide s: this.slides) {
            writer.write(s.toString() + lineSeperator);
        }

        writer.close();
    }
}
