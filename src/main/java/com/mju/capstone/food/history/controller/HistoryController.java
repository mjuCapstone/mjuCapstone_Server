package com.mju.capstone.food.history.controller;

import com.mju.capstone.food.history.service.HistoryService;
import com.mju.capstone.global.response.ControllerMessage;
import com.mju.capstone.global.response.message.SuccessMessage;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "History", description = "사용자 음식 섭취 기록 관리 (History) 관련")
public class HistoryController {

  private final HistoryService historyService;

  @GetMapping("/history")
  public ResponseEntity<ControllerMessage<?>> getHistory(){
    return ResponseEntity.status(HttpStatus.OK)
        .body(ControllerMessage.of(SuccessMessage.OK,historyService.findRecentHistory()));
  }
}
