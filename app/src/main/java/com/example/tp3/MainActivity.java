package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listview;
    PlaneteAdapter adapter;
    Data data;
    Button verifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new Data();

        listview = (ListView) findViewById(R.id.listView);
        adapter = new PlaneteAdapter(this,data);
        listview.setAdapter(adapter);
        verifier = (Button) findViewById(R.id.button);
        verifier.setOnClickListener(Verifier);
    }




    private View.OnClickListener Verifier = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ArrayList<String> taillePlanetes = new ArrayList();
            for (int i=0;i<adapter.planetes.size();i++){
                taillePlanetes.add(adapter.planetes.get(i).getTaille());
                }

            ArrayList <String>taillesSelectionne = new ArrayList();
            for (int i = 0; i < adapter.planetes.size(); i++) {
                ViewGroup parent = MainActivity.this.findViewById(R.id.listView);
                LinearLayout listItem = (LinearLayout) parent.getChildAt(i);
                Spinner spinner = (Spinner) listItem.getChildAt(2);
                taillesSelectionne.add(spinner.getSelectedItem().toString());

            }


            int erreurs=0;
            boolean test = true;
            for (int i = 0; i < 9; i++) {
                if (taillesSelectionne.get(i) != taillePlanetes.get(i)) {
                    test = false;
                    erreurs++;
                }
            }
            if (test == true) {
                Toast.makeText(MainActivity.this, "Vous avez trouvé toutes les tailles des planetes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Vous vous êtes trompé dans "+erreurs+ " planete(s) ", Toast.LENGTH_SHORT).show();
            }
        }
    };




    }

