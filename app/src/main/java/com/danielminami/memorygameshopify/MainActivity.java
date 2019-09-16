package com.danielminami.memorygameshopify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.danielminami.memorygameshopify.model.Board;
import com.danielminami.memorygameshopify.model.Card;
import com.danielminami.memorygameshopify.model.CardList;
import com.danielminami.memorygameshopify.model.Image;
import com.danielminami.memorygameshopify.model.MyRecyclerViewAdapter;
import com.danielminami.memorygameshopify.model.ProductClient;
import com.danielminami.memorygameshopify.model.ProductList;
import com.danielminami.memorygameshopify.model.Utility;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    private static final int COLUMNS_SIZE = 50;
    private static final int PAIRS = 10;
    private static final String TAGMINAMI= MainActivity.class.getSimpleName();
    MyRecyclerViewAdapter adapter;
    public static final String ENDPOINT = "https://shopicruit.myshopify.com/";
    public CardList cardList = new CardList();
    public Board board;
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadImages();



        // data to populate the RecyclerView with
        //String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48"};


        // set up the RecyclerView
        /*
        RecyclerView recyclerView = findViewById(R.id.rvNumbers);

        int numberOfColumns = Utility.calculateNoOfColumns(getApplicationContext(), COLUMNS_SIZE);
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        /*

        /*
        Reference to this layout credit to:

        https://stackoverflow.com/questions/40587168/simple-android-grid-example-using-recyclerview-with-gridlayoutmanager-like-the

         */



        /*
        for (int i = 0; i < 1; i++) {
            Button btn = new Button(this);
            btn.setText("Button " + i);
            btn.setLayoutParams(params);
        }
        */

        /*
        final ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(160, 160));

        final Integer imgResId = R.drawable.ic_launcher_background;
        final Integer[] resId = {imgResId};
        imageView.setImageResource(imgResId);


        Button button = findViewById(R.id.button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resId[0] = (resId[0] == R.drawable.ic_launcher_background) ? R.mipmap.ic_launcher : R.drawable.ic_launcher_background;
                    imageView.setImageResource(resId[0]);
                }
            });
        }


        LinearLayout linearLayout = findViewById(R.id.rootContainer);


        // Add ImageView to LinearLayout
        if (linearLayout != null) {
            linearLayout.addView(imageView);
        }
        */

    }


    public void loadImages() {

        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl(ENDPOINT).
                addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        ProductClient productClient = retrofit.create(ProductClient.class);
        Call<ProductList> call = productClient.getProductList();
        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                ProductList productList = response.body();
                //Log.d(TAGMINAMI, productList.toString());
                RecyclerView recyclerView = findViewById(R.id.rvNumbers);



                for (int i = 0; i < 15+1; i++) {

                    if (i != 10) {
                        Card card = new Card(i, productList.getProducts().get(i).getImage().getSrc());
                        cardList.add(card);
                    }



                }

                board = new Board(cardList);

                Collections.shuffle(board);

                //String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

                int numberOfColumns = Utility.calculateNoOfColumns(getApplicationContext(), COLUMNS_SIZE);
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, numberOfColumns));
                adapter = new MyRecyclerViewAdapter(MainActivity.this, board);
                adapter.setClickListener(MainActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error reading data.", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
    }

    public void showToast(View view) {

        Log.d(TAGMINAMI, "Button was clicked");


    }

}
