import java.io.File;
import java.util.Arrays;
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

        List<Slide> slides = Preprocessor.preprocess(parser.getVerticals(), parser.getHorizontals());

        LocalOptimizerOrder optimizer = new LocalOptimizerOrder();

        Slide[] slideArray = new Slide[slides.size()];
        slideArray = slides.toArray(slideArray);

        optimizer.optimize(slideArray);

        (new SlideShow(Arrays.asList(slideArray))).output("test.txt");

    }
}