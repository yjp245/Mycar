/**
 * Author:   JP
 * Date:     2018/12/2 0002 12:44
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.service.impl;

import cn.mycar.mapper.NoticeMapper;
import cn.mycar.pojo.Notice;
import cn.mycar.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author JP
 * @create 2018/12/2 0002
 * @since 1.0.0
 */

@Service
public class NoticeServiceImpl implements NoticeService {
@Autowired
    NoticeMapper mapper;

    @Override
    public int add(Notice notice) {
        return mapper.add(notice);
    }

    @Override
    public int delete(int nid) {
        return mapper.delete(nid);
    }

    @Override
    public int update(Notice project) {
        return mapper.update(project);
    }

    @Override
    public Notice select(int nid) {
        return mapper.select(nid);
    }

    @Override
    public List<HashMap> list() {
        return mapper.list();
    }
}
