package inc.tms.develope.spartanshield2;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.*;
import android.widget.TextView;

import inc.tms.develope.spartanshield2.R;

import java.util.List;

/**
 * Created by obaro on 27/11/2016.
 */

public class RssFeedListAdapter
        extends RecyclerView.Adapter<RssFeedListAdapter.FeedModelViewHolder> {

    private List<RssFeedModel> mRssFeedModels;

    public static class FeedModelViewHolder extends RecyclerView.ViewHolder {
        private View rssFeedView;

        public FeedModelViewHolder(View v) {
            super(v);
            rssFeedView = v;
        }
    }

    public RssFeedListAdapter(List<RssFeedModel> rssFeedModels) {
        mRssFeedModels = rssFeedModels;
    }

    @Override
    public FeedModelViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rss_feed, parent, false);
        FeedModelViewHolder holder = new FeedModelViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(FeedModelViewHolder holder, int position) {
        final RssFeedModel rssFeedModel = mRssFeedModels.get(position);
        ((TextView)holder.rssFeedView.findViewById(R.id.titleText)).setText(rssFeedModel.title);
        ((TextView)holder.rssFeedView.findViewById(R.id.descriptionText)).setText(rssFeedModel.description);
        ((TextView)holder.rssFeedView.findViewById(R.id.timeText)).setText(rssFeedModel.time);
        ((TextView)holder.rssFeedView.findViewById(R.id.publisherText)).setText(rssFeedModel.publisher);
        holder.rssFeedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(rssFeedModel.link);
                Intent intent = new Intent(view.getContext(), WebView.class);
                String url = rssFeedModel.link;
                intent.putExtra(MainActivity.EXTRA_MESSAGE, url);
                view.getContext().startActivity(intent);


            }
        });}


    @Override
    public int getItemCount() {
        return mRssFeedModels.size();
    }
}

