package com.intranet.app.dagger.module.component;

import android.content.Context;
import com.intranet.app.AppModule;
import com.intranet.app.AppModule_ProvideContextFactory;
import com.intranet.app.api.ApiRequestHandler;
import com.intranet.app.api.ApiRequestHandler_MembersInjector;
import com.intranet.app.api.ApiService;
import com.intranet.app.dagger.module.NetModule;
import com.intranet.app.dagger.module.NetModule_ApiRequestHandlerFactory;
import com.intranet.app.dagger.module.NetModule_ProvideApiServiceFactory;
import com.intranet.app.dagger.module.NetModule_ProvideBusFactory;
import com.intranet.app.dagger.module.NetModule_ProvideEndpointFactory;
import com.intranet.app.dagger.module.NetModule_ProvideRequestInterceptorFactory;
import com.intranet.app.dagger.module.PresenterModule;
import com.intranet.app.dagger.module.PresenterModule_ProvideLoginPresenterFactory;
import com.intranet.app.ui.Activity.Daftar.DaftarFragment;
import com.intranet.app.ui.Activity.Daftar.DaftarFragment_MembersInjector;
import com.intranet.app.ui.Activity.DetailNota.DetailNotaFragment;
import com.intranet.app.ui.Activity.DetailNota.DetailNotaFragment_MembersInjector;
import com.intranet.app.ui.Activity.HomePage.HomePageFragment;
import com.intranet.app.ui.Activity.HomePage.HomePageFragment_MembersInjector;
import com.intranet.app.ui.Activity.Login.LoginFragment;
import com.intranet.app.ui.Activity.Login.LoginFragment_MembersInjector;
import com.intranet.app.ui.Activity.Makmal.MakmalFragment;
import com.intranet.app.ui.Activity.Makmal.MakmalFragment_MembersInjector;
import com.intranet.app.ui.Activity.Nota.NotaFragment;
import com.intranet.app.ui.Activity.Nota.NotaFragment_MembersInjector;
import com.intranet.app.ui.Presenter.Presenter;
import com.intranet.app.ui.Presenter.Presenter_MembersInjector;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit.Endpoint;
import retrofit.RequestInterceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<Bus> provideBusProvider;

  private Provider<RequestInterceptor> provideRequestInterceptorProvider;

  private Provider<Endpoint> provideEndpointProvider;

  private Provider<ApiService> provideApiServiceProvider;

  private Provider<Context> provideContextProvider;

  private Provider<Presenter> provideLoginPresenterProvider;

  private MembersInjector<LoginFragment> loginFragmentMembersInjector;

  private MembersInjector<ApiRequestHandler> apiRequestHandlerMembersInjector;

  private Provider<ApiRequestHandler> apiRequestHandlerProvider;

  private MembersInjector<Presenter> presenterMembersInjector;

  private MembersInjector<HomePageFragment> homePageFragmentMembersInjector;

  private MembersInjector<NotaFragment> notaFragmentMembersInjector;

  private MembersInjector<DaftarFragment> daftarFragmentMembersInjector;

  private MembersInjector<DetailNotaFragment> detailNotaFragmentMembersInjector;

  private MembersInjector<MakmalFragment> makmalFragmentMembersInjector;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideBusProvider =
        DoubleCheck.provider(NetModule_ProvideBusFactory.create(builder.netModule));

    this.provideRequestInterceptorProvider =
        DoubleCheck.provider(NetModule_ProvideRequestInterceptorFactory.create(builder.netModule));

    this.provideEndpointProvider =
        DoubleCheck.provider(NetModule_ProvideEndpointFactory.create(builder.netModule));

    this.provideApiServiceProvider =
        DoubleCheck.provider(
            NetModule_ProvideApiServiceFactory.create(
                builder.netModule, provideRequestInterceptorProvider, provideEndpointProvider));

    this.provideContextProvider = AppModule_ProvideContextFactory.create(builder.appModule);

    this.provideLoginPresenterProvider =
        DoubleCheck.provider(
            PresenterModule_ProvideLoginPresenterFactory.create(
                builder.presenterModule, provideContextProvider));

    this.loginFragmentMembersInjector =
        LoginFragment_MembersInjector.create(provideLoginPresenterProvider, provideBusProvider);

    this.apiRequestHandlerMembersInjector =
        ApiRequestHandler_MembersInjector.create(provideApiServiceProvider, provideBusProvider);

    this.apiRequestHandlerProvider =
        DoubleCheck.provider(
            NetModule_ApiRequestHandlerFactory.create(builder.netModule, provideContextProvider));

    this.presenterMembersInjector =
        Presenter_MembersInjector.create(apiRequestHandlerProvider, provideBusProvider);

    this.homePageFragmentMembersInjector =
        HomePageFragment_MembersInjector.create(provideLoginPresenterProvider, provideBusProvider);

    this.notaFragmentMembersInjector =
        NotaFragment_MembersInjector.create(provideLoginPresenterProvider, provideBusProvider);

    this.daftarFragmentMembersInjector =
        DaftarFragment_MembersInjector.create(provideLoginPresenterProvider, provideBusProvider);

    this.detailNotaFragmentMembersInjector =
        DetailNotaFragment_MembersInjector.create(
            provideLoginPresenterProvider, provideBusProvider);

    this.makmalFragmentMembersInjector =
        MakmalFragment_MembersInjector.create(provideLoginPresenterProvider, provideBusProvider);
  }

  @Override
  public Bus bus() {
    return provideBusProvider.get();
  }

  @Override
  public ApiService apiService() {
    return provideApiServiceProvider.get();
  }

  @Override
  public void inject(LoginFragment loginFragment) {
    loginFragmentMembersInjector.injectMembers(loginFragment);
  }

  @Override
  public void inject(ApiRequestHandler frag) {
    apiRequestHandlerMembersInjector.injectMembers(frag);
  }

  @Override
  public void inject(Presenter presenter) {
    presenterMembersInjector.injectMembers(presenter);
  }

  @Override
  public void inject(HomePageFragment homePageFragment) {
    homePageFragmentMembersInjector.injectMembers(homePageFragment);
  }

  @Override
  public void inject(NotaFragment notaFragment) {
    notaFragmentMembersInjector.injectMembers(notaFragment);
  }

  @Override
  public void inject(DaftarFragment daftarFragment) {
    daftarFragmentMembersInjector.injectMembers(daftarFragment);
  }

  @Override
  public void inject(DetailNotaFragment detailNotaFragment) {
    detailNotaFragmentMembersInjector.injectMembers(detailNotaFragment);
  }

  @Override
  public void inject(MakmalFragment makmalFragment) {
    makmalFragmentMembersInjector.injectMembers(makmalFragment);
  }

  public static final class Builder {
    private NetModule netModule;

    private AppModule appModule;

    private PresenterModule presenterModule;

    private Builder() {}

    public AppComponent build() {
      if (netModule == null) {
        this.netModule = new NetModule();
      }
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      if (presenterModule == null) {
        this.presenterModule = new PresenterModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder netModule(NetModule netModule) {
      this.netModule = Preconditions.checkNotNull(netModule);
      return this;
    }

    public Builder presenterModule(PresenterModule presenterModule) {
      this.presenterModule = Preconditions.checkNotNull(presenterModule);
      return this;
    }
  }
}
