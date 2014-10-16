package com.example.jineshsoni.recievedcallbroadcastlistner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class
		CallReciever  extends BroadcastReceiver {
	String TAG="CALL_RECIEVER";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v(TAG," Recieving Something .. perhaps ");

		if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)) {
			// This code will execute when the phone has an incoming call

			// get the phone number
			String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
			Toast.makeText(context, "Call from:" +incomingNumber, Toast.LENGTH_LONG).show();
			Log.v(TAG," incoming num "+incomingNumber);

		} else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
				TelephonyManager.EXTRA_STATE_IDLE)
				|| intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
				TelephonyManager.EXTRA_STATE_OFFHOOK)) {
			// This code will execute when the call is disconnected
			Log.v(TAG," Call Hunged");
			Toast.makeText(context, "Detected call hangup event", Toast.LENGTH_LONG).show();

		}
	}
}