package tobyspring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary //빈중에서 우선순위를 정하는 것
public class HelloDecorator implements HelloService{
    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayhello(String name) {
        return "*"+helloService.sayhello(name)+"*";
    }

    @Override
    public int countOf(String name) {
        return helloService.countOf(name);
    }
}
