package com.nwafu.catmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mysql.cj.util.StringUtils;
import com.nwafu.catmall.product.dao.AttrAttrgroupRelationDao;
import com.nwafu.catmall.product.dao.AttrGroupDao;
import com.nwafu.catmall.product.dao.CategoryDao;
import com.nwafu.catmall.product.entity.AttrAttrgroupRelationEntity;
import com.nwafu.catmall.product.entity.AttrGroupEntity;
import com.nwafu.catmall.product.entity.CategoryEntity;
import com.nwafu.catmall.product.service.CategoryService;
import com.nwafu.catmall.product.vo.AttrGroupRelationVo;
import com.nwafu.catmall.product.vo.AttrRespVo;
import com.nwafu.catmall.product.vo.AttrVo;
import com.nwafu.common.constant.ProductConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwafu.common.utils.PageUtils;
import com.nwafu.common.utils.Query;

import com.nwafu.catmall.product.dao.AttrDao;
import com.nwafu.catmall.product.entity.AttrEntity;
import com.nwafu.catmall.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {
    @Autowired
    AttrAttrgroupRelationDao relationDao;

    @Autowired
    AttrGroupDao attrGroupDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void saveAttr(AttrVo attr) {
        // 保存基本数据
        AttrEntity entity = new AttrEntity();
        BeanUtils.copyProperties(attr,entity);
        this.save(entity);
        if(attr.getAttrType()== ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()){
            // 保存关联关系
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setAttrGroupId(attr.getAttrGroupId());
            relationEntity.setAttrId(entity.getAttrId());
            relationDao.insert(relationEntity);
        }

    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long categoryId, String type) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<AttrEntity>()
                .eq("attr_type","base".equalsIgnoreCase(type)?ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode():ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode());

        if(categoryId !=0){
            queryWrapper.eq("category_id",categoryId);
        }

        String key = (String) params.get("key");
        if(!StringUtils.isNullOrEmpty(key)){
            queryWrapper.and((wrapper)->{
                wrapper.eq("attr_id",key).or().like("attr_name",key);
            });

        }

        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                queryWrapper
        );

        // 添加catelogName、groupName字段
        List<AttrEntity> records = page.getRecords();
        List<AttrRespVo> data = records.stream().map((attrEntity) -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(attrEntity, attrRespVo);

            AttrAttrgroupRelationEntity relationEntity =
                    relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id",attrEntity.getAttrId()));

            // 设置分类和分组
            if("base".equalsIgnoreCase(type)){
                if (relationEntity != null) {
                    AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(relationEntity.getAttrGroupId());
                    // 注入字段
                    attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
                }
            }


            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
            if (categoryEntity != null) {
                attrRespVo.setCatelogName(categoryEntity.getName());
            }
            return attrRespVo;
        }).collect(Collectors.toList());

        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(data);
        return pageUtils;
    }

    @Override
    public AttrRespVo getAttrInfo(Long attrId) {
        AttrRespVo attrRespVo = new AttrRespVo();
        AttrEntity attrEntity = this.getById(attrId);
        BeanUtils.copyProperties(attrEntity,attrRespVo);

        AttrAttrgroupRelationEntity relationEntity = relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attrEntity.getAttrId()));

        if(attrEntity.getAttrType()==ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()){
            // 设置分组信息
            if(relationEntity!=null){
                attrRespVo.setAttrGroupId(relationEntity.getAttrGroupId());
                AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(relationEntity.getAttrGroupId());
                if(attrGroupEntity!=null){
                    attrRespVo.setAttrName(attrGroupEntity.getAttrGroupName());
                }
            }
        }


        // 设置分类信息
        Long catelogId = attrEntity.getCatelogId();
        Long[] catelogPath = categoryService.findCatelogPath(catelogId);
        attrRespVo.setCatelogPath(catelogPath);
        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        if(categoryEntity!=null){
            attrRespVo.setCatelogName(categoryEntity.getName());
        }
        return attrRespVo;
    }

    @Transactional
    @Override
    public void updateAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);
        // 基本信息修改
        this.updateById(attrEntity);

        if(attrEntity.getAttrType()==ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()){
            // 关联信息修改
            AttrAttrgroupRelationEntity  relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setAttrId(attr.getAttrId());
            relationEntity.setAttrGroupId(attr.getAttrGroupId());
            Long num = relationDao.selectCount(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attr.getAttrId()));

            if(num>0){
                // 修改操作
                relationDao.update(relationEntity,new UpdateWrapper<AttrAttrgroupRelationEntity>().eq("attr_id",attr.getAttrId()));
            }else{
                // 新增操作
                relationDao.insert(relationEntity);
            }
        }




    }

    /**
     * 根据分组id查找所有关联的属性
     */
    @Override
    public List<AttrEntity> getRelationAttr(Long attrgroupId) {
        List<AttrAttrgroupRelationEntity> relationEntities = relationDao.selectList(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id", attrgroupId));
        List<Long> attrIds = relationEntities.stream().map(AttrAttrgroupRelationEntity::getAttrId).collect(Collectors.toList());
        if(attrIds==null || attrIds.isEmpty()){
            return null;
        }
        List<AttrEntity> attrEntities = this.listByIds(attrIds);
        return attrEntities;
    }

    @Override
    public void deleteRelation(AttrGroupRelationVo[] vos) {
        List<AttrAttrgroupRelationEntity> entities = Arrays.asList(vos).stream().map((item) -> {
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            BeanUtils.copyProperties(item, relationEntity);
            return relationEntity;
        }).collect(Collectors.toList());
        relationDao.deleteBatchRelation(entities);
        //relationDao.delete(new QueryWrapper<>().eq("attr_id",vo.).eq("attr_group_id",vo.));

    }

    /**
     * 获取当前分组没有关联的所有属性
     */
    @Override
    public PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId) {
        // 当前分组只能关联自己所属的分类里面的所有属性
        AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrgroupId);
        Long catelogId = attrGroupEntity.getCatelogId();

        // 当前分组只能关联别的分组没有引用的属性

        // 找到当前分类下的其他分组
        List<AttrGroupEntity> attrGroup = attrGroupDao.selectList(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));
        List<Long> collect = attrGroup.stream().map(AttrGroupEntity::getAttrGroupId).collect(Collectors.toList());
        // 找到其他分组的属性
        List<AttrAttrgroupRelationEntity> elsAttrGroupRelation = relationDao.selectList(new QueryWrapper<AttrAttrgroupRelationEntity>().in("attr_group_id", collect));
        List<Long> attrIds = elsAttrGroupRelation.stream().map(AttrAttrgroupRelationEntity::getAttrId).collect(Collectors.toList());
        // 剔除这部分属性
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<AttrEntity>().eq("catelog_id", catelogId).eq("attr_type",ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode());
        if(attrIds!=null && !attrIds.isEmpty()){
            queryWrapper.notIn("attr_id", attrIds);
        }

        String key = (String) params.get("key");

        if(StringUtils.isNullOrEmpty(key)){
            // 模糊查询
            queryWrapper.and((w)->{
                w.eq("attr_id",key).or().like("attr_name",key);
            });
        }
        IPage<AttrEntity> page = this.page(new Query<AttrEntity>().getPage(params), queryWrapper);
        return new PageUtils(page);
    }

}