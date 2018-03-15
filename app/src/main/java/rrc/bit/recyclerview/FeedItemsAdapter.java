package rrc.bit.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

// Custom Adapter class for handling data in a FeedItem
public class FeedItemsAdapter extends RecyclerView.Adapter<FeedItemsAdapter.FeedItemViewHolder> {
    private List<FeedItem> feedItems;

    // nested class defines the ViewHolder which holds the view(s) for recycling
    public class FeedItemViewHolder extends RecyclerView.ViewHolder {
        // a View is defined for each piece of data to be displayed in the row
        private TextView title, content;
        private ImageView image;

        public FeedItemViewHolder(View view) {
            // super must be called first
            super(view);
            // initialize Views from the feeditem_row.xml layout file
            this.title = view.findViewById(R.id.tvTitle);
            this.content = view.findViewById(R.id.tvContent);
            this.image = view.findViewById(R.id.ivImage);
        }
    }

    // initializes list of FeedItems for use in this adapter
    public FeedItemsAdapter(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

    @Override
    public FeedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate the feeditem_row and pass it to a new ViewHolder object
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feeditem_row, parent, false);

        return new FeedItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedItemViewHolder holder, int position) {
        FeedItem item = feedItems.get(position);
        holder.title.setText(item.getTitle());
        holder.content.setText(item.getContent());
        holder.image.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }
}
