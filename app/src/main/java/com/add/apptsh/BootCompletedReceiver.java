
package com.add.apptsh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class BootCompletedReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		Log.i("TAG","收到启动广播");
		Toast.makeText(context,"启动。。。。。。。",Toast.LENGTH_LONG).show();
		Intent autoRun = new Intent(context, MainActivity.class);
		autoRun.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(autoRun);
	}
}