package com.rhapsody.xhan.daggerconcept;

import javax.inject.Inject;

/**
 * @todo: add class description
 */
public class Scheduler {
	public int id;

	public Scheduler (int id) {
		this.id = id;
	}

	@Inject
	public Scheduler () {
		id= -1;
	}
}
