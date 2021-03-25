package com.example.tp3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class PlaneteAdapter extends BaseAdapter {
    ArrayList<Planete> planetes;
    private Activity context;
    private Button verifier;



    public PlaneteAdapter(Activity context, Data data) {
        this.context = context;
        this.planetes = data.planetes;

    }

    @Override
    public int getCount() {
        return planetes.size();
    }

    @Override
    public Object getItem(int arg0) {
        return planetes.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            itemView = inflater.inflate(R.layout.listitem, null);
        }
        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);
        nomPlanete.setText(planetes.get(position).getNom());


        ArrayList<String> taille = new ArrayList();
        for (int i=0;i<planetes.size();i++){
            taille.add(planetes.get(i).getTaille());
        }

        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, taille);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);


        verifier = (Button) context.findViewById(R.id.button);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                if (checkBox.isChecked()) {
                    spinner.setEnabled(false);
                    spinadapter.notifyDataSetChanged();

                    Boolean check = true;
                    for (int i = 0; i < planetes.size(); i++) {
                        ViewGroup parent = context.findViewById(R.id.listView);
                        LinearLayout listItem = (LinearLayout) parent.getChildAt(i);
                        CheckBox cb = (CheckBox) listItem.getChildAt(1);
                        if (cb.isChecked()==false) {
                            check = false;
                        }
                    }
                    if (check){
                        verifier.setEnabled(true);
                    }else verifier.setEnabled(false);

                } else {
                    spinner.setEnabled(true);
                    spinadapter.notifyDataSetChanged();
                }
            }
        });

        return itemView;
    }


}
