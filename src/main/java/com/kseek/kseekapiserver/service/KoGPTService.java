package com.kseek.kseekapiserver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kseek.kseekapiserver.model.KaKaoRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

@Service
public class KoGPTService {
    public String getData(String url) throws JsonProcessingException {
        //Spring restTemplate
        HashMap<String, Object> result = new HashMap<String, Object>();
        String jsonInString = "";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type","application/json");
        header.add("Authorization","KakaoAK "+ "5fff155627d9841a44bcd6579ea959d2");

        final KaKaoRequest requestBody = new KaKaoRequest(
                "정보:거주지 서울, 나이 30대, 성별 남자, 미혼, 전공 외국어, 말투 사나움 정보를 바탕으로 질문에 답하세요\\nQ:안녕하세요 반갑습니다. 자기소개 부탁드려도 될까요?\\nA:안녕하세요. 저는 서울에 거주하고 있는 30대 남성입니다.\\nQ:오 그렇군요, 이번 인터뷰의 목적은 무엇인가요?",
                516,
                0.3,
                0.85,
                1
        );

        HttpEntity<KaKaoRequest> entity = new HttpEntity<>(requestBody,header);

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        ResponseEntity<?> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.POST, entity, Object.class);

        result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
        result.put("header", resultMap.getHeaders()); //헤더 정보 확인
        result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

        //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
        ObjectMapper mapper = new ObjectMapper();
        jsonInString = mapper.writeValueAsString(resultMap.getBody());

        return jsonInString;
    }
}
