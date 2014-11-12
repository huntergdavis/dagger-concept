package com.rhapsody.xhan.daggerconcept;

import javax.inject.Inject;

/**
 * @todo: add class description
 */
public class CachePolicy {
	public int policyId;
    public String name;

	public CachePolicy (int policyId) {
		this.policyId = policyId;
	}

    public CachePolicy(int policyId, String name) {
        this.policyId = policyId;
        this.name = name;
    }

    public CachePolicy () {
		this.policyId = 0;
	}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CachePolicy{");
        sb.append("policyId=").append(policyId);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
