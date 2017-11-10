package helpme_productions.com.uberborrow.ribs.root.logged_in.borrow;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import helpme_productions.com.uberborrow.R;
import helpme_productions.com.uberborrow.model.CarInformation;

public class RecyleAdapter extends RecyclerView.Adapter<RecyleAdapter.ViewHolder>{
   private List<CarInformation> carInformationList = new ArrayList<>();

    public RecyleAdapter(List<CarInformation> carInformationList) {
        this.carInformationList = carInformationList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CarInformation info = carInformationList.get(position);
        holder.model.setText(info.getModel());
        holder.make.setText(info.getMake());
        holder.startTime.setText(info.getBeginRentTime());
        holder.endTime.setText(info.getEndRentTime());
    }

    @Override
    public int getItemCount() {
        return carInformationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView startTime;
        TextView endTime;
        TextView make;
        TextView model;
        public ViewHolder(View itemView) {
            super(itemView);
            startTime = itemView.findViewById(R.id.tvAvaiableStartTime);
            endTime = itemView.findViewById(R.id.tvAvaiableEndTime);
            make = itemView.findViewById(R.id.tvCarMake);
            model = itemView.findViewById(R.id.tvCarModel);

        }
    }
}
