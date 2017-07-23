package uniba.pierpaolomasella.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    boolean trovato = false;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    int id;
    private TextView ViewTitolo;
    private TextView ViewAutore;
    private TextView ViewPeriodo;
    private TextView ViewCultura;
    private TextView ViewTecnica;
    private TextView ViewDimensione;
    private TextView ViewValore;
    private TextView ViewTrovatoDa;
    private TextView ViewPeso;
    private TextView ViewDescrizione;


    //DetailsAdapter detailsAdapter;
    //ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.struttura_lista);

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

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Errore nel parsing", Toast.LENGTH_LONG).show();
        }


    }


}
