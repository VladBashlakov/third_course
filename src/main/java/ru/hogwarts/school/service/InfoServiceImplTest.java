package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class InfoServiceImplTest implements InfoService{

    @Value("${server.port}")
    private String serverTestPort;

    @Override
    public String getPort() {
        return serverTestPort;
    }

}
