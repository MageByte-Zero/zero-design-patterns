package com.zero.design.actions.states.vote;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by ljq97 on 2017/8/23.
 */
public class SpiteVoteState implements IVoteState {
    @Override
    public void vote(String user, String voteItem, VoteManagerContext context) {
        //恶意刷票，取消用户的投票资格，并取消投票记录
        String str = context.getMapVote().get(user);
        if (StringUtils.isNotBlank(str)) {
            context.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷票行为，取消投票资格。");
    }
}
