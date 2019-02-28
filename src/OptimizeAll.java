import java.io.File;

public class OptimizeAll {
    public static void main(String[] args) throws Exception {
        File folder = new File("inputFiles");

        File[] files = folder.listFiles();

        for (File file : files) {
            if (!file.getName().equals("b_lovely_landscapes.txt")) {
                String[] iArgs = new String[] {file.getPath(), "outputFiles" + File.separator + file.getName()};
                Controller.main(iArgs);
            }
        }
    }
}
