package com.nwafu.catmall.product.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.nwafu.catmall.product.dao.CategoryDao;
import com.nwafu.catmall.product.entity.CategoryEntity;
import com.nwafu.catmall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

}