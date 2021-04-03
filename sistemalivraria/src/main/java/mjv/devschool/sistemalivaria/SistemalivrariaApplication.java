package mjv.devschool.sistemalivaria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
public class SistemalivrariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemalivrariaApplication.class, args);
	}

}
