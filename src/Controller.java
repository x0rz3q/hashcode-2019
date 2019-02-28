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

        System.out.println(args[0]);
        Parser parser = new Parser(args[0]);

        if (args.length > 1) {
            if (!(new File(args[1]).exists())) {
                throw new Exception("File " + args[1] + " does not exist!");
            }

            parser.readSolution(args[1]);
        }
//
//        // getting first order with good vertical matching
//
//        slides = GreedySolutionHidde.generate(slides);
//
//        HashMap<Integer, ArrayList<Slide>> sizemapSlides = new HashMap<>();
//        for (Slide s: slides) {
//            if (sizemapSlides.containsKey(s.getTags().size()))
//                sizemapSlides.get(s.getTags().size()).add(s);
//            else
//                sizemapSlides.put(s.getTags().size(), new ArrayList<Slide>(){{add(s);}});
//        }


        // get good first sort

        // TODO: add

        // optimize order of slides
        SlideShow best = null;

        for (int i = 0; i < 10; i++) {
            SlideShow slides = RandomSolution.generate(parser.getPictures());

            LocalOptimizerOrder optimizer = new LocalOptimizerOrder();

            Slide[] slideArray = new Slide[slides.getSlides().size()];
            slideArray = slides.getSlides().toArray(slideArray);

            optimizer.optimize(slideArray,  1000000);

            // output to test.txt
            SlideShow result = new SlideShow(Arrays.asList(slideArray));

            if (best == null)
                best = result;
            else if(Evaluator.evaluateSlideShow(result.slides) > Evaluator.evaluateSlideShow(best.slides))
                best = result;
        }

        best.output("outputFiles" + File.separator + (new File(args[0]).getName()));
    }
}