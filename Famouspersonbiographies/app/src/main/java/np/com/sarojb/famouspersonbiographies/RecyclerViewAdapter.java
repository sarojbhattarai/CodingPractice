package np.com.sarojb.famouspersonbiographies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<FamousPersons> detailofpersons = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_persons, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).asBitmap().load(detailofpersons.get(position).getImageUrl()).into(holder.imageview_photo);
        holder.textview_name.setText(detailofpersons.get(position).getName());
        holder.textview_fieldofwork.setText(detailofpersons.get(position).getFieldOfWork());
        holder.textview_shortdesc.setText(detailofpersons.get(position).getShortdesc());
    }

    @Override
    public int getItemCount() {
        return detailofpersons.size();
    }

    public void setDetailofpersons(ArrayList<FamousPersons> detailofpersons) {
        this.detailofpersons = detailofpersons;
        notifyDataSetChanged();
    }

    // First make this Viewholder class name it ViewHolder by convention
    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView card;
        private ImageView imageview_photo;
        private TextView textview_name;
        private TextView textview_shortdesc;
        private TextView textview_fieldofwork;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview_photo = itemView.findViewById(R.id.imageview_photo);
            textview_name = itemView.findViewById(R.id.textview_name);
            textview_shortdesc = itemView.findViewById(R.id.textview_shortdesc);
            textview_fieldofwork = itemView.findViewById(R.id.textview_fieldofwork);
        }
    }
}
