package com.intranet.app.dagger.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit.RequestInterceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideRequestInterceptorFactory
    implements Factory<RequestInterceptor> {
  private final NetModule module;

  public NetModule_ProvideRequestInterceptorFactory(NetModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public RequestInterceptor get() {
    return Preconditions.checkNotNull(
        module.provideRequestInterceptor(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RequestInterceptor> create(NetModule module) {
    return new NetModule_ProvideRequestInterceptorFactory(module);
  }

  /** Proxies {@link NetModule#provideRequestInterceptor()}. */
  public static RequestInterceptor proxyProvideRequestInterceptor(NetModule instance) {
    return instance.provideRequestInterceptor();
  }
}
