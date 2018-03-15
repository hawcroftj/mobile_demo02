package rrc.bit.recyclerview;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity implements View.OnClickListener {

    private List<FeedItem> feedItems = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FeedItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize UI buttons
        Button btnLinear = findViewById(R.id.btnLinear);
        Button btnGrid = findViewById(R.id.btnGrid);
        Button btnStaggered = findViewById(R.id.btnStaggered);
        // set OnClickListeners
        btnLinear.setOnClickListener(this);
        btnGrid.setOnClickListener(this);
        btnStaggered.setOnClickListener(this);

        // initialize RecyclerView
        recyclerView = findViewById(R.id.rvRecyclerView);

        // basic vertical linear layout - default layout
        layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new FeedItemsAdapter(feedItems);
        recyclerView.setAdapter(adapter);

        generateFeedItems();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnLinear:
                layoutManager = new LinearLayoutManager(getApplicationContext());
                break;
            case R.id.btnGrid:
                // basic grid layout
                layoutManager = new GridLayoutManager(this, 2);
                break;
            case R.id.btnStaggered:
                // staggered grid layout
                layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                break;
        }
        recyclerView.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();
    }

    private void generateFeedItems() {
        feedItems.add(new FeedItem("Big Mood", "Big Mood is an internet slang term generally used to mean “relatable.” It’s popular primarily on Tumblr and Twitter and is often paired with absurd images or videos.", R.drawable.bm));
        feedItems.add(new FeedItem("Piglet", "A domestic pig, often called swine, hog, or simply pig when there is no need to distinguish it from other pigs, is a large, even-toed ungulate.", R.drawable.cute_pig));
        feedItems.add(new FeedItem("Paiste Cymbal", "Paiste is a Swiss-based Estonian manufacturer and designer of cymbals. It is the world's third largest manufacturer of cymbals, gongs, and metal percussion.  Paiste is an Estonian and Finnish word that means \"shine\". Their eponymous sunrise can be seen in the logos for their 2002 line and their Twenty line.", R.drawable.cymbal));
        feedItems.add(new FeedItem("Don't Pre-order", "An image created by Michael to protest the pre-ordering of unreleased video games.", R.drawable.duetomorrow));
        feedItems.add(new FeedItem("Fish Face", "A portrait of a strange looking person eating a fish.", R.drawable.fish_face));
        feedItems.add(new FeedItem("Cool-Aid Man", "The Peoples Temple Agricultural Project, better known by its informal name \"Jonestown\", was a remote settlement established by the Peoples Temple, an American cult under the leadership of reverend Jim Jones, in north Guyana.", R.drawable.oh_yeah));
        feedItems.add(new FeedItem("Snare Drum", "A snare drum or side drum is a percussion instrument that produces a sharp staccato sound when the head is struck with a drum stick, due to the use of a series of stiff wires held under tension against the lower skin..", R.drawable.snare));

        adapter.notifyDataSetChanged();
    }
}
