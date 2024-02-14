package com.example.demoproject23333.services.Impl;

import com.example.demoproject23333.model.enums.Role;
import com.example.demoproject23333.model.User;
import com.example.demoproject23333.repositories.UserRepository;
import com.example.demoproject23333.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Реализация сервиса для работы с пользователями
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    //Сохраняет пользователя в базу данных
    public User save(User user) {
        return repository.save(user);
    }
    //Создает нового пользователя
    public User create(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Пользователь с таким email уже существует");
        }

        return save(user);
    }
    //Получает пользователя по его имени пользователя
    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }
    //Возвращает интерфейс для загрузки пользователя по его имени пользователя
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    //Получает текущего аутентифицированного пользователя
    public User getCurrentUser() {

        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }


}
