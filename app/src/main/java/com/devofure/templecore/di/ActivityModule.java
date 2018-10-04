package com.devofure.templecore.di;

import com.devofure.templecore.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

	@ContributesAndroidInjector(modules = FragmentModule.class)
	abstract MainActivity contributeMainActivity();
}
