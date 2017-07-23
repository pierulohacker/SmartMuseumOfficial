package uniba.pierpaolomasella.myapplication;

import android.content.Intent;
import android.database.CursorJoiner;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.io.*;
import com.google.zxing.Result;

import org.json.JSONArray;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements  ZXingScannerView.ResultHandler{
    String id;
    private Vibrator vib ;
    private ZXingScannerView scannerView;
    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vib = (Vibrator)this.getSystemService(VIBRATOR_SERVICE);
    }

    class BackgroundTask extends AsyncTask<Void,Void,String>
    {
        String JSON_STRING;
        String json_url;

        @Override
        protected void onPreExecute()
        {
            json_url = "http://smartmuseum1.altervista.org/opereall.php";

        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while( (JSON_STRING = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(JSON_STRING+"\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
//            TextView textView = (TextView)findViewById(R.id.showJ);
//            textView.setText(result);
            json_string = result;
            parseJSON();
        }
    }
    //public void parseJSON(View view)
    public void parseJSON()
    {
      if(json_string ==null || json_string.length()==0)
       {
            Toast.makeText(getApplicationContext(),"Database vuoto", Toast.LENGTH_LONG).show();

        }
       else
       {
           Toast.makeText(getApplicationContext(),"Tuple trovate", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, DisplayListView.class);
            intent.putExtra("json_data", json_string);
           intent.putExtra("id", id);
            startActivity(intent);
        }
    }

    public void getJson()
    {
        new BackgroundTask().execute();
    }

    public void scanCode (View view)
    {

        scannerView =  new ZXingScannerView(getApplicationContext());
        scannerView.setResultHandler(this);
        setContentView(scannerView);
        vib.vibrate(200);
        scannerView.startCamera();

     }

     @Override
     public void onPause()
     {
         super.onPause();
         scannerView.stopCamera();

     }

    @Override
    public void handleResult(Result result)
    {
        vib.vibrate(200);
        id = (result.getText()); //prendo l'id scannerizzato dal qrcode


        Toast.makeText(MainActivity.this, id, Toast.LENGTH_SHORT).show(); //permette di visualizzare cosa si è letto dal QRcode
        scannerView.stopCamera();
        this.getJson();

//        Intent intent = new Intent(this, DisplayListView.class);
//        //intent.putExtra("json_data", json_string);
//        intent.putExtra("json_data", Integer.parseInt(result.getText()));
//        scannerView.stopCamera();
      //  startActivity(intent);


    }



}
