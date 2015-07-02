package com.mycompany.myapp.app;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class BusModule {
    @Singleton
    @Provides
    Bus provideBus() {
        return new Bus();
    }
}
