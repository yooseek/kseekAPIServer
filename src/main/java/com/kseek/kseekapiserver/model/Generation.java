package com.kseek.kseekapiserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Generation {
    final String text;
    final int tokens;
}
