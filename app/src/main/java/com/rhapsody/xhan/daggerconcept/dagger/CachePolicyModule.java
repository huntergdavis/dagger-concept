package com.rhapsody.xhan.daggerconcept.dagger;

import com.rhapsody.xhan.daggerconcept.CachePolicy;

import dagger.Module;
import dagger.Provides;

/**
 * @todo: add class description
 */
@Module (library = true)
public class CachePolicyModule {
	@Provides
	CachePolicy provideCachePolicy() {
		return new CachePolicy(2);
	}
}
