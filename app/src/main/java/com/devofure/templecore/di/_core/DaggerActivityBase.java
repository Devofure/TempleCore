package com.devofure.templecore.di._core;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class DaggerActivityBase extends AppCompatActivity implements HasSupportFragmentInjector {

	@Inject
	public DispatchingAndroidInjector<Fragment> mDispatchingAndroidInjector;

	@Inject
	public ViewModelProvider.Factory mViewModelFactory;

	@Override
	public AndroidInjector<Fragment> supportFragmentInjector() {
		return mDispatchingAndroidInjector;
	}

	public ViewModelProvider.Factory getViewModelFactory() {
		return mViewModelFactory;
	}

}
