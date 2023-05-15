package edu.itstep.a08recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {

    private Context context;
    private int resource;
    private List<Contact> listData;
    private LayoutInflater inflater;

    public NumberAdapter(Context context, int resource, List<Contact> listData) {
        this.context = context;
        this.resource = resource;
        this.listData = listData;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View container = inflater.inflate(resource, parent, false);
        NumberViewHolder numberViewHolder = new NumberViewHolder(container);
        return numberViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Contact data = listData.get(position);
        holder.tvData.setText(data.toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditContactActivity.class);
                intent.putExtra("contact-list", (Serializable) listData);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView tvData;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            tvData = itemView.findViewById(R.id.tvData);
        }
    }
}
