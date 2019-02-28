import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Controller {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("No valid file given!");
        }

        if (!(new File(args[0]).exists())) {
            throw new Exception("File " + args[0] + " does not exist!");
        }

        Parser parser = new Parser(args[0]);

        if (args.length > 1) {
            if (!(new File(args[1]).exists())) {
                throw new Exception("File " + args[1] + " does not exist!");
            }

            parser.readSolution(args[1]);
        }

        // getting first order with good vertical matching
        List<Slide> slides = Preprocessor.preprocess(parser.getVerticals(), parser.getHorizontals(), 10000);

        //
        HashMap<Integer, ArrayList<Slide>> sizemapSlides = new HashMap<>();
        for (Slide s: slides) {
            if (sizemapSlides.containsKey(s.getTags().size()))
                sizemapSlides.get(s.getTags().size()).add(s);
            else
                sizemapSlides.put(s.getTags().size(), new ArrayList<Picture>(){{add(s);}});
        }


        // get good first sort

        // TODO: add

        // optimize order of slides
        LocalOptimizerOrder optimizer = new LocalOptimizerOrder();

        Slide[] slideArray = new Slide[slides.size()];
        slideArray = slides.toArray(slideArray);

        optimizer.optimize(slideArray,  1000);

        // output to test.txt
        (new SlideShow(Arrays.asList(slideArray))).output("test.txt");

    }
}