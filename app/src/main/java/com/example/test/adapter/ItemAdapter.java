package com.example.test.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R;
import com.example.test.model.Item;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        //set data
        holder.titleTextView.setText(item.getTitle());
        holder.buyDateTextView.setText(item.getSBuydate());
        holder.buyDayTextView.setText("0");
        holder.profitLossTextView.setText(Float.toString(item.getProfitLoss()));
        holder.returnRateTextView.setText(Float.toString(item.getReturnRate()));
        holder.evaluationAmountTextView.setText("0");
        holder.purchaseAmountTextView.setText("0");

        if (item.getReturnRate() > 0) {
            holder.returnRateTextView.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.red));
        } else if (item.getReturnRate() == 0) {
            holder.returnRateTextView.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.black));
        } else {
            holder.returnRateTextView.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.blue));
        }

        if (item.getProfitLoss() > 0) {
            holder.profitLossTextView.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.red));
        } else if (item.getProfitLoss() == 0) {
            holder.profitLossTextView.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.black));
        } else {
            holder.profitLossTextView.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.blue));
        }


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView buyDateTextView;
        TextView buyDayTextView;
        TextView profitLossTextView;
        TextView returnRateTextView;
        TextView evaluationAmountTextView;
        TextView purchaseAmountTextView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.stockTitle);
            buyDateTextView = itemView.findViewById(R.id.buydate);
            buyDayTextView = itemView.findViewById(R.id.buyday);
            profitLossTextView = itemView.findViewById(R.id.ProfitLoss);
            returnRateTextView = itemView.findViewById(R.id.returnRate);
            evaluationAmountTextView = itemView.findViewById(R.id.evaluationAmount);
            purchaseAmountTextView = itemView.findViewById(R.id.purchaseAmount);
        }
    }
}
