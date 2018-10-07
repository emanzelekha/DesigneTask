package emanzelekha.com.designetask.MVP.Model.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import emanzelekha.com.designetask.MVP.Model.Recycer.HelpModel;
import emanzelekha.com.designetask.R;

public class HelpListAdapter extends RecyclerView.Adapter<HelpListAdapter.MyViewHolder> {
    private List<HelpModel> HelpList;
    private int Mode;//to show cancel button

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_help, parent, false);

        return new MyViewHolder(itemView);
    }

    public HelpListAdapter(List<HelpModel> HelpList, int Mode) {
        this.HelpList = HelpList;
        this.Mode = Mode;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HelpModel DataModel = HelpList.get(position);
        holder.type.setText(DataModel.getType());
        holder.time.setText(DataModel.getTime());
        holder.title.setText(DataModel.getTitle());
        holder.info.setText(DataModel.getInfo());
        holder.accept.setText(DataModel.getAttend());
        if (DataModel.isActive()) {
            holder.active.setVisibility(View.VISIBLE);
        } else {
            holder.active.setVisibility(View.GONE);

        }
        if (Mode == 1) {
            holder.cancel.setVisibility(View.GONE);
        } else {
            holder.cancel.setVisibility(View.VISIBLE);

        }


    }

    @Override
    public int getItemCount() {
        return HelpList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, type, info, time, accept;
        public View active, cancel;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.help_item_title);
            type = (TextView) view.findViewById(R.id.help_item_type);
            info = (TextView) view.findViewById(R.id.help_item_attend);
            time = (TextView) view.findViewById(R.id.help_item_time);
            accept = (TextView) view.findViewById(R.id.help_item_accept);
            active = view.findViewById(R.id.item_help_active);
            cancel = view.findViewById(R.id.item_help_cancel);

        }
    }


}
