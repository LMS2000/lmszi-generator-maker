package com.lms.maker.generator;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
public class ScriptGenerator {

    public static void doGenerate(String shellOutputPath, String jarPath) throws IOException {
        // 直接写入脚本
        // windows：craft.bat
        StringBuilder scriptBuilder = new StringBuilder();
        scriptBuilder.append("@echo off\n");
        scriptBuilder.append(String.format("java -jar %s %%*", jarPath)).append("\n");
        FileUtil.writeBytes(scriptBuilder.toString().getBytes(), shellOutputPath + ".bat");

        // other: craft
        scriptBuilder = new StringBuilder();
        scriptBuilder.append("#!/bin/bash\n");
        scriptBuilder.append(String.format("java -jar %s \"$@\"", jarPath)).append("\n");
        FileUtil.writeBytes(scriptBuilder.toString().getBytes(), shellOutputPath);
        try {
            PosixFileAttributeView attributeView = Files.getFileAttributeView(Paths.get(shellOutputPath), PosixFileAttributeView.class);
            // 赋予执行权限
            if (attributeView != null) {
                // 设置文件权限
                Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwxrwx");
                attributeView.setPermissions(permissions);
                System.out.println("文件权限设置成功");
            } else {
                System.out.println("文件权限设置失败：文件系统不支持 POSIX 文件权限");
            }
        } catch (IOException ignored) {

        }
    }

    public static void main(String[] args) throws IOException {
        String outputPath = System.getProperty("user.dir") + File.separator + "generator";
        doGenerate(outputPath, "");
    }
}