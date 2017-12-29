// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.Nota;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NotaFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.Nota.NotaFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296454, "field 'listView'");
    target.listView = finder.castView(view, 2131296454, "field 'listView'");
  }

  @Override public void unbind(T target) {
    target.listView = null;
  }
}
