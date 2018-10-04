package com.devofure.templecore.di._core;

import android.app.Application;

import com.devofure.templecore.di.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
		AndroidSupportInjectionModule.class,
		AppModule.class
})
public interface AppComponent {
	void inject(DaggerApplication app);

	@Component.Builder
	interface Builder {
		@BindsInstance
		Builder application(Application application);

		AppComponent build();
	}
}
