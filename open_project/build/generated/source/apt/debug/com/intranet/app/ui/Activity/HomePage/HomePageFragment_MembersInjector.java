package com.intranet.app.ui.Activity.HomePage;

import com.intranet.app.ui.Presenter.Presenter;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomePageFragment_MembersInjector implements MembersInjector<HomePageFragment> {
  private final Provider<Presenter> presenterProvider;

  private final Provider<Bus> busProvider;

  public HomePageFragment_MembersInjector(
      Provider<Presenter> presenterProvider, Provider<Bus> busProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<HomePageFragment> create(
      Provider<Presenter> presenterProvider, Provider<Bus> busProvider) {
    return new HomePageFragment_MembersInjector(presenterProvider, busProvider);
  }

  @Override
  public void injectMembers(HomePageFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      HomePageFragment instance, Provider<Presenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(HomePageFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
