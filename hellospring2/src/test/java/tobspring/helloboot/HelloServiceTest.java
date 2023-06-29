package tobspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tobyspring.helloboot.Hello;
import tobyspring.helloboot.HelloDecorator;
import tobyspring.helloboot.HelloRepository;
import tobyspring.helloboot.SimpleHelloService;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface  FastUnitTest{

}
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Test
@interface  UnitTest{

}
public class HelloServiceTest {
    @UnitTest// 어노테이션 ㅇ만들기 단위테스트
    void simpleHelloService(){
        SimpleHelloService helloService = new SimpleHelloService(new HelloRepository() {
            @Override
            public Hello findHello(String name) {
                return null;
            }

            @Override
            public void increasesCount(String name) {

            }
        });

        String ret = helloService.sayhello("Test");

        Assertions.assertThat(ret).isEqualTo("Hello Test");

    }

    @Test
    void helloDecorator(){
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayhello("Test");

        Assertions.assertThat(ret).isEqualTo("*Test*");
    }
}
