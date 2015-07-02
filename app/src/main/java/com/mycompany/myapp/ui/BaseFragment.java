package com.mycompany.myapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.mycompany.myapp.monitoring.CrashReporter;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import timber.log.Timber.Tree;

public abstract class BaseFragment extends Fragment {
    @Inject
    protected Tree logger;

    @Inject
    protected CrashReporter crashReporter;

    @Inject
    protected Bus bus;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        attemptInject(activity);
    }

    private void attemptInject(Activity activity) {
        BaseActivity baseActivity = (BaseActivity) activity;
        baseActivity.getActivityGraph().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    public void onPause() {
        bus.unregister(this);
        super.onPause();
    }
}
