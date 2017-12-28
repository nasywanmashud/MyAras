// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.HomePage;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HomePageFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.HomePage.HomePageFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296502, "field 'btnnota'");
    target.btnnota = finder.castView(view, 2131296502, "field 'btnnota'");
    view = finder.findRequiredView(source, 2131296628, "field 'username'");
    target.username = finder.castView(view, 2131296628, "field 'username'");
  }

  @Override public void unbind(T target) {
    target.btnnota = null;
    target.username = null;
  }
}
