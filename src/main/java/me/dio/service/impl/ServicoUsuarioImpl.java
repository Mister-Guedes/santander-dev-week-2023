package me.dio.service.impl;

import me.dio.domain.model.User;
import me.dio.domain.repository.RepositorioUsuario;
import me.dio.service.ServicoUsuario;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ServicoUsuarioImpl implements ServicoUsuario {

    private final RepositorioUsuario userRepository;

    public ServicoUsuarioImpl(RepositorioUsuario userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
