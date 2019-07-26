package com.zero.design.actions.states.vote;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 环境类
 * Created by ljq97 on 2017/8/23.
 */
public class VoteManagerContext {
    /**
     * 持有状态处理对象
     */
    private IVoteState state = null;

    /**
     * 记录用户投票的结果，Map<String,String>对应Map<用户名称，投票的选项>
     */
    private ConcurrentHashMap<String, String> mapVote = new ConcurrentHashMap<String, String>();

    /**
     * 记录用户投票次数，Map<String,Integer>对应Map<用户名称，投票的次数>
     */
    private Map<String, Integer> mapVoteCount = new ConcurrentHashMap<String, Integer>();

    /**
     * 黑名单
     */
    private Set<String> blackVoteSet = new HashSet<String>();

    /**
     * 获取黑名单
     * @return
     */
    public Set<String> getBlackVoteSet() {
        return blackVoteSet;
    }

    /**
     * 获取用户投票结果Map
     * @return
     */
    public ConcurrentHashMap<String, String> getMapVote() {
        return mapVote;
    }

    /**
     * 投票入口,
     * @param user 投票人
     * @param voteItem 投票选项
     */
    public void vote(String user, String voteItem) {
        if (blackVoteSet.contains(user)){
            System.out.println("你已经被拉黑");
            return;
        }
        //1.为该用户增加投票次数
        //从记录中取出该用户已有的投票次数
        Integer oldVoteCount = mapVoteCount.get(user);
        oldVoteCount = oldVoteCount == null ? 0: oldVoteCount;
        oldVoteCount++;

        mapVoteCount.put(user, oldVoteCount);

        //2判断该用户的投票类型，就相当于判断对应的状态
        //到底是正常投票、重复投票、恶意投票还是上黑名单的状态
        if (oldVoteCount == 1) {
            state = new NormalVoteState();
        } else if (oldVoteCount > 1 && oldVoteCount < 5) {
            //重复投票
            state = new RepeatVoteState();
        } else if (oldVoteCount >= 5 && oldVoteCount < 8) {
            //恶意投票
            state = new SpiteVoteState();
        } else if (oldVoteCount >= 8) {
            //上黑名单
            state = new BlackVoteState();
        }

        //判断好状态后转调状态对象来进行相应的操作
        state.vote(user, voteItem, this);

    }
}
