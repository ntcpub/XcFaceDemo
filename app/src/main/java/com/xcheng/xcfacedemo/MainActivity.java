package com.xcheng.xcfacedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xcheng.face.IFaceRecognize;
import com.xcheng.face.IFaceRecord;
import com.xcheng.face.XCFace;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_record:
                XCFace.startRecord(new IFaceRecord() {
                    String allResult = "";
                    @Override
                    public void onSuccess(final String result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView resultTextView = findViewById(R.id.textview_record_result);
                                allResult = result + "\n" + allResult;
                                resultTextView.setText(allResult);
                            }
                        });
                    }

                    @Override
                    public void onFail(String result) {

                    }
                });
                break;

            case R.id.button_recognize:
                XCFace.startRecognize(new IFaceRecognize() {
                    String allResult = "";
                    @Override
                    public void onSuccess(final String result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView resultTextView = findViewById(R.id.textview_recognize_result);
                                allResult = result + "\n" + allResult;
                                resultTextView.setText(allResult);
                            }
                        });
                    }

                    @Override
                    public void onFail(String result) {

                    }
                });
                break;
            case R.id.bt_update_size:
                XCFace.setXcFaceSizeAndCoordinate(500, 500, 200);
                break;
            case R.id.bt_set_data:
                boolean isSuccess = XCFace.setSyncData(getPackageName(), "/sdcard/Download.zip");
                break;
            case R.id.bt_get_data:
                boolean syncData = XCFace.getSyncData();
                break;
        }
    }
}