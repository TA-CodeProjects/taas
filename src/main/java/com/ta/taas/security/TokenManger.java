package com.ta.taas.security;

import com.ta.taas.beans.User;
import com.ta.taas.exceptions.SecMsg;
import com.ta.taas.exceptions.TaskSecurityException;
import com.ta.taas.exceptions.TaskSystemException;
import com.ta.taas.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenManger {

    private final Map<UUID, Information> map;
    private final UserRepository userRepository;

    public UUID add(String email, String password){
        User fromDb = userRepository.findTop1ByEmail(email);
        int userId = fromDb.getId();
        removePreviousInstances(userId);
        Information information = new Information();
        information.setUserId(userId);
        information.setEmail(email);
        information.setType(fromDb.getType());
        information.setTime(LocalDateTime.now());

        UUID token = UUID.randomUUID();
        map.put(token, information);
        return token;
    }

    public int getUserId(UUID token) throws TaskSecurityException {
        Information information = map.get(token);
        if (information == null){
            throw new TaskSecurityException(SecMsg.INVALID_TOKEN);
        }
        return information.getUserId();
    }

    public String getEmail(UUID token) throws TaskSecurityException {
        Information information = map.get(token);
        if (information == null){
            throw new TaskSecurityException(SecMsg.INVALID_TOKEN);
        }
        return information.getEmail();
    }


    @Scheduled(fixedRate = 1000 * 60)
    public void deleteExpiredTokenOver30Minutes(){
        map.entrySet().removeIf(ins -> ins.getValue().getTime().isAfter(LocalDateTime.now().minusMinutes(30)));
    }

    public void removePreviousInstances(int userId) {
        map.entrySet().removeIf(ins -> ins.getValue().getUserId() == userId);
    }
}
