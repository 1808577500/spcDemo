package com.wddfx.spcdemocommon.intercepter;

import com.wddfx.spcdemocommon.constants.CommonConstants;
import com.wddfx.spcdemocommon.context.FilterContextHandler;
import com.wddfx.spcdemocommon.dto.UserToken;
import com.wddfx.spcdemocommon.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthIntercepter extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(HandlerInterceptorAdapter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(CommonConstants.CONTEXT_TOKEN);
        UserToken userToken = JwtUtils.getInfoFromToken(token);
        FilterContextHandler.setToken(token);
        logger.info("------设置token"+Thread.currentThread().getId());
        FilterContextHandler.setUsername(userToken.getUsername());
        FilterContextHandler.setName(userToken.getName());
        FilterContextHandler.setUserID(userToken.getUserId());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        FilterContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
