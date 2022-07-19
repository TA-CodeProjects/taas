package com.ta.taas.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    @Min(0)
    private int id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String type;

    @Singular
    private List<TaskDto> tasks = new ArrayList<>();
}
