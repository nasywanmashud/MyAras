package com.intranet.app.ui.Activity.Nota;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.intranet.app.R;
import com.intranet.app.ui.Model.Receive.NotaReceive;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Me-Tech on 9/19/2017.
 */

public class NotaAdapter extends BaseAdapter {

    private Activity mContext;

    NotaReceive Details;

    public NotaAdapter(Activity mContext, NotaReceive DetailList) {
        this.mContext = mContext;
        this.Details = DetailList;
    }

    @Override
    public int getCount() {
        return Details.getNota().size();
        //return Details.get(0).getDetails().size();
    }

    @Override
    public Object getItem(int position) {
        return Details.getNota().get(position);
        //return Details.get(position).getDetails().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        @Bind(R.id.title)
        TextView txttitle;

        @Bind(R.id.content)
        TextView txtcontent;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_nota, parent, false);
            vh = new ViewHolder();
            ButterKnife.bind(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        //Set text for TextView
        vh.txttitle.setText(Details.getNota().get(position).getTajuk());
        vh.txtcontent.setText(Details.getNota().get(position).getContent());

       // vh.txttitle.setText(Details.get(position).getDetails().get(position).getTitle());
        //vh.txtabstract.setText(Details.get(position).getDetails().get(position).getAbstract());


        return view;

        //save product id to tag
    }

}


