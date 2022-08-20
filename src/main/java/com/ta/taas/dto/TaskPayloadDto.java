package com.ta.taas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private boolean done;
    @NotBlank
    private LocalDateTime dueDate;
}
