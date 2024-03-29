package com.wddfx.spcdemocommon.intercepter;

import com.wddfx.spcdemocommon.constants.CommonConstants;
import com.wddfx.spcdemocommon.context.FilterContextHandler;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeignIntercepter implements RequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        logger.info("------feign设置token" + Thread.currentThread().getId());
        requestTemplate.header(CommonConstants.CONTEXT_TOKEN, FilterContextHandler.getToken());
    }
}