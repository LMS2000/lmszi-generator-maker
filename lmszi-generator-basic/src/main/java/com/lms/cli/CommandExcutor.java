package com.lms.cli;

import com.lms.cli.command.ConfigCommand;
import com.lms.cli.command.GenerateComand;
import com.lms.cli.command.ListCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "lmszi",mixinStandardHelpOptions = true)
public class CommandExcutor implements Runnable{


    private final CommandLine commandLine;


    {
        commandLine=new CommandLine(this);
        commandLine.addSubcommand(GenerateComand.class)
                .addSubcommand(ConfigCommand.class)
                .addSubcommand(ListCommand.class);

    }


    @Override
    public void run() {
        // 不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    /**
     * 执行命令
     * @param args
     * @return
     */
    public Integer doExecute(String[] args){
        return commandLine.execute(args);
    }

}
