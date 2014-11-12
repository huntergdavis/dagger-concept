package com.rhapsody.xhan.daggerconcept.dagger;

import com.rhapsody.xhan.daggerconcept.Worker;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xhan on 11/11/14.
 */
@Module(addsTo = WorkerModule.class, library = true, overrides = true)
public class DebuggerWorkerModule {
    @Provides
    Worker provideWorker() {
        return new Worker(5, "debug worker");
    }
}
