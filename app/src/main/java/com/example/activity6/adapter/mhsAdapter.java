package com.example.activity6.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activity6.R;
import com.example.activity6.database.Mahasiswa;

import java.util.ArrayList;

public class mhsAdapter extends RecyclerView.Adapter<mhsAdapter.mhsViewHolder> {
    private ArrayList<Mahasiswa> listData;

    public mhsAdapter(ArrayList<Mahasiswa> listData) {
        this.listData = listData;
    }

    @Override
    public mhsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_mhs,parent,false);
        return new mhsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mhsViewHolder holder, int position) {
        String nm, tlp;

        nm = listData.get(position).getNama();
        tlp = listData.get(position).getTelepon();

        holder.txtNama.setTextColor(Color.BLUE);
        holder.txtNama.setTextSize(20);
        holder.txtNama.setText(nm);
        holder.txtTelepon.setText(tlp);
    }

    @Override
    public int getItemCount() {
        return (listData != null)?listData.size() : 0;
    }

    public class mhsViewHolder extends RecyclerView.ViewHolder {
        private CardView cardKu;
        private TextView txtNama, txtTelepon;

        public mhsViewHolder(View view) {
            super(view);
            cardKu = (CardView) view.findViewById(R.id.myCard);
            txtNama = (TextView) view.findViewById(R.id.textNama);
            txtTelepon = (TextView) view.findViewById(R.id.textTelepon);
        }
    }
}
