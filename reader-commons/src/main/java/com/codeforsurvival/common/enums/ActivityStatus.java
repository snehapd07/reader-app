package com.codeforsurvival.common.enums;

import java.util.ArrayList;
import java.util.List;

public enum ActivityStatus {

	READING("reading"), READ_LATER("readlater"), COMPLETED("completed"), NOT_STARTED(
			"notstarted");

	private String status;
	private static List<String> list = new ArrayList<String>();

	private ActivityStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
