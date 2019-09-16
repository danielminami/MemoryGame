package com.danielminami.memorygameshopify.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.danielminami.memorygameshopify.R;


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
    private int playerMoves = 0;
    private int playerMatches = 0;

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

    }


    @Override
    public int getItemCount() {
        return mBoard.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        private TextView txtMoves = (TextView)((Activity)context).findViewById(R.id.txtPlayerMoves);
        private TextView txtMatches = (TextView)((Activity)context).findViewById(R.id.txtMatches);
        /* Credit: https://stackoverflow.com/a/42868303/8695493 */
        private int defaultImg = context.getResources().getIdentifier("@mipmap/ic_launcher",
                "drawable", context.getPackageName());

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, getAdapterPosition());

            // Flag to control if the Card was already clicked
            boolean skipClick = false;

            /*
             Getting user click and to check whether this cell was already clicked
             */
            CardsClicked temp = new CardsClicked(mBoard.get(getAdapterPosition()), imageView,
                    getAdapterPosition());

            /*
            Skip click if clicking the same card as clicked before
             */
            if (cardsClicked.size() > 0) {
                for (CardsClicked card: cardsClicked) {
                    if (card.getPosition() == temp.getPosition()){
                        skipClick = true;
                    }
                }
            }

            /*
            Skip click if the card has been already matched
             */
            if (cardsMatched.size() > 0) {

                for (CardsClicked found : cardsMatched) {
                    if (found.getCard().getId() == temp.getCard().getId()) {
                        skipClick = true;
                    }
                }

            }

            /*
            If its a valid click movement checks:
                1. Cleans the screen if that is needed
                2. Cleans the control array
                3. Add the valid click
                4. Binds the image into the Screen
                5. Tests for the right matching size
                6. Tests the current click if there's a match
                7. Format the Cards in the Board that had the match and add to matched array
                8. Refresh current control and update results at the Screen
                9. Check for winning condition
                10. Dysplay Winner
             */
            if (!skipClick) {

                /*
                1. Cleans the screen if that is needed
                2. Cleans the control array
                */
                if (cardsClicked.size() == 2) {
                    for (CardsClicked card : cardsClicked) {
                        Glide.with(context)
                                .load(defaultImg)
                                .into(card.getImageView());
                    }
                    cardsClicked.clear();
                }

                /* 3. Adding valid Click */
                cardsClicked.add(temp);

                /* 4. Binds the image into the Screen */
                String url = mBoard.get(getAdapterPosition()).getImageSrc();
                Glide.with(context)
                        .load(url)
                        .into(imageView);

                /* 5. Tests for the right matching size */
                if (cardsClicked.size() == 2) {
                    /* 6. Tests the current click if there's a match */
                    if (mBoard.match(cardsClicked)) {
                        /* 7. Format the Cards in the Board that had the match and add
                            to matched array
                         */
                        for (CardsClicked card : cardsClicked) {
                            /*  Credits: https://stackoverflow.com/a/48145049/8695493*/
                            ColorMatrix colorMatrix = new ColorMatrix();
                            colorMatrix.setSaturation(0);
                            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(colorMatrix);
                            card.getImageView().setColorFilter(filter);

                            Glide.with(context)
                                    .load(card.getCard().getImageSrc())
                                    .into(card.getImageView());

                            cardsMatched.add(card);
                            txtMoves.setText(String.valueOf(++playerMoves));

                        }
                        /* 8. Refresh current control and update results at the Screen */
                        cardsClicked.clear();
                        txtMatches.setText(String.valueOf(++playerMatches));
                        /* Credits: https://stackoverflow.com/a/10996569/8695493 */



                        /* 9. Check for winning condition */
                        /* 10. Dysplay Winner */
                    } else {
                        txtMoves.setText(String.valueOf(++playerMoves));
                    }

                    //If reaches the number of clicks, clean the selection stack

                }
            }
        }
    } //end of ViewHolder class

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
