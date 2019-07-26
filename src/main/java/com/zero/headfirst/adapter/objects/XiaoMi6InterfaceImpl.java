/**
 * Project: com-zero-design-stu
 * File created at 2019/6/24 20:02
 */
package com.zero.headfirst.adapter.objects;

/**
 * 小米六 type c 接口默认实现功能
 * @author lijianqing
 * @version 1.0
 * @ClassName XiaoMi6HeadphoneImpl
 * @date 2019/6/24 20:02
 */
public class XiaoMi6InterfaceImpl implements XiaoMi6Interface {
    @Override
    public void listenMusic() {
        System.out.println("通过 type c 接口的耳机听歌");
    }

}
