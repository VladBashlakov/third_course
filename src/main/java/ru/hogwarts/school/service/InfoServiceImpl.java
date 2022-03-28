package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Primary
@Service
public class InfoServiceImpl implements InfoService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String getPort() {
        return serverPort;
    }

}
