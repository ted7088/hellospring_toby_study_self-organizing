package tobyspring.helloboot;

public interface HelloRepository {
    Hello findHello(String name);

    void increasesCount(String name);

    default int countOf(String name){
        Hello hello =findHello(name);
        return hello == null? 0 : hello.getCount();
    }


}
