package com.danielminami.memorygameshopify.model;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * This class models Utility and is used to dinamically decide how many cards will be placed
 * for each screen.
 *
 * Cretits: https://stackoverflow.com/a/38472370
 */

public class Utility {

    public static int calculateNoOfColumns(Context context, float columnWidthDp) {

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5);

        return noOfColumns;
    }

}
