package com.devofure.templecore.di._core;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.HasServiceInjector;

public abstract class DaggerApplication extends Application implements HasActivityInjector, HasServiceInjector, HasBroadcastReceiverInjector {

	@Inject
	public DispatchingAndroidInjector<Activity> mDispatchingAndroidInjector;

	@Inject
	public DispatchingAndroidInjector<Service> mDispatchingServiceInjector;

	@Inject
	public DispatchingAndroidInjector<BroadcastReceiver> mDispatchingBroadcastReceiverInjector;

	@Override
	public AndroidInjector<Activity> activityInjector() {
		return mDispatchingAndroidInjector;
	}

	@Override
	public AndroidInjector<Service> serviceInjector() {
		return mDispatchingServiceInjector;
	}

	@Override
	public AndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {
		return mDispatchingBroadcastReceiverInjector;
	}
}
