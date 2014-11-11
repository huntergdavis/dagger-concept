package com.rhapsody.xhan.daggerconcept.dagger;

import com.rhapsody.xhan.daggerconcept.NetworkManager;
import com.rhapsody.xhan.daggerconcept.Scheduler;

import dagger.Module;
import dagger.Provides;

/**
 * @todo: add class description
 */
@Module(injects = {NetworkManager.class})
public class SchedulerModule {
	@Provides
	Scheduler provideScheduler() {
		return new Scheduler(3);
	}
}
