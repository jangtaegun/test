package com.dbcore.agent.Dao.Impl;

import java.util.List;

import com.dbcore.agent.Dao.IAgentDao;
import com.dbcore.agent.vo.AgentInfoVo;
import com.dbcore.parm.agent.AgentParm;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


public class AgentDaoImple extends EgovAbstractDAO implements IAgentDao {

	@Override
	public List<Object> selectAgentList(AgentInfoVo agentInfoVo)
			throws Exception {
		// TODO Auto-generated method stub
		return list("agent.selectAgentList", agentInfoVo);
	}

	@Override
	public int getTotalCount(AgentParm agentParm) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertAgentInfo(AgentInfoVo agentInfoVo) throws Exception {
		// TODO Auto-generated method stub
		 insert("agent.insertAgentInfo", agentInfoVo);
	}
}
