package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.JsonBean;
import com.example.caohaoran0102.MainActivity;
import com.example.caohaoran0102.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private JsonBean jsonBean;

    public MyAdapter(Context context, JsonBean jsonBean) {
        this.context = context;
        this.jsonBean = jsonBean;
    }


    @Override
    public int getCount() {
        return jsonBean.getData().getTuijian().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return jsonBean.getData().getTuijian().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.layout_list, null);
            holder= new ViewHolder();
            holder.title=convertView.findViewById(R.id.title);
           // holder.price=convertView.findViewById(R.id.price);
            holder.detailUrl=convertView.findViewById(R.id.images);
            convertView.setTag(holder);
        }else {
             holder = (ViewHolder) convertView.getTag();
        }
        //赋值
        holder.title.setText(jsonBean.getData().getTuijian().getList().get(position).getTitle());
        holder.price.setText("￥"+jsonBean.getData().getMiaosha().getList().get(position).getPrice()+"");
        ImageLoader.getInstance().displayImage(jsonBean.getData().getMiaosha().getList().get(position).getDetailUrl(),holder.detailUrl);
        return convertView;
    }
    class ViewHolder{
        ImageView detailUrl;
        TextView title,price;
    }
}
