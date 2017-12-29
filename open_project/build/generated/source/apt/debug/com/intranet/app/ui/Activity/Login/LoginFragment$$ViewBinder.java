// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.Login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.Login.LoginFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296623, "field 'txtLoginEmail'");
    target.txtLoginEmail = finder.castView(view, 2131296623, "field 'txtLoginEmail'");
    view = finder.findRequiredView(source, 2131296624, "field 'txtLoginPassword'");
    target.txtLoginPassword = finder.castView(view, 2131296624, "field 'txtLoginPassword'");
    view = finder.findRequiredView(source, 2131296313, "field 'btnLogin'");
    target.btnLogin = finder.castView(view, 2131296313, "field 'btnLogin'");
    view = finder.findRequiredView(source, 2131296363, "field 'txtdaftar'");
    target.txtdaftar = finder.castView(view, 2131296363, "field 'txtdaftar'");
  }

  @Override public void unbind(T target) {
    target.txtLoginEmail = null;
    target.txtLoginPassword = null;
    target.btnLogin = null;
    target.txtdaftar = null;
  }
}
