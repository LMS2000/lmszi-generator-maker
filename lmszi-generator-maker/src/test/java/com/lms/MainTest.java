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

        String configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker.json");
        TemplateMakerConfig templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        Meta meta= TemplateMaker.makeTemplate(templateMakerConfig);

        System.out.println(JSONUtil.toJsonStr(meta));

        String configStr2 = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker1.json");
        TemplateMakerConfig templateMakerConfig2 = JSONUtil.toBean(configStr2 , TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig2);

        String configStr3 = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker2.json");
        TemplateMakerConfig templateMakerConfig3 = JSONUtil.toBean(configStr3 , TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig3);

        String configStr4 = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker3.json");
        TemplateMakerConfig templateMakerConfig4 = JSONUtil.toBean(configStr4 , TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig4);

        String configStr5 = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker4.json");
        TemplateMakerConfig templateMakerConfig5 = JSONUtil.toBean(configStr5 , TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig5);

        String configStr6 = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker5.json");
        TemplateMakerConfig templateMakerConfig6 = JSONUtil.toBean(configStr6 , TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig6);

        String configStr7 = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker6.json");
        TemplateMakerConfig templateMakerConfig7 = JSONUtil.toBean(configStr7 , TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig7);

        String configStr8 = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker7.json");
        TemplateMakerConfig templateMakerConfig8 = JSONUtil.toBean(configStr8 , TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig8);

        String configStr9 = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker8.json");
        TemplateMakerConfig templateMakerConfig9 = JSONUtil.toBean(configStr9 , TemplateMakerConfig.class);
        TemplateMaker.makeTemplate(templateMakerConfig9);
    }

    
}
