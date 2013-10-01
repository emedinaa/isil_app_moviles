package com.isil.isilpractica01;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class ToastAlertUtils {
	
	public static void make(Context context,String msg)
	{
		Log.v("CONSOLE",msg);
		Toast toast=Toast.makeText(context, msg, Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.show();
	}

}
