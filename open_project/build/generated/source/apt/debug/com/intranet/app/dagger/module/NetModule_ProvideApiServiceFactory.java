package com.intranet.app.dagger.module;

import com.intranet.app.api.ApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit.Endpoint;
import retrofit.RequestInterceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideApiServiceFactory implements Factory<ApiService> {
  private final NetModule module;

  private final Provider<RequestInterceptor> requestInterceptorProvider;

  private final Provider<Endpoint> endpointProvider;

  public NetModule_ProvideApiServiceFactory(
      NetModule module,
      Provider<RequestInterceptor> requestInterceptorProvider,
      Provider<Endpoint> endpointProvider) {
    assert module != null;
    this.module = module;
    assert requestInterceptorProvider != null;
    this.requestInterceptorProvider = requestInterceptorProvider;
    assert endpointProvider != null;
    this.endpointProvider = endpointProvider;
  }

  @Override
  public ApiService get() {
    return Preconditions.checkNotNull(
        module.provideApiService(requestInterceptorProvider.get(), endpointProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ApiService> create(
      NetModule module,
      Provider<RequestInterceptor> requestInterceptorProvider,
      Provider<Endpoint> endpointProvider) {
    return new NetModule_ProvideApiServiceFactory(
        module, requestInterceptorProvider, endpointProvider);
  }

  /** Proxies {@link NetModule#provideApiService(RequestInterceptor, Endpoint)}. */
  public static ApiService proxyProvideApiService(
      NetModule instance, RequestInterceptor requestInterceptor, Endpoint endpoint) {
    return instance.provideApiService(requestInterceptor, endpoint);
  }
}
