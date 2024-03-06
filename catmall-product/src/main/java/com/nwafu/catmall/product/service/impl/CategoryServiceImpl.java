package com.nwafu.catmall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwafu.common.utils.PageUtils;
import com.nwafu.common.utils.Query;

import com.nwafu.catmall.product.dao.CategoryDao;
import com.nwafu.catmall.product.entity.CategoryEntity;
import com.nwafu.catmall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        // 组装成父子树形结构

        // 找到一级分类
        List<CategoryEntity> level1Menus = entities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map((menu)->{menu.setChildren(null); return menu;})
                .sorted((menu1,menu2)->{return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());})
                .collect(Collectors.toList());
        return entities;
    }

    // 递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
                    return categoryEntity.getParentCid() == root.getCatId();
                })
                .map(categoryEntity -> {
                    categoryEntity.setChildren(getChildrens(categoryEntity,all));
                    return categoryEntity;})
                .sorted((menu1,menu2)->{return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());})
                .collect(Collectors.toList());
        return children;
    }

}