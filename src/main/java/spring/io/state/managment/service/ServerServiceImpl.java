package spring.io.state.managment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.io.state.managment.model.Server;
import spring.io.state.managment.model.Status;
import spring.io.state.managment.repository.ServerRepository;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class ServerServiceImpl implements ServerService{

    private final ServerRepository serverRepository;

    @Override
    public Server create(Server server) {
        log.info("Creating server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);
    }

    private String setServerImageUrl() {
        return "https://www.google.com";
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}",ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(1000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        return null;
    }

    @Override
    public Server get(Long id) {
        return null;
    }

    @Override
    public Server update(Server server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
