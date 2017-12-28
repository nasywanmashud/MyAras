package com.intranet.app.application;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.intranet.app.AppModule;
import com.intranet.app.TaskChecker;
import com.intranet.app.dagger.module.NetModule;
import com.intranet.app.dagger.module.PresenterModule;
import com.intranet.app.dagger.module.component.AppComponent;
import com.intranet.app.dagger.module.component.DaggerAppComponent;

public class MainApplication extends MultiDexApplication {

    private static Activity instance;
    private AppComponent mDataComponent;
    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        TaskChecker.init(this);

        context = getApplicationContext();

        buildComponentAndInject();

    }

    public AppComponent getNetComponent() {
        return mDataComponent;
    }

    public void buildComponentAndInject() {
        mDataComponent = DaggerComponentInitializer.init(this, context);
    }

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    public static Activity getContext() {
        return instance;
    }

    public static final class DaggerComponentInitializer {
        public static AppComponent init(MainApplication app, Context context) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app, context))
                    .netModule(new NetModule())
                    .presenterModule(new PresenterModule())
                    .build();
        }
    }

    public static AppComponent component(Context context) {
        return ((MainApplication) context.getApplicationContext()).mDataComponent;
    }

}

