package com.intranet.app.dagger.module;

import android.content.Context;
import com.intranet.app.api.ApiRequestHandler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ApiRequestHandlerFactory implements Factory<ApiRequestHandler> {
  private final NetModule module;

  private final Provider<Context> contextProvider;

  public NetModule_ApiRequestHandlerFactory(NetModule module, Provider<Context> contextProvider) {
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public ApiRequestHandler get() {
    return Preconditions.checkNotNull(
        module.apiRequestHandler(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ApiRequestHandler> create(
      NetModule module, Provider<Context> contextProvider) {
    return new NetModule_ApiRequestHandlerFactory(module, contextProvider);
  }

  /** Proxies {@link NetModule#apiRequestHandler(Context)}. */
  public static ApiRequestHandler proxyApiRequestHandler(NetModule instance, Context context) {
    return instance.apiRequestHandler(context);
  }
}
