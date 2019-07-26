package com.zero.design.actions.delegation;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: spring
 * @description: leader 委派者   任务分发的作用
 * @ModificationHistory who      when       What
 **/
public class Leader implements IExcuter {

    private Map<String, IExcuter> targets = new HashMap<String, IExcuter>();

    public Leader() {
        targets.put("加密", new ExcuterA());
        targets.put("登录", new ExcuterB());
    }

    @Override
    public void execute(String command) {
        targets.get(command).execute(command);
    }
}