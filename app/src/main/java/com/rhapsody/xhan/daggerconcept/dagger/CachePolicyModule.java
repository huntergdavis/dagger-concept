package com.rhapsody.xhan.daggerconcept.dagger;

import com.rhapsody.xhan.daggerconcept.CachePolicy;
import com.rhapsody.xhan.daggerconcept.MyContext;

import dagger.Module;
import dagger.Provides;

/**
 * @todo: add class description
 */
@Module (library = true, includes = {ContextModule.class})
public class CachePolicyModule {
	@Provides
	CachePolicy provideCachePolicy(MyContext context) {
		return new CachePolicy(2);
	}
}
