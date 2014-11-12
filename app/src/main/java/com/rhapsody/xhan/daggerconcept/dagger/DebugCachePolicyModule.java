package com.rhapsody.xhan.daggerconcept.dagger;

import com.rhapsody.xhan.daggerconcept.CachePolicy;
import com.rhapsody.xhan.daggerconcept.MyContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xhan on 11/11/14.
 */
@Module(addsTo = CachePolicyModule.class, overrides = true, library = true)
public class DebugCachePolicyModule {
    @Provides
    CachePolicy provideCachePolicy(MyContext context) {
        return new CachePolicy(9, "Debug cache policy");
    }
}
