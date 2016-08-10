package com.armistic.myapplication.category;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.armistic.myapplication.Persistence;
import com.armistic.myapplication.R;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by jibieta on 10-08-16.
 */
public class AsyncCategoryListActivity  extends AppCompatActivity {

    private String loadUrl;
    ArrayList<Category> items;
    private ListView listView;
    private static final String TAG = "AsyncCategoryList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_category_list);

        // Obtenemos la URL de donde cargamos las categorias.
        Bundle extras = getIntent().getExtras();
        loadUrl = extras.getString("loadUrl");

        // obtener la lista
        listView = (ListView) findViewById(R.id.listView);

        // feetch json
        fetchJson();

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

                        items = new ArrayList<Category>();

                        try {

                            for (int i = 0; i < data.length(); i++) {

                                JSONObject jsonItem = data.getJSONObject(i);

                                Category item = new Category();
                                item.setKey(jsonItem.getString("key"));
                                item.setCategory(jsonItem.getString("category"));
                                item.setSelected(jsonItem.getString("selected"));
                                item.setChoiceMode(jsonItem.getInt("choiceMode"));
                                item.setFormType(jsonItem.getInt("formType"));
                                item.setLoadUrl(jsonItem.getString("loadUrl"));

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
        Adapter adapter = new Adapter(this, items);
        listView.setAdapter(adapter);
        hideProgressBar();
    }

     private void hideProgressBar() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

}
