package spring.io.state.managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.io.state.managment.model.Server;

public interface ServerRepository extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress);

}
