package com.devofure.templecore._core;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

public class LiveDataHelper {

	public static <T> LiveData<T> getDistinct(LiveData<T> liveData) {
		final MediatorLiveData<T> distinctLiveData = new MediatorLiveData<>();
		distinctLiveData.addSource(liveData, new Observer<T>() {
			private boolean initialized = false;
			private T lastModel = null;

			@Override
			public void onChanged(@Nullable T newModel) {
				if (!initialized) {
					initialized = true;
					lastModel = newModel;
					distinctLiveData.postValue(lastModel);
				} else if ((newModel == null && lastModel != null) || !areEquals(newModel)) {
					lastModel = newModel;
					distinctLiveData.postValue(lastModel);
				}
			}

			private boolean areEquals(@Nullable T newModel) {
				return newModel != null && newModel.equals(lastModel)
						|| lastModel != null && lastModel.equals(newModel)
						|| lastModel == null && newModel == null;
			}
		});
		return distinctLiveData;
	}
}
