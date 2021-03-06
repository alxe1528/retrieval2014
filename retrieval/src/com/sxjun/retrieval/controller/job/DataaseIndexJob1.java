package com.sxjun.retrieval.controller.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.sxjun.retrieval.controller.index.DatabaseIndexAllItem1Impl;

import frame.retrieval.engine.facade.DBIndexOperatorFacade;
import frame.retrieval.engine.facade.ICreateIndexAllItem;

public class DataaseIndexJob1 implements Job {
	private ICreateIndexAllItem iciai= null;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		iciai = new DatabaseIndexAllItem1Impl();
		DBIndexOperatorFacade indexAll = new DBIndexOperatorFacade(iciai);
		indexAll.indexAll(indexAll.INDEX_BY_THREAD);
	}
	
}
