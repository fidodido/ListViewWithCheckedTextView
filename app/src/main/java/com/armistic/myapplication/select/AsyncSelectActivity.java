package com.armistic.myapplication.select;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.armistic.myapplication.Persistence;
import com.armistic.myapplication.R;
import com.armistic.myapplication.category.Category;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class AsyncSelectActivity extends AppCompatActivity {

    private static final String TAG = "AsyncSelectActivity";
    private ArrayList<Item> items;
    private ListView listView;
    private Adapter adapter;
    private String loadUrl;
    private String key;
    private Integer choiceMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_select);

        // Aca debemos recibir los parametros de entrada para la actividad.
        Bundle extras = getIntent().getExtras();

        // obtengo los parametros de actividad.
        key = extras.getString("key");
        choiceMode = extras.getInt("choiceMode");
        loadUrl = extras.getString("loadUrl");

        // obtengo la listview y seteo el tipo de seleccion.
        listView = (ListView) findViewById(R.id.listView);
        listView.setChoiceMode(choiceMode);

        listView = (ListView) findViewById(R.id.listView);

        fetchJson();

        /*
        items = new ArrayList<Item>();

        // populate the array items.
        for (int i = 0; i < 1000; i++) {
            items.add(new Item("Item " + i, false));
        }

        listView = (ListView) findViewById(R.id.listView);

        // seleccionamos el tipo de seleccion,.
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        adapter = new Adapter(this, items);
        listView.setAdapter(adapter);


        if(listView.getChoiceMode() == ListView.CHOICE_MODE_SINGLE) {
            listView.setItemChecked(0, true);
        }

        if(listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE) {
            // set default items.
            for (int i = 0; i < items.size(); i++) {
                listView.setItemChecked(i, items.get(i).getChecked());
            }
        }
        */


    }

    private void fetchJson() {

        RequestParams params = new RequestParams();

        Persistence.get(loadUrl, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {

                    Boolean success = response.getBoolean("success");
                    JSONArray data = response.getJSONArray("data");

                    if (success) {

                        items = new ArrayList<Item>();

                        try {

                            for (int i = 0; i < data.length(); i++) {

                                JSONObject jsonItem = data.getJSONObject(i);

                                Item item = new Item();
                                item.setId(jsonItem.getInt("id"));
                                item.setTitle(jsonItem.getString("title"));
                                item.setChecked(jsonItem.getBoolean("checked"));

                                items.add(item);

                            }

                        } catch (Exception e) {
                            throw new Exception(e.toString());
                        }

                        setAdapter();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.e(TAG, "onFailure");
            }
        });
    }

    private void setAdapter() {

        adapter = new Adapter(this, items);
        listView.setAdapter(adapter);

        // Despues que se setea el adaptador.
        // El CheckedTextView no queda seleccionado.
        // Se debe checkiar los checkbox por default.

        for (int i = 0; i < items.size(); i++) {
            listView.setItemChecked(i, items.get(i).getChecked());
        }

        // Y finalmente escondimos la barra de progreso.
        hideProgressBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void hideProgressBar() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
