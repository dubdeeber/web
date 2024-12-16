package web.dub.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import web.dub.model.Manager;
import web.dub.repository.ManagerRepository;

@Service
public class ManagerDetailsService implements UserDetailsService {

    private final ManagerRepository managerRepository;

    public ManagerDetailsService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerRepository.findByUsername(username);
        if (manager == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(manager.getUsername())
                .password(manager.getPassword())
                .roles("MANAGER")
                .build();
    }
}
