package com.lms.generate;

import cn.hutool.core.io.FileUtil;

public class StaticGenerator {


    public static  void copeFilesByHuTool(String inputPath,String ouputPath){
        FileUtil.copy(inputPath,ouputPath,true);
    }
}


