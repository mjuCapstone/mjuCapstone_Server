package com.mju.capstone.recommend.repository;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.mju.capstone.recommend.domain.GptManager;
import com.mju.capstone.recommend.dto.response.RecommendResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class GptManagerImpl implements GptManager {

  private final RestTemplate restTemplate;

  public GptManagerImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public RecommendResponse sendOpenAIRequest(String request) {
    String url = "http://localhost:8000/api/v1/recommend/chat";

    Map<String, String> requestBody = new HashMap<>();
    requestBody.put("content", request);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(APPLICATION_JSON);

    HttpEntity<Map<String,String>> requestHttpEntity = new HttpEntity<>(requestBody,headers);
    return restTemplate.postForObject(url, requestHttpEntity, RecommendResponse.class);
  }
}