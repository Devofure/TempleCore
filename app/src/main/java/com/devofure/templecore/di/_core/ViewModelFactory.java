package com.devofure.templecore.di._core;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


/**
 * Only retrieves the viewmodels as the google examples does
 */
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

	private Map<Class<? extends ViewModel>, Provider<ViewModel>> mCreators;

	@Inject
	ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
		mCreators = creators;
	}

	@NonNull
	@Override
	public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
		Provider<? extends ViewModel> creator = mCreators.get(modelClass);
		if (creator == null) {
			for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : mCreators.entrySet()) {
				if (modelClass.isAssignableFrom(entry.getKey())) {
					creator = entry.getValue();
					break;
				}
			}
		}
		if (creator == null) {
			//it can be that the viewModel is not injected in the di/ViewModelModule
			throw new IllegalArgumentException("unknown model class " + modelClass);
		}
		try {
			return (T) creator.get();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
