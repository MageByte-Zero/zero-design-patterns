/**
 * Project: com-zero-design-stu
 * File created at 2019/7/3 12:37
 */
package com.zero.headfirst.factory;

import com.zero.headfirst.factory.product.CPU;
import com.zero.headfirst.factory.product.Mainboard;

/**
 * @author lijianqing
 * @version 1.0
 * @ClassName MainboardCPUFactory
 * @date 2019/7/3 12:37
 */
public interface MainboardCPUFactory {
    /**
     * 创建CPU对象
     *
     * @return CPU对象
     */
    public CPU createCpu();

    /**
     * 创建主板对象
     *
     * @return 主板对象
     */
    public Mainboard createMainboard();
}
