/**
 * Author:   JP
 * Date:     2018/10/10 0010 12:44
 * Description: 用户反馈信息类
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.pojo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户反馈信息类〉
 *
 * @author JP
 * @create 2018/10/10 0010
 * @since 1.0.0
 */

public class Feedback {

    int id;

    private String probelm;

    private String phone;

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", probelm='" + probelm + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Feedback() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProbelm() {
        return probelm;
    }

    public void setProbelm(String probelm) {
        this.probelm = probelm;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
