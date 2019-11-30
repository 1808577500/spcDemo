package com.wddfx.spcdemobase.service;


import com.wddfx.spcdemocommon.dto.LogDO;
import com.wddfx.spcdemocommon.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface LogService {
    int save(LogDO logDO);

    List<LogDO> queryList(Query query);

    int count(Query query);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
