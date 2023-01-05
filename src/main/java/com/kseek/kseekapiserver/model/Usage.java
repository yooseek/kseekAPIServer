package com.kseek.kseekapiserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usage {
    final int prompt_tokens;
    final int generated_tokens;
    final int total_tokens;
}
