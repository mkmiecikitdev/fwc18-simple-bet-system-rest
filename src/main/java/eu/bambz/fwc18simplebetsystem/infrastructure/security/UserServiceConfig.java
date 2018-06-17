package eu.bambz.fwc18simplebetsystem.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserServiceConfig {

    @Bean
    UserService userService(UsersRepository usersRepository) {
        return new UserService(usersRepository);
    }

}
