package tobspring.helloboot;

import com.example.hellospring2.HelloController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
    @Test
    void helloController(){
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test");

        Assertions.assertThat(ret).isEqualTo("Test");

    }

    @Test
    void failsHelloController(){
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(()->{
            String ret = helloController.hello(null);
        }).isInstanceOf(NullPointerException.class);

    }
}
