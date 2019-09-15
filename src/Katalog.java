import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
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
        for (File f : files) {
            File newFile = new File(dir.getAbsolutePath(), f.getName());
            Path file = f.toPath();

            cop(file, newFile.getPath());

//            Files.copy(f.toPath(),new File(dir.getAbsolutePath()+"/"+f.getName()).toPath(),StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private void cop(Path file, String fileCopy) throws IOException {
        InputStream is = null;                                     //Поток чтения
        OutputStream os = null;                                    //Поток записи
        try {
            is = new FileInputStream(String.valueOf(file));                 //Для чтения информации из файла
            os = new FileOutputStream(String.valueOf(fileCopy));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {        //Возвращает количество прочитаных байтов
                os.write(buffer, 0, length);              //записывает в поток байтов массива
            }
        } finally {
            assert is != null;
            is.close();
            assert os != null;
            os.close();             //закрывает поток
        }
    }

}
