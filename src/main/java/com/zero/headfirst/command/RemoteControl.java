package com.zero.headfirst.command;

import com.zero.headfirst.command.impl.NoCommand;

import java.util.Arrays;

/**
 * 调用者：遥控器
 */
public class RemoteControl {
    /**
     * 一共4个家电插槽，每个插槽有 开与关命令。
     */
    private Command[] onCommands;
    private Command[] offCommands;

    //用来保存前一个命令，用来实现撤销功能
    private Command undoCommand;

    /**
     * 通过构造器初始化开关数组
     */
    public RemoteControl() {
        onCommands = new Command[4];
        offCommands = new Command[4];
        //初始化所有插槽为空指令
        Command noCommand = new NoCommand();
        for (int i = 0; i < 4; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        //一开始没有所谓的前一个命令，所以默认无指令
        undoCommand = noCommand;
    }

    /**
     * 设置指定插槽对应的按钮指令
     * @param slot 插槽位置
     * @param onCommand 开指令
     * @param offCaommand 关指令
     */
    public void setCommand(int slot,Command onCommand, Command offCaommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCaommand;
    }

    /**
     * 模拟按下指定插槽对应的【开】按键
     */
    public void pressOnButton(int slot) {
        onCommands[slot].execute();
        //将当前指令记录下来，用于在撤销的时候能执行命令对应的 undo 方法从而实现撤销功能
        undoCommand = onCommands[slot];
    }

    /**
     * 模拟按下指定插槽对应的【关】按键
     */
    public void pressOffButton(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    /**
     * 撤销功能
     */
    public void pressUndoButton() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        return "RemoteControl{" +
                "onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }
}
