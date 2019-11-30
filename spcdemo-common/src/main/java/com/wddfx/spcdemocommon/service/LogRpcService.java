package com.wddfx.spcdemocommon.service;

import com.wddfx.spcdemocommon.dto.LogDO;
import com.wddfx.spcdemocommon.intercepter.FeignIntercepter;
import com.wddfx.spcdemocommon.utils.R;
import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;

@Headers("Content-Type:application/json")
@FeignClient(name = "api-base", configuration = FeignIntercepter.class)
public interface LogRpcService {
    @Async
    @PostMapping("log/save")
    R save(LogDO logDO);
}
