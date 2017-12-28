package com.intranet.app.ui.Activity.Nota;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Model.Receive.Nota;
import com.intranet.app.ui.Model.Receive.NotaReceive;
import com.intranet.app.ui.Presenter.Presenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;


/**
 * This class allow user to log in the app
 */
public class NotaFragment extends BaseFragment  {


    @Inject
    Presenter presenter;

    @Inject
    Bus bus;

   NotaAdapter adapter;

   @Bind(R.id.listview)
    ListView listView;



   ArrayList<Nota> Notaa = new ArrayList<>();

    private SharedPrefManager pref;

    public static NotaFragment newInstance(Bundle bundle) {

        NotaFragment fragment = new NotaFragment();
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

        View view = inflater.inflate(R.layout.activity_nota, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();

        pref = new SharedPrefManager(getActivity());

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar100);
        toolbar.setTitle("Nota");
        toolbar.setTitleTextColor(Color.parseColor("#FBFCFC"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        HashMap<String, String> stringObject = pref.getstringObject();
        final String sobject = stringObject.get(SharedPrefManager.STRINGOBJECT);
        Log.e("test", String.valueOf(stringObject));

        Gson gson = new Gson();
        NotaReceive obj = gson.fromJson(sobject , NotaReceive.class);


            for (int v = 0 ; v < obj.getNota().size(); v++) {

                //Log.e("jayee", obj.getDetails().get(v).getTitle());

                Nota nota = new Nota();
                nota.setTajuk(obj.getNota().get(v).getTajuk());
                nota.setContent(obj.getNota().get(v).getContent());
                Notaa.add(nota);

                adapter = new NotaAdapter(getActivity(), obj);

                listView.setAdapter(adapter);

//                lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//                        pref.setContentrefid(obj.getDetails().get(position).getContentRefId());
//                        Intent in = new Intent(getActivity(), DataNewsActivity.class);
//
//                        startActivity(in);
//
//                    }
//                });
            }


        return view;
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
                    LoginReceive obj = gson.fromJson(result.get(0).getCachedResult(), LoginReceive.class);
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
