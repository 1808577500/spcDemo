package com.wddfx.spcdemozuul.prc.admin;

import com.wddfx.spcdemocommon.dto.MenuDTO;
import com.wddfx.spcdemocommon.intercepter.FeignIntercepter;
import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Headers("Content-Type:application/json")
@FeignClient(name = "api-admin", configuration = FeignIntercepter.class)
public interface MenuService {
    @GetMapping("/menu/userMenus")
    List<MenuDTO> userMenus();
}
