package com.ta.taas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskPayloadDto {
    @NotBlank
    private String caption;
    @NotBlank
    private String info;
    @NotBlank
    private String classification;

//    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dueDate;
}
