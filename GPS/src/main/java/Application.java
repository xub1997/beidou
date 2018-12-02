
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories(basePackages = "business.entity.repositories")
@EntityScan(basePackages = {"business.entity"})
@ComponentScan(basePackages = {"web","business"})
@EnableAsync
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args){
        log.info("starting application");
        SpringApplication.run(Application.class,args);
    }
}
