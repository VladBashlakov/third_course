package ru.hogwarts.school.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!production")
public class InfoServiceImplTest implements InfoService{

    @Override
    public String getPort() {
        return "9090";
    }

}
