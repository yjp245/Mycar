package cn.mycar.service;

import cn.mycar.pojo.Category;
import cn.mycar.util.Page;

import java.util.List;

public interface CategoryService {
    public void add(Category  category);
    public void delete(int id);
    public void update(Category category);
    public Category get(int id);
    public List<Category> list();
   /* public List<Category> list(Page page);*//*去掉该方法*/
    public int count();
}
