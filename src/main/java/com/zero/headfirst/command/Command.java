package com.zero.headfirst.command;

/**
 * 命令(Command)角色
 */
public interface Command {
    /**
     * 命令执行
     */
    void execute();

    /**
     * 命令撤销
     */
    void undo();
}
