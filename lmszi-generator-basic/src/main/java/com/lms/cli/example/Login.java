package com.lms.cli.example;

import cn.hutool.log.Log;
import picocli.CommandLine;

import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {


    /**
     * arity指定输入参数的值个数
     * interactive设置是否可以交互
     */
    @CommandLine.Option(names = {"-u","--user"},description = "username")
    private String username;

    @CommandLine.Option(names = {"-p","--password"},arity = "0..1",description = "password",interactive = true)
    private String password;


    @CommandLine.Option(names = {"-cp","--checkPassword"},arity = "0..1",description = "Check Password",interactive = true)
    private String checkPassword;


    @Override
    public Integer call() throws Exception {
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("checkpassword:"+checkPassword);
        return 0;
    }

    public static void main(String[] args) {
       new CommandLine(new Login()).execute("-u","uisss123","-p","xxx","-cp");
    }
}
