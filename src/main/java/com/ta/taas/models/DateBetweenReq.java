package com.ta.taas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateBetweenReq {
    private Timestamp start;
    private Timestamp end;
}
