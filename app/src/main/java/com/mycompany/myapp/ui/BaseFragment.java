package com.mycompany.myapp.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mycompany.myapp.app.HasComponent;
import com.mycompany.myapp.monitoring.CrashReporter;

import javax.inject.Inject;

import timber.log.Timber.Tree;

public abstract class BaseFragment<T> extends Fragment {
    @Inject
    protected Tree logger;

    @Inject
    protected CrashReporter crashReporter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        attemptInject(activity);
    }

    private void attemptInject(Activity activity) {
        if (activity instanceof HasComponent) {
            @SuppressWarnings("unchecked")
            HasComponent<T> hasComponent = (HasComponent<T>) activity;
            T component = hasComponent.getComponent();
            inject(component);
        }
    }

    protected abstract void inject(T component);
}
