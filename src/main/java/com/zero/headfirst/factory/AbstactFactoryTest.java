/**
 * Project: com-zero-design-stu
 * File created at 2019/7/3 12:47
 */
package com.zero.headfirst.factory;

import com.zero.headfirst.factory.product.CPU;
import com.zero.headfirst.factory.product.Mainboard;

/**
 * @author lijianqing
 * @version 1.0
 * @ClassName AbstactFactoryTest
 * @date 2019/7/3 12:47
 */
public class AbstactFactoryTest {
    public static void main(String[] args) {
        MainboardCPUFactory intelFactory = new IntelFactory();
        CPU cpu = intelFactory.createCpu();
        Mainboard mainboard = intelFactory.createMainboard();

        mainboard.installCPU();
        cpu.calculate();
    }
}
