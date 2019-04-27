package com.sashamakkar.medicare;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PrescriptionAdapter extends RecyclerView.Adapter<PrescriptionAdapter.PrescritionViewHolder>  {

    private Context context;
    ArrayList<Prescription> prescriptionArrayList;

    public PrescriptionAdapter(ArrayList<Prescription> prescriptionArrayList) {
        this.prescriptionArrayList = prescriptionArrayList;
    }

    @NonNull
    @Override
    public PrescritionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater lif = LayoutInflater.from(context);
        View inflatedView = lif.inflate(R.layout.item_presc, viewGroup,false);
        return new PrescritionViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull PrescritionViewHolder prescritionViewHolder, int i) {
        Picasso.get().load(prescriptionArrayList.get(i).getUri()).into(prescritionViewHolder.imageView);
    }


    @Override
    public int getItemCount() {
        return prescriptionArrayList.size();
    }

    public void addNewImage(Uri uri){//Notice this will be an important  function to be used when adding new URis
        prescriptionArrayList.add(new Prescription(uri));
        notifyDataSetChanged();

    }

    class PrescritionViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public PrescritionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.prescImage);
        }
    }
}
