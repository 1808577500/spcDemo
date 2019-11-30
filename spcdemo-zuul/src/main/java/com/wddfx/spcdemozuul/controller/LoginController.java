package com.wddfx.spcdemozuul.controller;

import com.wddfx.spcdemocommon.constants.CommonConstants;
import com.wddfx.spcdemocommon.context.FilterContextHandler;
import com.wddfx.spcdemocommon.dto.MenuDTO;
import com.wddfx.spcdemozuul.prc.admin.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @version V1.0
 */
@RestController
public class LoginController {
    @Autowired
    MenuService menuService;
    @GetMapping({"/test"})
    List<MenuDTO> login(HttpServletRequest request)  {
        FilterContextHandler.setToken(request.getHeader(CommonConstants.CONTEXT_TOKEN));
        return menuService.userMenus();
    }
}
