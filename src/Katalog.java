import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Katalog {
    private String newPath;
    private String path;

    public Katalog(String newPath, String path) {
        this.newPath = newPath;
        this.path = path;
    }

    void copy() throws IOException {
        File dir = new File(newPath, new File(path).getName() + "(1)");
        if (dir.mkdir()) {
            System.out.println("Папка создана");
        }
        File[] files = new File(path).listFiles();
        assert files != null;
        for (File f:files) {
            Files.copy(f.toPath(),new File(dir.getAbsolutePath()+"/"+f.getName()).toPath(),StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
