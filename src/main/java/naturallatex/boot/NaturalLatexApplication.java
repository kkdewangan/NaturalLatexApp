package naturallatex.boot;
import naturallatex.entity.BillingAddress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackageClasses= {BillingAddress.class})
@ComponentScan("naturallatex.*")
public class NaturalLatexApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(NaturalLatexApplication.class, args);
    }       
}            