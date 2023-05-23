package tobspring.helloboot;

import com.example.hellospring2.SimpleHelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
    @Test
    void simpleHelloService(){
        SimpleHelloService helloService = new SimpleHelloService();

        String ret = helloService.sayhello("Test");

        Assertions.assertThat(ret).isEqualTo("Hello Test");

    }
}
