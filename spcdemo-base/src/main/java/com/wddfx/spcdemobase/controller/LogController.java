package com.wddfx.spcdemobase.controller;


import com.wddfx.spcdemocommon.dto.LogDO;
import com.wddfx.spcdemocommon.utils.PageUtils;
import com.wddfx.spcdemocommon.utils.Query;
import com.wddfx.spcdemocommon.utils.R;
import com.wddfx.spcdemobase.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/log")
@RestController
public class LogController {
    @Autowired
    LogService logService;

    @GetMapping()
    R list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        return R.page(new PageUtils(logService.queryList(query), logService.count(query)));
    }

    @PostMapping("/save")
    R save(@RequestBody LogDO logDO) {
        if (logService.save(logDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @DeleteMapping()
    R remove(Long id) {
        if (logService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/batchRemove")
    R batchRemove(@RequestParam("ids[]") Long[] ids) {
        int r = logService.batchRemove(ids);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }
}
