package com.example.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travelapp.R;

import java.util.List;

public class TourItemAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<com.example.travelapp.TourItem> tourItemList;

    public TourItemAdapter(Context context, int layout, List<com.example.travelapp.TourItem> tourItemList) {
        this.context = context;
        this.layout = layout;
        this.tourItemList = tourItemList;
    }

    @Override
    public int getCount() {
        return tourItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgTour, imgLocation, imgTime, imgPeople, imgCost;
        TextView txtLocation, txtTime, txtPeople, txtCost;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();

            holder.imgTour = (ImageView) view.findViewById(R.id.imageviewTour);
            holder.imgLocation = (ImageView) view.findViewById(R.id.imageviewLocation);
            holder.imgTime = (ImageView) view.findViewById(R.id.imageviewTime);
            holder.imgPeople = (ImageView) view.findViewById(R.id.imageviewPeople);
            holder.imgCost = (ImageView) view.findViewById(R.id.imageviewCost);
            holder.txtLocation = (TextView) view.findViewById(R.id.textviewLocation);
            holder.txtTime = (TextView) view.findViewById(R.id.textviewTime);
            holder.txtPeople = (TextView) view.findViewById(R.id.textviewPeople);
            holder.txtCost = (TextView) view.findViewById(R.id.textviewCost);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        com.example.travelapp.TourItem tourItem = tourItemList.get(i);

        //holder.imgTour.setImageResource(tourItem.getAvatar());
        holder.imgLocation.setImageResource(R.drawable.pin);
        holder.imgTime.setImageResource(R.drawable.calendar);
        holder.imgPeople.setImageResource(R.drawable.people);
        holder.imgCost.setImageResource(R.drawable.money);
        holder.txtLocation.setText(tourItem.getName());
        holder.txtTime.setText(tourItem.getStartDate() + " - " + tourItem.getEndDate());
        holder.txtPeople.setText(tourItem.getAdults() + " adult(s) - " + tourItem.getChilds() + "child(s)");
        holder.txtCost.setText(tourItem.getMinCost() + " - " + tourItem.getMaxCost());

        return view;
    }

    /*public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        ghiChuList.clear();
        if (charText.length() == 0) {
            ghiChuList.addAll(arraylist);
        } else {
            for (AnimalNames wp : arraylist) {
                if (wp.getAnimalName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    animalNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }*/
}