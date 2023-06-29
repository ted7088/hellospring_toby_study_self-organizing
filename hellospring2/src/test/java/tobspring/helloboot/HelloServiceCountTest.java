package tobspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import tobyspring.helloboot.HelloRepository;
import tobyspring.helloboot.HelloService;
import tobyspring.helloboot.HellobootApplication;

import java.util.stream.IntStream;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = HellobootApplication.class)
@Transactional
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
