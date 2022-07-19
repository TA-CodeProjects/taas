package com.ta.taas.security;

import com.ta.taas.beans.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    private int userId;
    private ClientType type;
    private LocalDateTime time;
    private String email;
}
