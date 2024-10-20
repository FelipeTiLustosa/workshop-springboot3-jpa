package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration // Diz ao Spring que essa classe contém configurações que devem ser carregadas quando a aplicação for iniciada.
@Profile("test")// Diz que essa configuração só deve ser ativada quando o perfil "test" estiver em uso, ou seja, quando você rodar a aplicação em um ambiente de teste.
public class TestConfig implements CommandLineRunner { //É uma interface que força a classe a implementar o método run(). Esse método é rodado assim que o Spring Boot começa a executar a aplicação, depois de tudo ter sido configurado.

    @Autowired //O Spring injeta automaticamente uma instância do UserRepository aqui, para que você possa usar ele dentro dessa classe sem precisar instanciar manualmente
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
