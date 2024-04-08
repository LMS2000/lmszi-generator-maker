package com.lms;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lms.maker.meta.Meta;
import com.lms.maker.template.TemplateMaker;
import com.lms.maker.template.model.TemplateMakerConfig;
import org.junit.jupiter.api.Test;

import java.io.File;

public class MainTest {



    @Test
    public void test(){
        String rootPath = "examples/springboot-init";

        String configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker233.json");
        TemplateMakerConfig templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        Meta meta= TemplateMaker.makeTemplate(templateMakerConfig);

        System.out.println(JSONUtil.toJsonStr(meta));



//        String configStr2 = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker2.json");
//        TemplateMakerConfig templateMakerConfig2 = JSONUtil.toBean(configStr2 , TemplateMakerConfig.class);
//        TemplateMaker.makeTemplate(templateMakerConfig2);
//
//        String configStr3 = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker3.json");
//        TemplateMakerConfig templateMakerConfig3 = JSONUtil.toBean(configStr3 , TemplateMakerConfig.class);
//        TemplateMaker.makeTemplate(templateMakerConfig3);
    }
}
