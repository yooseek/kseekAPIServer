package com.kseek.kseekapiserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class KakaoResponse {
    private String id;
    private List<Generation> generations;
    private Usage usage;
}
