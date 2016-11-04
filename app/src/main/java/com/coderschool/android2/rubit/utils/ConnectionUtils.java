/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by <tien.workinfo@gmail.com - rubit1359@gmail.com - manetivinay@gmail.com>, October 2016
 */

package com.coderschool.android2.rubit.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentManager;

import com.coderschool.android2.rubit.R;
import com.coderschool.android2.rubit.connectionDialog.ConnectionDialogFragment;
import com.coderschool.android2.rubit.constants.IntentConstants;

/**
 * {@link ConnectionUtils} holds the Configuration functions
 *
 * @author TienVNguyen
 */
public class ConnectionUtils {

    /**
     * verify connection dialog
     *
     * @param context         {@link Context}
     * @param fragmentManager {@link FragmentManager}
     * @return {@link Boolean}
     */
    public static boolean verifyConnectionDialog(final Context context, final FragmentManager fragmentManager) {
        if (isConnected(context)) {
            return true;
        } else {
            final ConnectionDialogFragment connectionDialogFragment = ConnectionDialogFragment.newInstance(
                    fragmentManager, context.getString(R.string.text_connection_error_title));
            connectionDialogFragment.show(fragmentManager, IntentConstants.DIALOG_CONNECTION_TAG);
            return false;
        }
    }

    /**
     * is connected
     *
     * @param context {@link Context}
     * @return {@link Boolean}
     */
    public static boolean isConnected(final Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return null != networkInfo && networkInfo.isConnected();
    }
}
