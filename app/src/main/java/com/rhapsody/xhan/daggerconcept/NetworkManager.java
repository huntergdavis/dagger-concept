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
		ObjectGraph.create(new DebugProviderModule2()).inject(this);
		System.out.println(">>>>>>http client: " + httpClient);
		System.out.println(">>>>>>cached http client: " + cachedHttpClient);
		System.out.println(">>> worker: " + worker.toString());
	}

    @Module (includes = {NetworkServiceModule.class, WorkerModule.class, CachePolicyModule.class}, injects = {NetworkManager.class})
    static class ProviderModule {

    }

    /**
     * Not working, compile pass, but get following runtime error:
     * @com.rhapsody.xhan.daggerconcept.dagger.NotCached()/com.squareup.okhttp.OkHttpClient required by class com.rhapsody.xhan.daggerconcept.NetworkManager
     * @com.rhapsody.xhan.daggerconcept.dagger.Cached()/com.squareup.okhttp.OkHttpClient required by class com.rhapsody.xhan.daggerconcept.NetworkManager
     */
    @Module(includes = {DebuggerWorkerModule.class}, injects = {NetworkManager.class}, addsTo = ProviderModule.class)
    class DebugProviderModule1 {

    }

    /**
     * Working.
     * Note: ProviderModule need to be static class if nested. Otherwise dagger get confused with class$inner_class$$inner_inner_class
     */
    @Module(includes = {DebuggerWorkerModule.class, ProviderModule.class}, injects = {NetworkManager.class})
    public class DebugProviderModule2 {

    }
}
