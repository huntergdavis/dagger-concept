package com.rhapsody.xhan.daggerconcept;

import com.rhapsody.xhan.daggerconcept.dagger.CachePolicyModule;
import com.rhapsody.xhan.daggerconcept.dagger.Cached;
import com.rhapsody.xhan.daggerconcept.dagger.DebuggerWorkerModule;
import com.rhapsody.xhan.daggerconcept.dagger.NetworkServiceModule;
import com.rhapsody.xhan.daggerconcept.dagger.NotCached;
import com.rhapsody.xhan.daggerconcept.dagger.WorkerModule;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

import dagger.Module;
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

	@Inject
	Worker worker;

	public NetworkManager() {
		ObjectGraph.create(new ProviderModule()).inject(this);
		System.out.println(">>>>>>http client: " + httpClient);
		System.out.println(">>>>>>cached http client: " + cachedHttpClient);
		System.out.println(">>> worker: " + worker.id);
	}

    @Module (includes = {NetworkServiceModule.class, DebuggerWorkerModule.class, CachePolicyModule.class}, injects = {NetworkManager.class})
    class ProviderModule {

    }
}
