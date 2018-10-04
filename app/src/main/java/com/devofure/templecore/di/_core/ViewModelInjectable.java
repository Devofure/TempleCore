package com.devofure.templecore.di._core;

import androidx.lifecycle.ViewModelProvider;

public interface ViewModelInjectable extends Injectable {
	ViewModelProvider.Factory getViewModelFactory();
}
