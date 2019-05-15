package pnj.ac.id.rifdahnetauts.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pnj.ac.id.rifdahnetauts.Activity.RestaurantActivity;
import pnj.ac.id.rifdahnetauts.Model.KategoriModel;
import pnj.ac.id.rifdahnetauts.R;

public class KategoriAdapter extends ArrayAdapter<KategoriModel> {

    Context context;
    int resource;

    public KategoriAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = null;

        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder.text_judul = convertView.findViewById(R.id.text_judul);
            holder.text_outlet = convertView.findViewById(R.id.text_outlet);
            holder.text_deskripsi = convertView.findViewById(R.id.text_deskripsi);
            holder.imageHeader = convertView.findViewById(R.id.imageHeader);
            holder.itemLayout = convertView.findViewById(R.id.itemLayout);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.text_judul.setText(getItem(position).getJudul());
        holder.text_outlet.setText(getItem(position).getOutlet());
        holder.text_deskripsi.setText(getItem(position).getDeskripsi());


        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RestaurantActivity.class);
                intent.putExtra("URL", getItem(position).getImageURL());
                context.startActivity(intent);
            }
        });
        new AmbilGambar(holder.imageHeader).execute(new String[]{getItem(position).getImageURL()});
        return convertView;
    }
    class Holder{
        TextView text_judul,text_outlet,text_deskripsi;
        ImageView imageHeader;
        RelativeLayout itemLayout;
    }
}
