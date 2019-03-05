package com.example.spacetrader.viewmodels;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.spacetrader.entity.Good;
import com.example.spacetrader.R;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.views.ConfigurationActivity;
import com.example.spacetrader.views.MarketplaceActivity;
import com.example.spacetrader.views.StartPlayActivity;

import java.util.List;

public class GoodsAdapter extends
        RecyclerView.Adapter<GoodsAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder{

        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView planetGoodTextView;
        public Button buy_button;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview

        public ViewHolder( View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);


            planetGoodTextView = (TextView) itemView.findViewById(R.id.planetGoodTextView);
            buy_button = (Button) itemView.findViewById(R.id.buy_button);




        }

    }
    private List<Good> planetGoods;
    // Used to cache the views within the item layout for fast access



    // Pass in the contact array into the constructor
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
        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final GoodsAdapter.ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        final Good good = planetGoods.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.planetGoodTextView;
        SolarSystem curr = StartPlayActivity.game.getPlayer().getCurrentSolarSystem();
        textView.setText(good.getName() + " [$" + curr.getBuyGoodPrice(good) + "]");
        Button button = viewHolder.buy_button;
        button.setText("Buy");

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                StartPlayActivity.player.buy(planetGoods.get(position));
                MarketplaceActivity.credits_TextView.setText("$" + StartPlayActivity.player.getCredits() + "\n" +
                        "Capacity: " + StartPlayActivity.player.getInventorySpace());
                if (StartPlayActivity.player.canBuy(good)) {
                    viewHolder.buy_button.setEnabled(true);
                } else {
                    viewHolder.buy_button.setEnabled(false);
                }
            }
        });
    }


    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return planetGoods.size();
    }
}
