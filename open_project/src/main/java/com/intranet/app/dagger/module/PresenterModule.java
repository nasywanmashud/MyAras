package com.intranet.app.dagger.module;

import android.content.Context;

import com.intranet.app.ui.Presenter.Presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    Presenter provideLoginPresenter(Context context) {
        return new Presenter(context);
    }


}

