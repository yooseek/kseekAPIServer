package com.kseek.kseekapiserver.model;

import lombok.Data;

@Data
public class KaKaoRequest {
    private String prompt;
    private int max_tokens;
    private double temperature;
    private double top_p;
    private int n;

    public KaKaoRequest(String prompt, int max_tokens, double temperature, double top_p, int n) {
        this.prompt = prompt;
        this.max_tokens = max_tokens;
        this.temperature = temperature;
        this.top_p = top_p;
        this.n = n;
    }
}
