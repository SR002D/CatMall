package com.nwafu.catmall.product.service.impl;

import com.mysql.cj.util.StringUtils;
import com.nwafu.catmall.product.entity.AttrEntity;
import com.nwafu.catmall.product.service.AttrService;
import com.nwafu.catmall.product.vo.AttrGroupWithAttrsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwafu.common.utils.PageUtils;
import com.nwafu.common.utils.Query;

import com.nwafu.catmall.product.dao.AttrGroupDao;
import com.nwafu.catmall.product.entity.AttrGroupEntity;
import com.nwafu.catmall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    AttrService attrService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        // 按三级分类查
        String key = (String) params.get("key");
        QueryWrapper<AttrGroupEntity> queryWrapper = new QueryWrapper<AttrGroupEntity>();
        if(!StringUtils.isNullOrEmpty(key)){
            queryWrapper.and((obj)->{
                obj.eq("attr_group_id",key).or().like("attr_group_name",key);
            });
        }
        if (catelogId == 0) {
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    queryWrapper);
            return new PageUtils(page);
        }else{
            queryWrapper.eq("catelog_Id",catelogId);
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    queryWrapper);
            return new PageUtils(page);
        }
    }

    /**
     * 根据分类id查出所有分组以及这些分组的属性
     */
    @Override
    public List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
        // 查询分组信息
        List<AttrGroupEntity> attrGroup = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));
        // 查询所有属性
        List<AttrGroupWithAttrsVo> vos = attrGroup.stream().map((group) -> {
            AttrGroupWithAttrsVo vo = new AttrGroupWithAttrsVo();
            BeanUtils.copyProperties(group,vo);
            List<AttrEntity> attrs = attrService.getRelationAttr(vo.getAttrGroupId());
            vo.setAttrs(attrs);
            return vo;
        }).collect(Collectors.toList());
        return vos;
    }


}