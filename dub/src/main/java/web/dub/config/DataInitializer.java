package web.dub.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import web.dub.model.Manager;
import web.dub.repository.ManagerRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner dataLoader(ManagerRepository managerRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (managerRepository.findByUsername("root") == null) {
                Manager manager = new Manager();
                manager.setUsername("root");
                manager.setPassword(passwordEncoder.encode("root"));
                managerRepository.save(manager);
            }
        };
    }
}
