package me.dio.service;

import me.dio.domain.model.User;

public interface ServicoUsuario {

    User findById(Long id);

    User create(User userToCreate);
}
