package com.rhapsody.xhan.daggerconcept.dagger;

import com.rhapsody.xhan.daggerconcept.NetworkManager;
import com.rhapsody.xhan.daggerconcept.Worker;

import dagger.Module;
import dagger.Provides;

/**
 * @todo: add class description
 */
@Module(library = true)
public class WorkerModule {
	@Provides
	Worker provideWorker() {
		return new Worker(1);
	}
}
