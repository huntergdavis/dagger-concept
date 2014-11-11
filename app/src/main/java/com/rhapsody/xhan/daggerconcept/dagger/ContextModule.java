package com.rhapsody.xhan.daggerconcept.dagger;

import com.rhapsody.xhan.daggerconcept.MyContext;

import dagger.Module;
import dagger.Provides;

/**
 * @todo: add class description
 */
@Module (library = true)
public class ContextModule {
	@Provides
	MyContext provideMyContext() {
		return new MyContext("context name");
	}
}
