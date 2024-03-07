package com.nwafu.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class CatmallThirdPartyApplicationTests {

    @Autowired
    OSSClient ossClient;
    @Test
    void contextLoads() throws com.aliyuncs.exceptions.ClientException, FileNotFoundException {

        // 填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
        String objectName = "C:\\Users\\61031\\Desktop\\Java基础.md";

        InputStream inputStream = new FileInputStream(objectName);
        ossClient.putObject("catmall-hello","Java基础.md",inputStream);
        ossClient.shutdown();
    }

}
