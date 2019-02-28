import java.io.File;
import java.util.*;

public class Parser {
    private int total;
    private HashMap<String, Integer> tags = new HashMap<>();
    private List<Picture> pictures = new ArrayList<>();
    private List<Slide> slideshow = new ArrayList<>();
    private HashMap<Integer, Picture> indexed = new HashMap<>();
    private HashSet<Picture> verticals = new HashSet<>();
    private HashSet<Picture> horizontals = new HashSet<>();
    private HashMap<Integer, ArrayList<Picture>> sizemap = new HashMap<>();

    public Parser(String file) throws Exception {
        Scanner scanner = new Scanner(new File(file));
        this.total = scanner.nextInt();
        int tagIndex = 0;
        int id = 0;

        while(scanner.hasNext()) {
            String orientation = scanner.next();

            int amount = scanner.nextInt();
            List<Integer> tags = new ArrayList<>();

            for (int i = 0; i < amount; i++) {
                String tag = scanner.next();

                if (this.tags.containsKey(tag)) {
                    tags.add(this.tags.get(tag));
                } else {
                    this.tags.put(tag, tagIndex);
                    tags.add(tagIndex);
                    tagIndex++;
                }
            }

            Picture picture = new Picture(orientation.equals("H"), id++, tags);

            if (this.sizemap.containsKey(tags.size()))
                this.sizemap.get(tags.size()).add(picture);
            else
                this.sizemap.put(tags.size(), new ArrayList<>(){{add(picture);}});

            // Direction true = horizontal
            this.pictures.add(picture);
            this.indexed.put(picture.getId(), picture);
            this.verticals.add(picture);
            this.horizontals.add(picture);
        }
    }

    public void readSolution(String file) throws Exception {
        Scanner scanner = new Scanner(new File(file));

        int amount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < amount; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            Picture first = this.indexed.get(Integer.parseInt(parts[0]));

            Picture second = null;
            if (parts.length > 1)
                second = this.indexed.get(Integer.parseInt(parts[1]));

            this.slideshow.add(new Slide(first, second));
        }
    }

    public List<Slide> getSlideshow() {
        return slideshow;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public HashMap<Integer, Picture> getIndexed() {
        return indexed;
    }

    public HashMap<String, Integer> getTags() {
        return tags;
    }

    public HashSet<Picture> getVerticals() {
        return verticals;
    }

    public HashSet<Picture> getHorizontals() {
        return horizontals;
    }

    public HashMap<Integer, ArrayList<Picture>> getSizemap() {
        return sizemap;
    }
}
