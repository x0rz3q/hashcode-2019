import java.io.File;
import java.util.*;

public class Parser {
    private int total;
    private HashMap<String, Integer> tags = new HashMap<>();
    private List<Picture> pictures = new ArrayList<>();

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

                // Direction true = horizontal
                this.pictures.add(new Picture(orientation.equals("H"), id++, tags));
            }
        }
    }
}
