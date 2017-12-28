package com.intranet.app.ui.Activity.Login;

import com.intranet.app.ui.Presenter.Presenter;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginFragment_MembersInjector implements MembersInjector<LoginFragment> {
  private final Provider<Presenter> presenterProvider;

  private final Provider<Bus> busProvider;

  public LoginFragment_MembersInjector(
      Provider<Presenter> presenterProvider, Provider<Bus> busProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<LoginFragment> create(
      Provider<Presenter> presenterProvider, Provider<Bus> busProvider) {
    return new LoginFragment_MembersInjector(presenterProvider, busProvider);
  }

  @Override
  public void injectMembers(LoginFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      LoginFragment instance, Provider<Presenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(LoginFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
