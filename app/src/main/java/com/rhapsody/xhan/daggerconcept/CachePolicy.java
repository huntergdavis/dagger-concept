package com.rhapsody.xhan.daggerconcept;

import javax.inject.Inject;

/**
 * @todo: add class description
 */
public class CachePolicy {
	public int policyId;

	public CachePolicy (int policyId) {
		this.policyId = policyId;
	}

	public CachePolicy () {
		this.policyId = 0;
	}
}
