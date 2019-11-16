package com.zero.design.actions.dutychain;

/**
 * 责任链抽象类，包含核心处理方法，以及后继责任处理器设置.由不同的处理器继承
 * Created by ljq97 on 2017/8/9.
 */
public abstract class AbstractLeaderHandler {

    protected String handlerName;

    /**
     * 责任链上的后继对象，即这个对象无法处理，就转移给下一个Leader
     */
    protected AbstractLeaderHandler nextLeaderHandler;

    public AbstractLeaderHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    /**
     * 处理请求的核心的业务方法
     * 需要不同继承该类的处理器自己实现
     * @param request
     */
    public abstract void handleRequest(LeaveRequest request);

    /**
     * 设定责任链上的后继对象
     * @param nextLeaderHandler
     */
    public AbstractLeaderHandler setNextLeaderHandler(AbstractLeaderHandler nextLeaderHandler) {
        this.nextLeaderHandler = nextLeaderHandler;
        return nextLeaderHandler;
    }
}
