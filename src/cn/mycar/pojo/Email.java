/**
 * Author:   JP
 * Date:     2018/11/13 0013 21:41
 * Description: 邮件发送相关信息
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.pojo;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈邮件发送相关信息〉
 *
 * @author JP
 * @create 2018/11/13 0013
 * @since 1.0.0
 */

public class Email implements Serializable {

    //接收地址
    private String receiveaddress;

    //邮箱验证码
    private String smskey;

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
    }

    public String getSmskey() {
        return smskey;
    }

    public void setSmskey(String smskey) {
        this.smskey = smskey;
    }

    @Override
    public String toString() {
        return "Email{" +
                "receiveaddress='" + receiveaddress + '\'' +
                ", smskey='" + smskey + '\'' +
                '}';
    }
}
