package com.dbcore.agent.Dao;

import java.util.List;

import com.dbcore.agent.vo.AgentInfoVo;
import com.dbcore.model.CodeVO;
import com.dbcore.parm.agent.AgentParm;

public interface IAgentDao {
	
	public List<Object> selectAgentList(AgentInfoVo agentInfoVo) throws Exception; 	//업체정보조회
	public int getTotalCount(AgentParm agentParm)throws Exception;					//총카운트
	public void insertAgentInfo(AgentInfoVo agentInfoVo)throws Exception;
}
