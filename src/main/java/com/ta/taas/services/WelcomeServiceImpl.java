package com.ta.taas.services;

import com.ta.taas.beans.ClientType;
import com.ta.taas.beans.User;
import com.ta.taas.exceptions.SecMsg;
import com.ta.taas.exceptions.TaskSecurityException;
import com.ta.taas.repos.UserRepository;
import com.ta.taas.security.TokenManger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WelcomeServiceImpl implements WelcomeService{
    private final UserRepository userRepository;
    private final TokenManger tokenManger;

    @Override
    public void register(String email, String password) throws TaskSecurityException {
        User user = User.builder()
                .email(email)
                .password(password)
                .type(ClientType.USER)
                .build();
        if (userRepository.existsByEmail(email)){
            throw new TaskSecurityException(SecMsg.EMAIL_ALREADY_EXIST);
        }
        userRepository.save(user);
    }

    @Override
    public UUID login(String email, String password) throws TaskSecurityException {
        if (!userRepository.existsByEmailAndPassword(email, password)){
            throw new TaskSecurityException(SecMsg.EMAIL_OR_PASSWORD_INCORRECT);
        }
        return tokenManger.add(email, password);
    }
}
