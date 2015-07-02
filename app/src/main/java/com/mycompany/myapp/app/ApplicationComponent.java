package com.mycompany.myapp.app;

import com.mycompany.myapp.data.DataModule;
import com.mycompany.myapp.data.api.github.GitHubModule;
import com.mycompany.myapp.modules.CrashReporterModule;
import com.mycompany.myapp.monitoring.LoggerModule;
import com.mycompany.myapp.ui.main.MainComponent;
import com.mycompany.myapp.ui.main.MainUIModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AndroidModule.class,
        LoggerModule.class,
        CrashReporterModule.class,
        DataModule.class,
        GitHubModule.class
})
public interface ApplicationComponent {
    MainComponent plus(MainUIModule module);

    void inject(MainApplication application);
}
