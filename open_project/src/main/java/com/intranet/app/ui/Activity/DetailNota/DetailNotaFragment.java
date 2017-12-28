package com.intranet.app.ui.Activity.DetailNota;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Model.Receive.DetailNotaReceive;
import com.intranet.app.ui.Model.Request.DetailNotaRequest;
import com.intranet.app.ui.Presenter.Presenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by Me-Tech on 9/26/2017.
 */
public class DetailNotaFragment extends BaseFragment {


    @Inject
    Presenter presenter;

    @Inject
    Bus bus;


    @Bind(R.id.title)
    TextView txttitle;

    @Bind(R.id.content)
    TextView txtcontent;


    private SharedPrefManager pref;

    public static DetailNotaFragment newInstance(Bundle bundle) {

        DetailNotaFragment fragment = new DetailNotaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainApplication.component(getActivity()).inject(this);
        RealmObjectController.clearCachedResult(getActivity());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_datanews_list, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();

        pref = new SharedPrefManager(getActivity());

        String id = bundle.getString("id");

        datanewsfromfragment(id);


        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar3);
        toolbar.setTitle("News");
        toolbar.setTitleTextColor(Color.parseColor("#FBFCFC"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent in = new Intent(getActivity(),Main3Activity.class);
//                startActivity(in);
                getActivity().finish();
            }
        });

//        setSupportActionBar(toolbar);
        return view;
    }

    private void datanewsfromfragment(String id) {
        //request api
        initiateLoading(getActivity());
        DetailNotaRequest datanewsData = new DetailNotaRequest();
        datanewsData.setId(id);

        presenter.onDetailNota(datanewsData);
    }

    @Subscribe
    public void onDataNewsSuccess(DetailNotaReceive obj) {
        dismissLoading();

        if (obj.getStatus().equals("True") ) {

            txttitle.setText(obj.getTajuk());
            txtcontent.setText(obj.getContent());

//            txtcontent.setText(Html.fromHtml(obj.getContent().replaceAll("</br>", "<p>")));
//            txtcontent.setLinksClickable(true);
//            txtcontent.setLinkTextColor(ContextCompat.getColor(getActivity(), R.color.textLinkColor));
//            txtcontent.setMovementMethod(LinkMovementMethod.getInstance());


        } else {

        }

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
        bus.register(this);

        RealmResults<CachedResult> result = RealmObjectController.getCachedResult(MainFragmentActivity.getContext());
        if (result.size() > 0) {

            Gson gson = new Gson();
            if (result.get(0).getCachedAPI() != null) {
                if (result.get(0).getCachedAPI().equals("Clock")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());
//                    ClockReceive obj = gson.fromJson(result.get(0).getCachedResult(), ClockReceive.class);
                    // onClockSuccess(obj);

//                }   else if (result.get(0).getCachedAPI().equals("GetAllData")) {
//                    Log.e("CachedData", result.get(0).getCachedResult().toString());
//
                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
        bus.unregister(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
