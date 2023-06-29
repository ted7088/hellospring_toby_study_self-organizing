package tobspring.helloboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import tobyspring.helloboot.HelloRepository;
import tobyspring.helloboot.HellobootApplication;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = HellobootApplication.class)
@Transactional
public class HelloRepositoryTest {

    @Autowired
    HelloRepository helloRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init(){
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

//    @Test
//    void findHelloFailed(){
//        assertThat(helloRepository.findHello("Toby")).isNull();
//    }
    @Test
    void increaseCount(){
        assertThat(helloRepository.countOf("Toby")).isEqualTo(0);

        helloRepository.increasesCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(1);

        helloRepository.increasesCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(2);

    }

}
