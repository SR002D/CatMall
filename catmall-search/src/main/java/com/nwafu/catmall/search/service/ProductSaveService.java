package com.nwafu.catmall.search.service;

import com.nwafu.catmall.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;


public interface ProductSaveService {

    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
