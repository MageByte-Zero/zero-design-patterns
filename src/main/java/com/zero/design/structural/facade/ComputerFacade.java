package com.zero.design.structural.facade;

/**
 * 外观类：给客户端提供了一个视图
 * Created by unique on 2017/5/14.
 */
public class ComputerFacade {

    private CPU cpu = new CPU();

    private Memory memory = new Memory();

    private Disk disk = new Disk();

    private ComputerFacade() {

    }

    private static class Holder {
        private static ComputerFacade instance = new ComputerFacade();
    }

    public static ComputerFacade getInstance() {
        return Holder.instance;
    }

    /**
     * 开机一步到位，用户不必根各个硬件打交道，就像一个开关搞定
     */
    public void startup(){
        System.out.println("start the computer!");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finished!");
    }

    public void shutdown(){
        System.out.println("begin to close the computer!");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("computer closed!");
    }

    /**
     * 可以不写，只是自己测试
     * @return
     */
    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }
}
