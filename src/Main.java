import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Katalog(System.getProperty("user.home") + "/Desktop", System.getProperty("user.home") + "/Desktop/ForCopy").copy();
    }
}
