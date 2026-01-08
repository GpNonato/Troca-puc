package com.trocapuc.trocapuc.service;

import com.trocapuc.trocapuc.dto.UserDTO;
import com.trocapuc.trocapuc.model.User;
import com.trocapuc.trocapuc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setCpf(userDTO.getCpf());
        user.setTelefone(userDTO.getTelefone());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
    }

    public UserDTO getCurrentUserProfile() {
        User currentUser = getCurrentUser();
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(currentUser.getUsername());
        userDTO.setEmail(currentUser.getEmail());
        userDTO.setCpf(currentUser.getCpf());
        userDTO.setTelefone(currentUser.getTelefone());
        userDTO.setPassword(""); // Não enviamos a senha para exibição
        return userDTO;
    }

    public boolean updateUserProfile(UserDTO userDTO) {
        User currentUser = getCurrentUser();
        boolean requiresRelogin = false;
    
        // Verificar alterações de dados críticos
        if (!currentUser.getUsername().equals(userDTO.getUsername()) || 
            (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty())) {
            requiresRelogin = true;
        }
    
        // Atualizar dados do usuário
        currentUser.setUsername(userDTO.getUsername());
        currentUser.setEmail(userDTO.getEmail());
        currentUser.setTelefone(userDTO.getTelefone());
        currentUser.setCpf(userDTO.getCpf());
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            currentUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
    
        userRepository.save(currentUser);
        return requiresRelogin;
    }
    

    public User getCurrentUser() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication() != null
                ? SecurityContextHolder.getContext().getAuthentication().getName()
                : null;
    
        if (currentUsername == null) {
            throw new RuntimeException("Nenhum usuário autenticado encontrado.");
        }
    
        System.out.println("Usuário autenticado: " + currentUsername);
    
        return userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new RuntimeException("Usuário atual não encontrado."));
    }
    

    public boolean existsByCpf(String cpf) {
        return userRepository.findByCpf(cpf).isPresent();
    }

    public boolean existsByTelefone(String telefone) {
        return userRepository.findByTelefone(telefone).isPresent();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    public User findByTelefone(String telefone) {
        return userRepository.findByTelefone(telefone)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}

