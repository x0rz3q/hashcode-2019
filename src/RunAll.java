import java.io.File;

public class RunAll {
    public static void main(String[] args) throws Exception {
        File folder = new File("inputFiles");

        File[] files = folder.listFiles();

        for (File file : files) {
            String[] iArgs = new String[] {file.getPath()};
            Controller.main(iArgs);
        }
    }
}
