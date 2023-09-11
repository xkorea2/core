package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetworkClient networkClient() {
            System.out.println("LifeCycleConfig.networkClient1");
            NetworkClient networkClient = new NetworkClient();
            System.out.println("LifeCycleConfig.networkClient2");
            networkClient.setUrl("http://hello-spring.dev");
            System.out.println("LifeCycleConfig.networkClient3");
            return networkClient;
        }
    }
}
