package com.sashamakkar.medicare;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder>  {


    private Context context;
    ArrayList<Report> reportArrayList;

    public ReportAdapter(ArrayList<Report> reportArrayList) {
        this.reportArrayList = reportArrayList;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater lif = LayoutInflater.from(context);
        View inflatedView = lif.inflate(R.layout.item_report, viewGroup, false);
        return new ReportViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder reportViewHolder, int i) {
        Picasso.get().load(reportArrayList.get(i).getUri()).into(reportViewHolder.imageView);
    }


    @Override
    public int getItemCount() {
        Log.e("TAG", "getItemCount: " + reportArrayList.size());
        return reportArrayList.size();
    }

    public void addNewImage(Uri uri){//Notice this will be an important  function to be used when adding new URis
        reportArrayList.add(new Report(uri));
        notifyDataSetChanged();

    }

    class ReportViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.reportImage);
        }
    }
}
