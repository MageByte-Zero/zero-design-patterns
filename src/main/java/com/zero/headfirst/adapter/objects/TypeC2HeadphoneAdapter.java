/**
 * Project: com-zero-design-stu
 * File created at 2019/6/24 19:49
 */
package com.zero.headfirst.adapter.objects;

/**
 * @author lijianqing
 * @version 1.0
 * @ClassName TypeC2HeadphoneAdapter
 * @date 2019/6/24 19:49
 */
public class TypeC2HeadphoneAdapter implements XiaoMi6Interface {

    private CommonPhoneInterface commonPhoneInterface;

    public TypeC2HeadphoneAdapter(CommonPhoneInterface commonPhoneInterface) {
        this.commonPhoneInterface = commonPhoneInterface;
    }

    @Override
    public void listenMusic() {
        System.out.println("通过 type c 转 3.5mm适配器将目标 type c 接口适配上3.5mm接口。");
        commonPhoneInterface.listenMusic();
    }

}
