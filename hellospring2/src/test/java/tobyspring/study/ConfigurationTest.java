package tobyspring.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
    @Test
    void proxyCommonMethod(){
        MyConfigProxy myConfigProxy = new MyConfigProxy();

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        Assertions.assertThat(bean1.commmon).isSameAs(bean2.commmon);
    }
    static class MyConfigProxy extends MyConfig{
        private  Common common;
        @Override
        Common common(){
            if(this.common==null) this.common =super.common();

            return  this.common;
        }
    }
    @Configuration
    static class MyConfig{
        @Bean
        Common common(){
            return new Common();
        }
        @Bean
        Bean1 bean1(){
            return new Bean1(common());
        }
        @Bean
        Bean2 bean2(){
            return new Bean2(common());
        }

    }

    static class Bean1{

        private final Common commmon;

        Bean1(Common commmon) {
            this.commmon = commmon;
        }
    }
    static class Bean2{

        private final Common commmon;

        Bean2(Common commmon) {
            this.commmon = commmon;
        }
    }
    static class Common{

    }

    //Bean1 <--Common
    //Bean2 <--Common

}
