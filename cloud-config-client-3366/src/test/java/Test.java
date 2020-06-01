import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Executors;

@SpringBootTest
public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        Executors.newSingleThreadExecutor();
    }

}
