package com.intranet.app.dagger.module;

import com.squareup.otto.Bus;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideBusFactory implements Factory<Bus> {
  private final NetModule module;

  public NetModule_ProvideBusFactory(NetModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Bus get() {
    return Preconditions.checkNotNull(
        module.provideBus(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Bus> create(NetModule module) {
    return new NetModule_ProvideBusFactory(module);
  }

  /** Proxies {@link NetModule#provideBus()}. */
  public static Bus proxyProvideBus(NetModule instance) {
    return instance.provideBus();
  }
}
