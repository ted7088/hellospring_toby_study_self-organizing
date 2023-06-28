package tobyspring.helloboot;

public interface HelloService {

    String sayhello(String name);
    default  int countOf(String name){
        return 0;
    }

}
