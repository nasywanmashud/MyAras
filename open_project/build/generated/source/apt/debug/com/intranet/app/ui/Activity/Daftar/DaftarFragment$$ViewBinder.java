// Generated code from Butter Knife. Do not modify!
package com.intranet.app.ui.Activity.Daftar;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DaftarFragment$$ViewBinder<T extends com.intranet.app.ui.Activity.Daftar.DaftarFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296388, "field 'txtemail'");
    target.txtemail = finder.castView(view, 2131296388, "field 'txtemail'");
    view = finder.findRequiredView(source, 2131296515, "field 'txtpassword'");
    target.txtpassword = finder.castView(view, 2131296515, "field 'txtpassword'");
    view = finder.findRequiredView(source, 2131296498, "field 'txtnomatrik'");
    target.txtnomatrik = finder.castView(view, 2131296498, "field 'txtnomatrik'");
    view = finder.findRequiredView(source, 2131296628, "field 'txtusername'");
    target.txtusername = finder.castView(view, 2131296628, "field 'txtusername'");
    view = finder.findRequiredView(source, 2131296410, "field 'txtfullname'");
    target.txtfullname = finder.castView(view, 2131296410, "field 'txtfullname'");
    view = finder.findRequiredView(source, 2131296453, "field 'txtlogmasuk'");
    target.txtlogmasuk = finder.castView(view, 2131296453, "field 'txtlogmasuk'");
    view = finder.findRequiredView(source, 2131296360, "field 'btndaftar'");
    target.btndaftar = finder.castView(view, 2131296360, "field 'btndaftar'");
  }

  @Override public void unbind(T target) {
    target.txtemail = null;
    target.txtpassword = null;
    target.txtnomatrik = null;
    target.txtusername = null;
    target.txtfullname = null;
    target.txtlogmasuk = null;
    target.btndaftar = null;
  }
}
