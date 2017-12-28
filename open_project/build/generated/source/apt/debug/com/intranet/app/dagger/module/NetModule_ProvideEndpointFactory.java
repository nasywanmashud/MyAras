package com.intranet.app.dagger.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit.Endpoint;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideEndpointFactory implements Factory<Endpoint> {
  private final NetModule module;

  public NetModule_ProvideEndpointFactory(NetModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Endpoint get() {
    return Preconditions.checkNotNull(
        module.provideEndpoint(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Endpoint> create(NetModule module) {
    return new NetModule_ProvideEndpointFactory(module);
  }

  /** Proxies {@link NetModule#provideEndpoint()}. */
  public static Endpoint proxyProvideEndpoint(NetModule instance) {
    return instance.provideEndpoint();
  }
}
