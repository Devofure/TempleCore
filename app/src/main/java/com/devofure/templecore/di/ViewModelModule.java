package com.devofure.templecore.di;


import com.devofure.templecore.di._core.ViewModelFactory;
import com.devofure.templecore.di._core.ViewModelKey;
import com.devofure.templecore.ui.main.MainViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

	@Binds
	public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

	@Binds
	@IntoMap
	@ViewModelKey(MainViewModel.class)
	public abstract ViewModel bindStartViewModel(MainViewModel viewModel);
}