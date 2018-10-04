package com.devofure.templecore.di._core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Helper class to automatically inject fragments if they implement {@link Injectable}.
 */
public class AppInjector {
	private AppInjector() {
	}

	public static AppComponent init(DaggerApplication app) {
		AppComponent appComponent = DaggerAppComponent
				.builder()
				.application(app)
				.build();

		appComponent.inject(app);
		app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
			@Override
			public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
				handleActivity(activity);
			}

			@Override
			public void onActivityStarted(Activity activity) {
			}

			@Override
			public void onActivityResumed(Activity activity) {
			}

			@Override
			public void onActivityPaused(Activity activity) {
			}

			@Override
			public void onActivityStopped(Activity activity) {
			}

			@Override
			public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
			}

			@Override
			public void onActivityDestroyed(Activity activity) {
			}
		});
		return appComponent;
	}

	private static void handleActivity(Activity activity) {
		if (activity instanceof HasSupportFragmentInjector) {
			AndroidInjection.inject(activity);
		}
		if (activity instanceof FragmentActivity) {
			((FragmentActivity) activity).getSupportFragmentManager()
					.registerFragmentLifecycleCallbacks(
							new FragmentManager.FragmentLifecycleCallbacks() {
								@Override
								public void onFragmentCreated(FragmentManager fm, Fragment f,
															  Bundle savedInstanceState) {
									if (f instanceof Injectable) {
										AndroidSupportInjection.inject(f);
									}
								}
							}, true);
		}
	}
}