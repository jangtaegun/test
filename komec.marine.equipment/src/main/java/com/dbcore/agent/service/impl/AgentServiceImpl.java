package com.dbcore.agent.service.impl;

import java.util.List;

import com.dbcore.agent.Dao.IAgentDao;
import com.dbcore.agent.Dao.Impl.AgentDaoImple;
import com.dbcore.agent.service.IAgentService;
import com.dbcore.agent.vo.AgentInfoVo;

/**
 * @author jang
 *
 */
public class AgentServiceImpl implements IAgentService {
	
	
	private IAgentDao agentDao;
	

	public void setAgentDao(AgentDaoImple agentDao) {
		this.agentDao = agentDao;
	}

	@Override
	public List<Object> selectAgentInfo(AgentInfoVo agentInfoVo)
			throws Exception {
		// TODO Auto-generated method stub
		
		List<Object> list = agentDao.selectAgentList(agentInfoVo);
		
		return list;
	}

	@Override
	public int getTotalCount(AgentInfoVo agentInfoVo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertAgentInfo(AgentInfoVo agentInfoVo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
