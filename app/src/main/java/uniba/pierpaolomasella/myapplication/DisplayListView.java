package uniba.pierpaolomasella.myapplication;

import android.speech.tts.TextToSpeech;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.BaseMovementMethod;
import android.text.method.ScrollingMovementMethod;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class DisplayListView extends AppCompatActivity {
    TextToSpeech t1;
    Button parlami;
    boolean trovato = false;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    int id;
     TextView ViewTitolo;
     TextView ViewAutore;
     TextView ViewPeriodo;
     TextView ViewCultura;
     TextView ViewTecnica;
     TextView ViewDimensione;
     TextView ViewValore;
     TextView ViewTrovatoDa;
     TextView ViewPeso;
     TextView ViewDescrizione;


    //DetailsAdapter detailsAdapter;
    //ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.struttura_lista);
        parlami = (Button)findViewById(R.id.button);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.ITALIAN);
                }
            }
        });




        ViewTitolo = (TextView) findViewById(R.id.textViewNomeOpera);
        ViewAutore = (TextView) findViewById(R.id.textViewAutore);
        ViewPeriodo = (TextView) findViewById(R.id.textViewPeriodo);
        ViewCultura = (TextView) findViewById(R.id.textViewCultura);
        ViewTecnica = (TextView) findViewById(R.id.textViewTecnica);
        ViewDimensione = (TextView) findViewById(R.id.textViewDimensione);
        ViewValore = (TextView) findViewById(R.id.textViewValore);
        ViewTrovatoDa = (TextView) findViewById(R.id.textViewTrovatoDa);
        ViewPeso = (TextView) findViewById(R.id.textViewPeso);
        ViewDescrizione = (TextView) findViewById(R.id.textViewDescrizione);
        ViewDescrizione.setMovementMethod(new ScrollingMovementMethod());
       // ViewDescrizione.setMovementMethod(new BaseMovementMethod());
//        Intent i = getIntent();
//         int id = i.getIntExtra("json_data", 0);
        //json_string = getIntent().getExtras().getString("json_data");


        //listView = (ListView)findViewById(R.id.);

//        detailsAdapter = new DetailsAdapter(this,R.layout.struttura_lista);
//        listView.setAdapter(detailsAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        String idS = getIntent().getExtras().getString("id");
        id = Integer.parseInt(idS);
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = new JSONObject(json_string).getJSONArray("Opere ");
            int count = 0;
            String opera, autore, periodo, tecnica, cultura, dimensione, valore, peso, trovato_da, descrizione;
            //int id;
            while(count < jsonArray.length())
            {
                JSONObject  JO = jsonArray.getJSONObject(count);
                if(JO.getInt("IDOpera") == id)
                {
                    opera = JO.getString("NomeOpera");
                    autore = JO.getString("NomeAutore");
                    periodo = JO.getString("Periodo");
                    tecnica = JO.getString("Tecnica");
                    cultura = JO.getString("Cultura");
                    dimensione = JO.getString("Dimensione");
                    valore = JO.getString("Valore");
                    peso = JO.getString("Peso");
                    trovato_da = JO.getString("Fattorino");
                    descrizione = JO.getString("Descrizione");

                    ViewTitolo.setText("Opera: " + opera);
                    ViewAutore.setText("Autore: " + autore);
                    ViewPeriodo.setText("Periodo: " + periodo);
                    ViewCultura.setText("Cultura: " + cultura);
                    ViewTecnica.setText("Tecnica: " + tecnica);
                    ViewDimensione.setText("Dimensione: " + dimensione);
                    ViewValore.setText("Valore: " + valore);
                    ViewTrovatoDa.setText("Trovato da: " + trovato_da);
                    ViewPeso.setText("Peso: " + peso);
                    ViewDescrizione.setText("Descrizione: " + descrizione);
                    trovato = true;

                    //passiamo tutti gli oggetti nell'adapter
                    //detailsAdapter.add(details);
                    break;
                }
//                opera = JO.getString("Nome Opera");
//                autore = JO.getString("Nome Autore");
//                periodo = JO.getString("Periodo");
//                Details details = new Details(opera, autore, periodo);
//                //passiamo tutti gli oggetti nell'adapter
//                detailsAdapter.add(details);
                count ++ ;


            }
            if (trovato == false)
            {
                Toast.makeText(DisplayListView.this,"Nessuna opera corrispondente", Toast.LENGTH_LONG).show();

                //break;
            }
            /*DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            startActivityForResult(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS), 0);
                            break;
                        case DialogInterface.BUTTON_NEGATIVE:
                            boolean flag = true;
                            break;
                    }
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(DisplayListView.this);
                builder.
            builder.setMessage("Attivare Text To Speech?").setPositiveButton("Procedi",dialogClickListener).setNegativeButton("Già Attivo",dialogClickListener).show();

            };*/

            parlami.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String toSpeak = ViewDescrizione.getText().toString();
                   /* Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    startActivityForResult(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS), 0);
                                    break;
                                case DialogInterface.BUTTON_NEGATIVE:
                                    boolean flag = true;
                                    break;
                            }
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(DisplayListView.this);
                    builder.setMessage("Si raccomanda l'utilizzo delle cuffie").setPositiveButton("Va bene", dialogClickListener);
                    */t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Errore nel parsing", Toast.LENGTH_LONG).show();
        }


    }
    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }



}
