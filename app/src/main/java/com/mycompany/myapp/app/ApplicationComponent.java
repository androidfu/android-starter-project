package com.mycompany.myapp.app;

import com.mycompany.myapp.data.DataModule;
import com.mycompany.myapp.data.api.github.GitHubModule;
import com.mycompany.myapp.modules.CrashReporterModule;
import com.mycompany.myapp.monitoring.LoggerModule;
import com.mycompany.myapp.ui.main.MainComponent;
import com.mycompany.myapp.ui.main.MainComponent.MainModule;
import com.mycompany.myapp.ui.devsettings.DevSettingsComponent;
import com.mycompany.myapp.ui.devsettings.DevSettingsComponent.DevSettingsModule;
// GENERATOR - MORE IMPORTS //

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
    MainComponent mainComponent(MainModule module);
    DevSettingsComponent devSettingsComponent(DevSettingsModule module);
    // GENERATOR - MORE SUBCOMPONENTS //

    void inject(MainApplication application);
}
