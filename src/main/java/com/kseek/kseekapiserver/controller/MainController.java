package com.kseek.kseekapiserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kseek.kseekapiserver.model.KakaoResponse;
import com.kseek.kseekapiserver.service.KoGPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MainController {

    @Autowired
    private final KoGPTService koGPTService;

    @GetMapping("/hi")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/kakao/{prompt}")
    public ResponseEntity<String> kakao(@PathVariable String prompt) throws JsonProcessingException {
        String jsonResult = koGPTService.getData("https://api.kakaobrain.com/v1/inference/kogpt/generation");

        return ResponseEntity.ok(jsonResult);
    }
}
