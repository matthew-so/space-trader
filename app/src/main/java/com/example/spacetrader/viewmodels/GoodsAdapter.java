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
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.views.MarketplaceActivity;
import com.example.spacetrader.views.StartPlayActivity;


import java.util.List;

import static com.example.spacetrader.views.StartPlayActivity.player;

/**
 * GoodsAdapter for Market
 */
public class GoodsAdapter extends
        RecyclerView.Adapter<GoodsAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder{

        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        final TextView planetGoodTextView;
        final Button buy_button;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview

        ViewHolder( View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);


            planetGoodTextView =  itemView.findViewById(R.id.planetGoodTextView);
            buy_button = itemView.findViewById(R.id.buy_button);





        }

    }
    private final List<Good> planetGoods;
    // Used to cache the views within the item layout for fast access


    /**
     * Assigns goods to list
     * @param goods the list of goods
     */
    public GoodsAdapter(List<Good> goods) {
        planetGoods = goods;
    }

    @Override
    public GoodsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.market_goods_layout, parent, false);

        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(final GoodsAdapter.ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        final Good good = planetGoods.get(position);

        final Player myPlayer = StartPlayActivity.game.getPlayer();
        // Set item views based on your views and data model
        TextView textView = viewHolder.planetGoodTextView;
        textView.setText(good.getName() + " [$" + good.getPrice() + "]");
        Button button = viewHolder.buy_button;
        button.setText("Buy");




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (player.buy(planetGoods.get(position))) {
                    viewHolder.buy_button.setEnabled(true);

                     //Updates the Player's inventory when buying a good
                     List<Good> myGoods = myPlayer.getPlayerGoods();
                    MarketplaceActivity.playerAdapter
                            .notifyItemRangeInserted(myGoods.size(), 1);
                    MarketplaceActivity.playerAdapter.notifyItemChanged(myGoods.size());
                    MarketplaceActivity.playerAdapter.notifyDataSetChanged();


                } else {

                     // Buttons are disabled, not allowing the player to buy them anymore.
                     viewHolder.buy_button.setEnabled(false);

                }

                MarketplaceActivity.credits_TextView.setText("$" + myPlayer.getCredits() + "\n" +
                        "Capacity: " + myPlayer.getInventorySpace());

            }
        });
    }


    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return planetGoods.size();
    }

}
