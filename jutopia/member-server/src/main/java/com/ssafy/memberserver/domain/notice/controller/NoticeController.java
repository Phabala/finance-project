package com.ssafy.memberserver.domain.notice.controller;

import com.ssafy.memberserver.common.api.ApiResponse;
import com.ssafy.memberserver.domain.notice.dto.request.NoticeDeleteRequest;
import com.ssafy.memberserver.domain.notice.dto.request.NoticeRequest;
import com.ssafy.memberserver.domain.notice.dto.request.NoticeUpdateRequest;
import com.ssafy.memberserver.domain.notice.service.NoticeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notice")
public class NoticeController {
    private final NoticeService noticeService;

    //TODO: 예외처리 및 코멘트 기능 구현
    @Operation(summary = "공지사항 상세 조회")
    @GetMapping("/{id}")
    public ApiResponse getNotice(@PathVariable Long id){
        return ApiResponse.success(noticeService.getNotice(id));
    }
    @Operation(summary = "공지사항 리스트 조회")
    @GetMapping
    public ApiResponse getNotices(){
        return ApiResponse.success(noticeService.getNotices());
    }
    @Operation(summary = "공지사항 작성")
    @PostMapping
    public ApiResponse noticeWrite(@RequestBody  NoticeRequest noticeRequest){
        return ApiResponse.success(noticeService.noticeWrite(noticeRequest));
    }
    @Operation(summary = "공지사항 수정")
    @PutMapping
    public ApiResponse noticeUpdate(@RequestBody NoticeUpdateRequest noticeUpdateRequest, Long id){
        return ApiResponse.success(noticeService.noticeUpdate(noticeUpdateRequest,id));
    }
    @Operation(summary = "공지사항 삭제")
    @DeleteMapping
    public ApiResponse noticeDelete(@RequestBody NoticeDeleteRequest noticeDeleteRequest, Long id){
        return ApiResponse.success(noticeService.noticeDelete(noticeDeleteRequest, id));
    }
}
