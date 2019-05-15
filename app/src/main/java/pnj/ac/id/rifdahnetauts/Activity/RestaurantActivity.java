package pnj.ac.id.rifdahnetauts.Activity;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import pnj.ac.id.rifdahnetauts.R;
import pnj.ac.id.rifdahnetauts.Adapter.RestaurantAdapter;
import pnj.ac.id.rifdahnetauts.Model.RestaurantModel;

public class RestaurantActivity extends AppCompatActivity {

    GridView gridView;
    RestaurantAdapter adapter;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        gridView = findViewById(R.id.gridView);

        adapter = new RestaurantAdapter(this, R.layout.item_grid_view);

        gridView.setAdapter(adapter);
        res = getResources();

        initData();
    }


    void initData() {
        String[] nama_restaurant = res.getStringArray(R.array.nama_restaurant);
        String[] nama_lokasi = res.getStringArray(R.array.nama_lokasi);
        String[] harga = res.getStringArray(R.array.harga);
        String[] url_restaurant = res.getStringArray(R.array.url_restaurant);

        for(int i=0; i< nama_restaurant.length;i++) {
            RestaurantModel model = new RestaurantModel();
            model.setNama_restaurant(nama_restaurant[i]);
            model.setLokasi(nama_lokasi[i]);
            model.setHarga(harga[i]);
            model.setImageURL(url_restaurant[i]);
            adapter.add(model);
        }


        adapter.notifyDataSetChanged();
    }

}
