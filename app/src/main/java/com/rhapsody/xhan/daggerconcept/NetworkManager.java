package com.rhapsody.xhan.daggerconcept;

import com.rhapsody.xhan.daggerconcept.dagger.CachePolicyModule;
import com.rhapsody.xhan.daggerconcept.dagger.Cached;
import com.rhapsody.xhan.daggerconcept.dagger.EmptyModule;
import com.rhapsody.xhan.daggerconcept.dagger.NetworkServiceModule;
import com.rhapsody.xhan.daggerconcept.dagger.NotCached;
import com.rhapsody.xhan.daggerconcept.dagger.SchedulerModule;
import com.rhapsody.xhan.daggerconcept.dagger.WorkerModule;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * @todo: add class description
 */
public class NetworkManager {
	@Inject
	Worker worker;

	@Inject Scheduler scheduler;

	public NetworkManager() {
		ObjectGraph.create(new EmptyModule()).inject(this);
		System.out.println(">>> worker: " + worker.id);
		System.out.println(">>> scheduler: " + scheduler.id);
	}
}
