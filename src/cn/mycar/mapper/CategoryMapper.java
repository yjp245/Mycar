package cn.mycar.mapper;

import cn.mycar.pojo.Category;
import cn.mycar.util.Page;

import java.util.List;

public interface CategoryMapper {
    public void add(Category  category);
    public void delete(int id);
    public void update(Category category);
    public Category get(int id);

    public List<Category> list();
   /* public List<Category> list(Page page);*/
    public int count();
}
