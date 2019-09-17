package com.danielminami.memorygameshopify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
//import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.danielminami.memorygameshopify.model.Board;
import com.danielminami.memorygameshopify.model.Card;
import com.danielminami.memorygameshopify.model.Config;
import com.danielminami.memorygameshopify.model.MyRecyclerViewAdapter;
import com.danielminami.memorygameshopify.model.ProductClient;
import com.danielminami.memorygameshopify.model.ProductList;
import java.util.Collections;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author Daniel Minami
 */
public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    //private static final String TAGMINAMI= MainActivity.class.getSimpleName();
    private MyRecyclerViewAdapter adapter;
    private Board board;
    private Spinner spinnerNumCards;
    private Spinner spinnerPairsOf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Config.getConfig();
        spinnerNumCards = findViewById(R.id.spinnerNumOfCards);
        spinnerPairsOf = findViewById(R.id.spinnerPairsOf);

        ArrayAdapter<String> adapterPairsOf = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.pairs_of));
        spinnerPairsOf.setAdapter(adapterPairsOf);

        ArrayAdapter<String> adapterNumCards = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.num_cards));
        spinnerNumCards.setAdapter(adapterNumCards);


        final Button button = findViewById(R.id.btnStart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loadImages();
            }
        });

    }

    public void loadImages() {

        TextView txtMoves = findViewById(R.id.txtPlayerMoves);
        TextView txtMatches = findViewById(R.id.txtMatches);
        txtMoves.setText("0");
        txtMatches.setText("0");

        /* Sets configuration into the Singleton */

        Config.getConfig().setPairsToMatch(Integer.valueOf(spinnerNumCards.getItemAtPosition
                (spinnerNumCards.getSelectedItemPosition()).toString()));

        Config.getConfig().setNumOfMatchesPerGame(Integer.valueOf(spinnerPairsOf.getItemAtPosition
                (spinnerPairsOf.getSelectedItemPosition()).toString()));

        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl(Config.getEndPoint()).
                addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        ProductClient productClient = retrofit.create(ProductClient.class);

        /* Retrofit Asynchronous Call */
        Call<ProductList> call = productClient.getProductList();
        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                ProductList productList = response.body();
                //Log.d(TAGMINAMI, productList.toString());
                RecyclerView recyclerView = findViewById(R.id.rvCards);

                Board tempBoard = new Board();

                /* populates the board with the cards */
                for (int i = 0; i < Config.getPairsToMatch() + 1; i++) {
                    if (i != 10) {
                        Card card = new Card(i,
                                productList.getProducts().get(i).getImage().getSrc());
                        tempBoard.add(card);
                    }
                }

                /* Creates the Board with shuffled Cards*/
                board = new Board(tempBoard);
                Collections.shuffle(board);

                /* Sets number of Columns */
                int numberOfColumns = Config.calculateNoOfColumns(getApplicationContext());
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,
                        numberOfColumns));

                /* Binds the data into the view */
                adapter = new MyRecyclerViewAdapter(MainActivity.this, board);
                adapter.setClickListener(MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            /* In case of failure on loading the JSON */
            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error reading data.",
                        Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

    }

    @Override
    public void onItemClick(View view, int position) {
        // Used for debugging
        //Log.i(TAGMINAMI, "Clicked: " + adapter.getItem(position) + " position " + position);
    }

}
