package com.dbcore.agent.service;

import java.util.List;

import com.dbcore.agent.vo.AgentInfoVo;

public interface IAgentService {
	
	/* fsdfdsvdssssssssssssssssssssssssssssssssssssssss */
	public List<Object> selectAgentInfo(AgentInfoVo agentInfoVo)throws Exception;
	
	public int getTotalCount(AgentInfoVo agentInfoVo) throws Exception;
	
	public void insertAgentInfo(AgentInfoVo agentInfoVo)throws Exception;
	
	

}
