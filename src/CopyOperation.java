import java.io.IOException;

public class CopyOperation implements Runnable{
    Katalog katalog = new Katalog(System.getProperty("user.home") + "/Desktop",
            System.getProperty("user.home") + "/Desktop/ForCopy");

    @Override
    public void run() {
        try {
            katalog.copy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
