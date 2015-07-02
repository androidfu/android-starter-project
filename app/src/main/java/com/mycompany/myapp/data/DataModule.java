package com.mycompany.myapp.data;

import android.app.Application;

import com.mycompany.myapp.app.AndroidModule;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.client.Client;
import retrofit.client.OkClient;

@Module(library = true,
        includes = AndroidModule.class)
public class DataModule {
    private static final int DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(Application app) {
        OkHttpClient client = new OkHttpClient();

        // Install an HTTP cache in the application cache directory.
        File cacheDir = new File(app.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        client.setCache(cache);

        return client;
    }

    @Singleton
    @Provides
    Client provideClient(OkHttpClient client) {
        return new OkClient(client);
    }
}
