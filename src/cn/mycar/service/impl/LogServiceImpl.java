/**
 * Author:   JP
 * Date:     2018/11/24 0024 21:58
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.service.impl;

import cn.mycar.mapper.LogMapper;
import cn.mycar.pojo.Log;
import cn.mycar.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author JP
 * @create 2018/11/24 0024
 * @since 1.0.0
 */

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public void add(Log log) {
      logMapper.add(log);
    }

    @Override
    public void delete(int logid) {
        logMapper.delete(logid);
    }

    @Override
    public List<Log> list() {
        return logMapper.list();
    }

    @Override
    public List<Log> listbyrole(String role) {
        return logMapper.listbyrole(role);
    }

    @Override
    public List<Log> listbyuser(String user) {
        return logMapper.listbyuser(user);
    }
}
