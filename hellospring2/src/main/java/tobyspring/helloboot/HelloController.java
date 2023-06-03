package tobyspring.helloboot;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController implements ApplicationContextAware {
    private final HelloService helloService;
    public HelloController(HelloService helloService ) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name)  {
        if(name==null || name.trim().length()==0) throw new IllegalArgumentException();

        return helloService.sayhello(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
    }
}
