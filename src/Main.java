import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new CopyOperation());
        executorService.shutdown();
    }
}
