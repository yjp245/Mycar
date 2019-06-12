/**
 * Author:   JP
 * Date:     2018/10/10 0010 12:56
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.service.impl;

import cn.mycar.mapper.FeedBackMapper;
import cn.mycar.pojo.Feedback;
import cn.mycar.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author JP
 * @create 2018/10/10 0010
 * @since 1.0.0
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    FeedBackMapper feedBackMapper;

    @Override
    public void add(Feedback feedback) {
          feedBackMapper.add(feedback);
    }

    @Override
    public List<Feedback> list() {
        return feedBackMapper.list();
    }
}
