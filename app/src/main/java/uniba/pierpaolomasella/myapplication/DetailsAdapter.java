package uniba.pierpaolomasella.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vater on 22/07/2017.
 */
/*
public class DetailsAdapter extends ArrayAdapter
{
    List list = new ArrayList();

    public DetailsAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }


    public void add(Details object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return  list.size();

    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;
        DetailsHolder detailsHolder;
        if(row == null)
        {
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.struttura_lista,parent,false);
            detailsHolder = new DetailsHolder();
            detailsHolder.tx_opera = (TextView) row.findViewById(R.id.textViewNomeOpera);
            detailsHolder.tx_autore = (TextView) row.findViewById(R.id.textViewAutore);
            detailsHolder.tx_trovato_da = (TextView) row.findViewById(R.id.textViewTrovatoDa);
            detailsHolder.tx_periodo = (TextView) row.findViewById(R.id.textViewPeriodo);
            detailsHolder.tx_tecnica = (TextView) row.findViewById(R.id.textViewTecnica);
            detailsHolder.tx_cultura = (TextView) row.findViewById(R.id.textViewCultura);
            detailsHolder.tx_dimensione = (TextView) row.findViewById(R.id.textViewDimensione);
            detailsHolder.tx_peso = (TextView) row.findViewById(R.id.textViewPeso);
            detailsHolder.tx_valore = (TextView) row.findViewById(R.id.textViewValore);
            detailsHolder.tx_descrizione = (TextView) row.findViewById(R.id.textViewDescrizione);


            row.setTag(detailsHolder);

        }

        else
        {
            detailsHolder = (DetailsHolder) row.getTag();
        }

        Details details = (Details)this.getItem(position);
        detailsHolder.tx_opera.setText(details.getOpera());
        detailsHolder.tx_autore.setText(details.getAutore());
        detailsHolder.tx_periodo.setText(details.getPeriodo());
        return row;
    }

    static class DetailsHolder
    {
        TextView tx_opera, tx_autore, tx_trovato_da, tx_periodo, tx_tecnica, tx_cultura,tx_dimensione, tx_peso,tx_valore, tx_descrizione ;
        //, , dimensione, valore, , , descrizione
    }*/

