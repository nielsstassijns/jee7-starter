package com.realdolmen.cditest;

import javax.inject.Inject;

public class XClass {
	
	@Inject
	private ZClass zclass;
	
	@Inject
	private YClass yclass;

	public XClass() {
		super();
	}

}
