package com.intranet.app.dagger.module.component;

import com.intranet.app.AppModule;
import com.intranet.app.api.ApiRequestHandler;
import com.intranet.app.api.ApiService;
import com.intranet.app.dagger.module.NetModule;
import com.intranet.app.dagger.module.PresenterModule;
import com.intranet.app.ui.Activity.Daftar.DaftarFragment;
import com.intranet.app.ui.Activity.HomePage.HomePageFragment;
import com.intranet.app.ui.Activity.Login.LoginFragment;

import com.intranet.app.ui.Activity.Nota.NotaFragment;
import com.intranet.app.ui.Presenter.Presenter;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

//import com.open.project.ui.Presenter.HomepagePresenter;

@Singleton
@Component(modules = {AppModule.class, NetModule.class, PresenterModule.class})
public interface AppComponent {

    Bus bus();

    ApiService apiService();

    void inject(LoginFragment loginFragment);
    void inject(ApiRequestHandler frag);
    void inject(Presenter presenter);
    void inject(HomePageFragment homePageFragment);
    void inject(NotaFragment notaFragment);
    void inject(DaftarFragment daftarFragment);



}



