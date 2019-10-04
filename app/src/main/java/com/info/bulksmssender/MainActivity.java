/* Copyright (C) 2016 CodingInfinite Technologies - All Rights Reserved
 * NOTICE:  All information contained herein is, and remains
 * the property of CodingInfinite Technologies and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to CodingInfinite Technologies
 * and its suppliers and may be covered by Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from CodingInfinite Technologies.
 */


package com.info.bulksmssender;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.info.bulksmssender.api.APIClient;
import com.info.bulksmssender.callback.APICallback;
import com.info.bulksmssender.callback.APIResponseCallback;
import com.info.bulksmssender.model.APIResponse;
import com.info.bulksmssender.model.ContactNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    ImageButton sendSMSBtn;
    EditText smsMessageET;
    ListView nmbrsList;
    int i = 0;
    PendingIntent sentPI;
    protected PowerManager.WakeLock mWakeLock;
    public static int limit = 95, pause = 3;
    private Runnable runnableCode;
    Handler handler;
    ProgressDialog progressBar;
    ArrayList<String> numbers = new ArrayList<>();
    ArrayList<String> numbersToDisplay = new ArrayList<>();
    BroadcastReceiver broadcastReceiver;
    Button btnReset;
    TextView txtLastIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        handler = new Handler();
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(false);
        progressBar.setMessage("SMS Sending...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);

        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "Sender::MyWakelockTag");
        this.mWakeLock.acquire();

        getContact();
        nmbrsList = findViewById(R.id.listView1);
        sendSMSBtn = findViewById(R.id.btnSendSMS);
        btnReset=findViewById(R.id.btnReset);
        txtLastIndex=findViewById(R.id.txtLastIndex);
        txtLastIndex.setText("Last Index: "+PreferenceHelper.getSharedPreferenceInt(this,PreferenceHelper.LAST_INDEX,0));

        sendSMSBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                smsMessageET = findViewById(R.id.editText1);
                if (smsMessageET.getText().toString().isEmpty())
                    Toast.makeText(getBaseContext(), "Message can not be empty!", Toast.LENGTH_SHORT).show();
                else
                    sendSMS();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceHelper.setSharedPreferenceInt(MainActivity.this,PreferenceHelper.LAST_INDEX,0);
                txtLastIndex.setText("Last Index: "+PreferenceHelper.getSharedPreferenceInt(MainActivity.this,PreferenceHelper.LAST_INDEX,0));
            }
        });

    }

    private void getContact() {
        Call<APIResponse<ContactNumber>> call = APIClient.getAPIInterface().getNumber();
        APIResponseCallback.callAPI(call, new APICallback<ContactNumber>() {
            @Override
            public void onSuccessfulResponse(List<ContactNumber> contactNumbers) {
                contactNumbers.addAll(contactNumbers);
                contactNumbers.addAll(contactNumbers);
                contactNumbers.addAll(contactNumbers);
                contactNumbers.addAll(contactNumbers);
                contactNumbers.addAll(contactNumbers);

                for (int i = 0; i < contactNumbers.size(); i++) {
                    ContactNumber contactNumber = contactNumbers.get(i);
                    numbersToDisplay.add(contactNumber.getShopName() + "\n" + contactNumber.getMobileNumber());
                    numbers.add(contactNumber.getMobileNumber()+i + "");
                }

                String[] namesArr = numbersToDisplay.toArray(new String[numbersToDisplay.size()]);
                ArrayAdapter<String> adaptr = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, namesArr);
                nmbrsList.setAdapter(adaptr);

            }
        }, this);
    }

    protected void sendSMS() {
        String SENT = "SENT_SMS_ACTION";

        sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                i++;
                PreferenceHelper.setSharedPreferenceInt(MainActivity.this, PreferenceHelper.LAST_INDEX, i);

                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(MainActivity.this, "SMS send", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic failure",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No service",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio off",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter(SENT));
        progressBar.setMax(numbers.size());
        progressBar.show();

        setMessageSendTimer();
    }

    public void setMessageSendTimer() {

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        i = PreferenceHelper.getSharedPreferenceInt(MainActivity.this, PreferenceHelper.LAST_INDEX, 0);
                        txtLastIndex.setText("Last Index: "+i);

                        if (i < numbers.size()) {
                            progressBar.setProgress(i);
                            sendIt();
                        } else {
                            progressBar.dismiss();
                            Toast.makeText(getBaseContext(), "All SMS Sent", Toast.LENGTH_SHORT).show();
                            t.cancel();
                        }
                    }
                });
            }

        }, 0, 5000);
    }

    void sendIt() {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numbers.get(i), null, smsMessageET.getText().toString(), sentPI, null);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "failed to " + numbers.get(i), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroy() {

        if (broadcastReceiver != null)
            unregisterReceiver(broadcastReceiver);
        this.mWakeLock.release();
        super.onDestroy();
    }
}
