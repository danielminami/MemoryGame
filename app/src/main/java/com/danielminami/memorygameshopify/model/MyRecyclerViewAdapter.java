package com.danielminami.memorygameshopify.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.danielminami.memorygameshopify.MainActivity;
import com.danielminami.memorygameshopify.R;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * This class models an Adapter that allows data to be binded to the layout
 *
 * Credit: https://stackoverflow.com/a/40587169
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private Board mBoard;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;
    private CardsClicked cardsClicked = new CardsClicked();
    private CardsClicked cardsMatched = new CardsClicked();

    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, Board board) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mBoard = board;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        /*
        //holder.setIsRecyclable(false);
        //String url = mBoard.get(position).getImageSrc();
        String url = "https://cdn.shopify.com/s/files/1/1000/7970/products/Awesome_20Cotton_20Computer.png?v=1443055821";
        Glide.with(context)
                .load(url)
                .into(holder.imageView);
        */
    }


    @Override
    public int getItemCount() {
        return mBoard.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, getAdapterPosition());

            if (!(cardsMatched.contains(cardsClicked))) {

                // if the number of cards clicked is equals the config file value, then try to match
                if (cardsClicked.size() == 2) {

                    String defaultUrl = "https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Concrete_20Clock.png?v=1443055734";

                    if (mBoard.match(cardsClicked)) {

                        // It is a match! Format the ImageView and remove Listener
                        for (CardsClicked card : cardsClicked) {
                            // grayscale retrieved from https://stackoverflow.com/a/48145049/8695493
                            ColorMatrix colorMatrix = new ColorMatrix();
                            colorMatrix.setSaturation(0);
                            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(colorMatrix);
                            imageView.setColorFilter(filter);

                            Glide.with(context)
                                    .load(card.getCard().getImageSrc())
                                    .useAnimationPool(true)
                                    .into(imageView);

                            //This array keeps track of the Cards are already matched
                            cardsMatched.add(card);
                        }

                    } else {

                        // Reseting the images after clicks when there's no match
                        for (CardsClicked card : cardsClicked)
                            Glide.with(context)
                                    .load(defaultUrl)
                                    .into(card.getImageView());
                    }

                    //Display the Card the user clicked in
                    String url = mBoard.get(getAdapterPosition()).getImageSrc();
                    Glide.with(context)
                            .load(url)
                            .useAnimationPool(true)
                            .into(imageView);

                    //If reaches the number of clicks, clean the selection stack
                    cardsClicked.clear();

                } else {

                    //Still haven't reached the number of picks to try a match.
                    //String url = "https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Concrete_20Clock.png?v=1443055734";
                    String url = mBoard.get(getAdapterPosition()).getImageSrc();
                    Glide.with(context)
                            .load(url)
                            .into(imageView);
                }

                CardsClicked temp = new CardsClicked(mBoard.get(getAdapterPosition()), imageView);
                cardsClicked.add(temp);
            }

        }
    }

    // convenience method for getting data at click position
    public Card getItem(int id) {
        return mBoard.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
