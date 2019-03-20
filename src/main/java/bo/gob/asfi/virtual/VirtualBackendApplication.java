package bo.gob.asfi.virtual;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VirtualBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VirtualBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			System.out.println((10 - i - 1) + " ...");
		}
	}

}
