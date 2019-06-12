/**
 * Author:   JP
 * Date:     2018/10/10 0010 12:56
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.service;

import cn.mycar.pojo.Feedback;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author JP
 * @create 2018/10/10 0010
 * @since 1.0.0
 */

public interface FeedBackService {

    public void add(Feedback feedback);

    public List<Feedback> list();
}
