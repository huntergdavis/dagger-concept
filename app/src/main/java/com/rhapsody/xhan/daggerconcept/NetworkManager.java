package com.rhapsody.xhan.daggerconcept;

import com.rhapsody.xhan.daggerconcept.dagger.CachePolicyModule;
import com.rhapsody.xhan.daggerconcept.dagger.Cached;
import com.rhapsody.xhan.daggerconcept.dagger.DebugCachePolicyModule;
import com.rhapsody.xhan.daggerconcept.dagger.DebuggerWorkerModule;
import com.rhapsody.xhan.daggerconcept.dagger.NetworkServiceModule;
import com.rhapsody.xhan.daggerconcept.dagger.NotCached;
import com.rhapsody.xhan.daggerconcept.dagger.WorkerModule;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

import dagger.Module;
import dagger.ObjectGraph;

/**
 * Demo class that holds multiple injections from different modules
 */
public class NetworkManager {
	@Inject
	@NotCached
	OkHttpClient httpClient; // get from NetworkServiceModule

	@Inject
	@Cached
	OkHttpClient cachedHttpClient; // get from NetworkServiceModule

	@Inject
	Worker worker; // get from WorkerModule

	public NetworkManager() {
		doInject();
		System.out.println(">>>>>>http client: " + httpClient);
		System.out.println(">>>>>>cached http client: " + cachedHttpClient);

		System.out.println(">>> worker: " + worker.toString());
	}

    /**
     * Debug class could override this method to provide debugger modules.
     */
    protected void doInject() {
        ObjectGraph.create(new DebugProviderModule2()).inject(this);
    }

    /**
     * Actual module that do inject. It collects all modules that target requires
     */
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
     * Debug module.
     *
     * Note: ProviderModule need to be static class if nested. Otherwise dagger get confused with class$inner_class$$inner_inner_class
     */
    @Module(includes = {ProviderModule.class /*main module provider*/, DebuggerWorkerModule.class, DebugCachePolicyModule.class}, injects = {NetworkManager.class})
    class DebugProviderModule2 {

    }
}
