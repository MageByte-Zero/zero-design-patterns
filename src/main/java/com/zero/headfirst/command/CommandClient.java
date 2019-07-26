package com.zero.headfirst.command;

import com.zero.headfirst.command.impl.*;
import com.zero.headfirst.command.receiver.AirConditioning;
import com.zero.headfirst.command.receiver.Light;
import com.zero.headfirst.command.receiver.Stereo;
import com.zero.headfirst.command.receiver.TV;

/**
 * 客户端角色
 */
public class CommandClient {
    public static void main(String[] args) {
        //创建一个遥控器-调用者角色
        RemoteControl remoteControl = new RemoteControl();
        //1. 创建电灯-接受者角色
        Light light = new Light();
        //创建开灯、关灯命令-命令具体角色
        LightOnCommand lightOnCommand = new LightOnCommand();
        lightOnCommand.setLight(light);
        LightOffCommand lightOffCommand = new LightOffCommand();
        lightOffCommand.setLight(light);

        //调用者设置电灯插槽以及对应的开关按键指令-调用者角色
        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);

        // 2. 设置音响插槽与对应按键指令
        Stereo stereo = new Stereo();
        StereoOnCommand stereoOnCommand = new StereoOnCommand();
        stereoOnCommand.setStereo(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand();
        stereoOffCommand.setStereo(stereo);

        remoteControl.setCommand(1, stereoOnCommand, stereoOffCommand);

        //3. 空调
        AirConditioning airConditioning = new AirConditioning();
        AirConditioningOnCommand airConditioningOnCommand = new AirConditioningOnCommand();
        airConditioningOnCommand.setAirConditioning(airConditioning);
        AirConditioningOffCommand airConditioningOffCommand = new AirConditioningOffCommand();
        airConditioningOffCommand.setAirConditioning(airConditioning);

        remoteControl.setCommand(2, airConditioningOnCommand, airConditioningOffCommand);

        //4. 电视
        TV tv = new TV();
        TVOnCommand tvOnCommand = new TVOnCommand();
        tvOnCommand.setTv(tv);
        TVOffCommand tvOffCommand = new TVOffCommand();
        tvOffCommand.setTv(tv);

        remoteControl.setCommand(3, tvOnCommand, tvOffCommand);

        //模拟按键
        System.out.println("-------码农回家了，使用遥控开启电灯、音响、空调、电视----");
        remoteControl.pressOnButton(0);
        remoteControl.pressOnButton(1);
        remoteControl.pressOnButton(2);
        remoteControl.pressOnButton(3);

        System.out.println("------码农睡觉了，使用遥控关闭电灯、音响、电视。不关空调--------");
        remoteControl.pressOffButton(0);
        remoteControl.pressOffButton(1);
        remoteControl.pressOffButton(3);

        System.out.println("----撤销测试，先打开电灯。再关闭电灯。然后按撤销----");
        remoteControl.pressOnButton(0);
        remoteControl.pressOffButton(0);
        //一键撤销
        remoteControl.pressUndoButton();
    }
}
