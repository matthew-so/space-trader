package com.example.spacetrader.viewmodels;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.spacetrader.entity.Good;
import com.example.spacetrader.R;
import com.example.spacetrader.views.MarketplaceActivity;
import com.example.spacetrader.views.StartPlayActivity;

import java.util.List;

import static com.example.spacetrader.views.StartPlayActivity.player;

/**
 * This class represents the PlayerGoods Adapter
 */
public class PlayerGoodsAdapter extends
        RecyclerView.Adapter<PlayerGoodsAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        final TextView playerGoodTextview;
        final Button sell_Button;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
         ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            playerGoodTextview =  itemView.findViewById(R.id.playerGoodTextview);
            sell_Button = itemView.findViewById(R.id.sell_Button);
        }
    }
    private final List<Good> playerGoods;


    // Pass in the contact array into the constructor

    /**
     * The constructor for the Player Goods Adaptor
     * @param goods the contact array for the goods
     */
    public PlayerGoodsAdapter(List<Good> goods) {
        playerGoods = goods;
    }
    @Override
    public PlayerGoodsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView1 = inflater.inflate(R.layout.player_goods_layout, parent, false);

        // Return a new holder instance
        return  new PlayerGoodsAdapter.ViewHolder(contactView1);

    }

    @Override
    public void onBindViewHolder(final PlayerGoodsAdapter.ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        final Good playerGood = playerGoods.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.playerGoodTextview;
        textView.setText(playerGood.getName()+ " [$"+ playerGood.getPrice()+"]");
        final Button button = viewHolder.sell_Button;
        button.setText("Sell");
        if (StartPlayActivity.player.canSell(playerGood)) {
            button.setEnabled(true);
        } else {
            button.setEnabled(false);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playerGoods.isEmpty() && player.sell(playerGoods.get(position))) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                    playerGoods.remove(position);
                    notifyItemRemoved(position);
                    notifyItemChanged(position);
                    notifyDataSetChanged();
                }
                MarketplaceActivity.credits_TextView.setText("$" + player.getCredits() + "\n" +
                        "Capacity: " + player.getInventorySpace());

        }

        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return playerGoods.size();
    }


}
