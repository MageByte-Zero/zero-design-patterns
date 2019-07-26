package com.zero.headfirst.command.impl;

import com.zero.headfirst.command.Command;

/**
 * 空指令，因为有的插槽可能是空的。
 */
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
