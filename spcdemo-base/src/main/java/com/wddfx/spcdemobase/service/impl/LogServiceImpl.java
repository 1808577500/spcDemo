package com.wddfx.spcdemobase.service.impl;


import com.wddfx.spcdemocommon.dto.LogDO;
import com.wddfx.spcdemocommon.utils.Query;
import com.wddfx.spcdemobase.dao.LogDao;
import com.wddfx.spcdemobase.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logMapper;

    @Async
    @Override
    public int save(LogDO logDO) {
        return logMapper.save(logDO);
    }

    @Override
    public List<LogDO> queryList(Query query) {
        List<LogDO> logs = logMapper.list(query);
        return logs;
    }

    @Override
    public int count(Query query) {
        return logMapper.count(query);
    }

    @Override
    public int remove(Long id) {
        int count = logMapper.remove(id);
        return count;
    }

    @Override
    public int batchRemove(Long[] ids) {
        return logMapper.batchRemove(ids);
    }
}
