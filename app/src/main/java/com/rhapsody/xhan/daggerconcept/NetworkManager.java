package com.rhapsody.xhan.daggerconcept;

import com.rhapsody.xhan.daggerconcept.dagger.CachePolicyModule;
import com.rhapsody.xhan.daggerconcept.dagger.Cached;
import com.rhapsody.xhan.daggerconcept.dagger.NetworkServiceModule;
import com.rhapsody.xhan.daggerconcept.dagger.NotCached;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * @todo: add class description
 */
public class NetworkManager {
	@Inject
	@NotCached
	OkHttpClient httpClient;

	@Inject
	@Cached
	OkHttpClient cachedHttpClient;

	public NetworkManager() {
		ObjectGraph.create(new NetworkServiceModule()).inject(this);
		System.out.println(">>>>>>http client: " + httpClient);
		System.out.println(">>>>>>cached http client: " + cachedHttpClient);
	}
}
