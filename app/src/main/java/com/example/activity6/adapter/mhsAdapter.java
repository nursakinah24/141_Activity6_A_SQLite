package com.example.activity6.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activity6.MainActivity;
import com.example.activity6.R;
import com.example.activity6.database.Mahasiswa;
import com.example.activity6.database.dbController;
import com.example.activity6.editMahasiswa;

import java.util.ArrayList;
import java.util.HashMap;

public class mhsAdapter extends RecyclerView.Adapter<mhsAdapter.mhsViewHolder> {
    private ArrayList<Mahasiswa> listData;
    private Context control;

    public mhsAdapter(ArrayList<Mahasiswa> listData) {
        this.listData = listData;
    }

    @Override
    public mhsAdapter.mhsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_mhs,parent,false);
        control = parent.getContext();
        return new mhsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(mhsAdapter.mhsViewHolder holder, int position) {
        String nm, tlp, nim;

        nim = listData.get(position).getNim();
        nm = listData.get(position).getNama();
        tlp = listData.get(position).getTelepon();
        dbController db = new dbController(control);

        holder.txtNama.setTextColor(Color.BLUE);
        holder.txtNama.setTextSize(20);
        holder.txtNama.setText(nm);
        holder.txtTelepon.setText(tlp);

        holder.cardKu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(control, holder.cardKu);
                popupMenu.inflate(R.menu.menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.mnEdit:
                                Intent i = new Intent(control, editMahasiswa.class);
                                i.putExtra("nim", nim);
                                i.putExtra("nama", nm);
                                i.putExtra("telepon", tlp);
                                control.startActivity(i);
                                break;
                            case R.id.mnHapus:
                                HashMap<String, String> values = new HashMap<>();
                                values.put("nim", nim);
                                db.DeleteData(values);
                                Intent ii = new Intent(control, MainActivity.class);
                                control.startActivity(ii);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
                return false;
            }
        });
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
