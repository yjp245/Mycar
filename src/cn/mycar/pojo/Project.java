/**
 * Author:   JP
 * Date:     2018/12/1 0001 14:54
 * Description: 产品介绍
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.mycar.pojo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈产品介绍〉
 *
 * @author JP
 * @create 2018/12/1 0001
 * @since 1.0.0
 */

public class Project {

    private int pid;

    private String title;

    private String content;

    public Project(int pid, String title, String content) {
        this.pid = pid;
        this.title = title;
        this.content = content;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Project() {
        super();
    }

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
