package tobspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import tobyspring.helloboot.HelloRepository;
import tobyspring.helloboot.HelloService;

import java.util.stream.IntStream;

@HellobootTest
public class HelloServiceCountTest {
    @Autowired
    HelloService helloService;
    @Autowired
    HelloRepository helloRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init(){
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void sayHelloIncreaseCount(){

        IntStream.rangeClosed(1, 10).forEach(count-> {
            helloService.sayhello("Toby");
            Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(count
            );

        });
    }


}
