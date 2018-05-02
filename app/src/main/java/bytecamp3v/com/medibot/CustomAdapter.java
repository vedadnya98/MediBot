package bytecamp3v.com.medibot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by hp on 18-02-2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MedicineViewHolder> {

    Context mContext;
    List<Medicine> medicines;

    public CustomAdapter(Context mContext, List<Medicine> medicines) {
        this.mContext = mContext;
        this.medicines = medicines;
    }

    @Override
    public MedicineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_single_medicine,null);
        return new MedicineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MedicineViewHolder holder, int position) {
        Medicine medicine = medicines.get(position);
        holder.medname.setText(medicine.getMedicineName());
        holder.medtaking.setText(medicine.getTaking()==0 ? "OFF" : "ON");
    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    class MedicineViewHolder extends RecyclerView.ViewHolder {

        TextView medname;
        ToggleButton medtaking;
        public MedicineViewHolder(View itemView) {
            super(itemView);
            medname = itemView.findViewById(R.id.medicineName);
            medtaking = itemView.findViewById(R.id.medicineTake);
        }
    }
}
