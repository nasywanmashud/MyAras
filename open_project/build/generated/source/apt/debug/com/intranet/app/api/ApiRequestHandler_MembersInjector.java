package com.intranet.app.api;

import com.squareup.otto.Bus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiRequestHandler_MembersInjector implements MembersInjector<ApiRequestHandler> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<Bus> busProvider;

  public ApiRequestHandler_MembersInjector(
      Provider<ApiService> apiServiceProvider, Provider<Bus> busProvider) {
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<ApiRequestHandler> create(
      Provider<ApiService> apiServiceProvider, Provider<Bus> busProvider) {
    return new ApiRequestHandler_MembersInjector(apiServiceProvider, busProvider);
  }

  @Override
  public void injectMembers(ApiRequestHandler instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.apiService = apiServiceProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectApiService(
      ApiRequestHandler instance, Provider<ApiService> apiServiceProvider) {
    instance.apiService = apiServiceProvider.get();
  }

  public static void injectBus(ApiRequestHandler instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
