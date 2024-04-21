package com.nwafu.catmall.search;

import com.nwafu.catmall.search.config.CatmallElasticSearchConfig;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CatmallSearchApplicationTests {

	@Autowired
	private RestHighLevelClient client;

	@Test
	public void contextLoads() {
		System.out.println(client);
	}

	@Test
	public void indexData() throws IOException {
		IndexRequest indexRequest = new IndexRequest("users");
		indexRequest.id("1");
		indexRequest.source("username","zhangsan","age",18,"gender","男");
		IndexResponse index = client.index(indexRequest, CatmallElasticSearchConfig.COMMON_OPTIONS);

		System.out.println(index);
	}

}
