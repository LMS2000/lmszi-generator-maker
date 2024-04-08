package com.lms;

import cn.hutool.core.io.FileUtil;
import com.lms.cli.CommandExcutor;
import picocli.CommandLine;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        args=new String[]{"generate","-l","-a","-o"};
        CommandExcutor commandExcutor=new CommandExcutor();
        commandExcutor.doExecute(args);
    }

}