package com.rhapsody.xhan.daggerconcept.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @todo: add class description
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Cached {
}
