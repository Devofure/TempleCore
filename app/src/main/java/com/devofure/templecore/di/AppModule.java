package com.devofure.templecore.di;

import dagger.Module;

@Module(includes = {
		ActivityModule.class,
		ViewModelModule.class,
		HandlerModule.class,
		RepositoryModule.class})
public abstract class AppModule {
}
