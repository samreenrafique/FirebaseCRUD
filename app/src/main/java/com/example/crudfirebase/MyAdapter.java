package com.example.crudfirebase;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter extends FirebaseRecyclerAdapter<DbHelper,MyAdapter.viewholderclass> {



    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MyAdapter(@NonNull FirebaseRecyclerOptions<DbHelper> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholderclass holder, int position, @NonNull DbHelper model) {
        holder.t1.setText(model.getName());
        holder.t2.setText(model.getEmail());
        holder.t3.setText(model.getPassword());
    }

    @NonNull
    @Override
    public viewholderclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);

        return new viewholderclass(view);
    }
    class viewholderclass extends RecyclerView.ViewHolder{

        TextView t1,t2,t3;
        public viewholderclass(@NonNull View itemView) {

            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.username);
            t2 = (TextView) itemView.findViewById(R.id.useremail);
            t3 = (TextView) itemView.findViewById(R.id.userpswd);
        }

    }
}
