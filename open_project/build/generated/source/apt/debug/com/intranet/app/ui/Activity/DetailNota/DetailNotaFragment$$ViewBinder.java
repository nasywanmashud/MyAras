// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.DetailNota;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DetailNotaFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.DetailNota.DetailNotaFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296609, "field 'txttitle'");
    target.txttitle = finder.castView(view, 2131296609, "field 'txttitle'");
    view = finder.findRequiredView(source, 2131296355, "field 'txtcontent'");
    target.txtcontent = finder.castView(view, 2131296355, "field 'txtcontent'");
  }

  @Override public void unbind(T target) {
    target.txttitle = null;
    target.txtcontent = null;
  }
}
