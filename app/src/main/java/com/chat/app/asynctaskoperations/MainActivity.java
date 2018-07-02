package com.chat.app.asynctaskoperations;

import android.icu.util.Output;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button run,stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        run = findViewById(R.id.btnRun);
        stop = findViewById(R.id.btnStop);

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //operation to start upon trigger

              MyAsyncTask task = new MyAsyncTask();
              task.execute("String one ", "String Two", "String three");



            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //operation to stop upon clicking the stop button

            }
        });



    }


   private class MyAsyncTask extends AsyncTask<String,String,Void>  {


       @Override
       protected Void doInBackground(String... operations) {
           //background operation running

           for (String string : operations) {

              publishProgress(operations);

               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }


           }

           return null;
       }


       @Override
       protected void onProgressUpdate(String... values) {


           super.onProgressUpdate(values);
           //



       }
   }

}
