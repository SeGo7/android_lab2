package hse.course.android_hse_course_lab2.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hse.course.android_hse_course_lab2.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.NotesViewHolder> {

    private final List<String> notes;

    public static class NotesViewHolder extends RecyclerView.ViewHolder {

        private final TextView cart;

        private final Button madeButton;

        public TextView getCart() {
            return cart;
        }

        public Button getMadeButton() {
            return madeButton;
        }

        public NotesViewHolder(View view) {
            super(view);
            cart = (TextView) view.findViewById(R.id.note);
            madeButton = (Button) view.findViewById(R.id.del_button);
        }
    }

    public ProductAdapter(List<String> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getCart().setText(notes.get(position));
        holder.getMadeButton().setOnClickListener(v -> clear(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void save(String productName) {
        notes.add(productName);
        notifyDataSetChanged();
    }

    public void clearAll() {
        notes.clear();
        notifyDataSetChanged();
    }

    public void clear(int position) {
        notes.remove(position);
        notifyDataSetChanged();
    }
}
