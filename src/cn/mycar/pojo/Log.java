/**
 * Author:   JP
 * Date:     2018/11/24 0024 21:26
 * Description: 操作记录
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.pojo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈操作记录表〉
 *
 * @author JP
 * @create 2018/11/24 0024
 * @since 1.0.0
 */

public class Log {

    private int logid;

    private String user;


    private String role;

    private String content;


    private String time;

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logid=" + logid +
                ", user='" + user + '\'' +
                ", role='" + role + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
