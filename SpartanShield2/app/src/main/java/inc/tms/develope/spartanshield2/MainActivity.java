package inc.tms.develope.spartanshield2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import inc.tms.develope.spartanshield2.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "inc.tms.develope.spartanshild2.MESSAGE";
    private static final String TAG = "MainActivity";
    private ImageButton imbHome;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeLayout;
    private String filter = " ";
    private Button btnNews, btnFeature, btnSports, btnOpinion, btnArts, btnStudentLife, btnVideo;

    private List<RssFeedModel> mFeedModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        imbHome = (ImageButton)findViewById(R.id.imbHome);
        btnNews = (Button)findViewById(R.id.btnNews);
        btnFeature = (Button)findViewById(R.id.btnFeature);
        btnArts = (Button)findViewById(R.id.btnAE);
        btnSports = (Button)findViewById(R.id.btnSports);
        btnOpinion = (Button)findViewById(R.id.btnOpinion);
        btnStudentLife = (Button)findViewById(R.id.btnStudentLife);
        btnVideo = (Button)findViewById(R.id.btnVideo);

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filter.equalsIgnoreCase("news")){
                    filter = " ";
                    btnNews.setBackgroundColor(getResources().getColor(R.color.white));}
                else{
                    filter = "news";
                    btnNews.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    btnFeature.setBackgroundColor(getResources().getColor(R.color.white));
                    btnArts.setBackgroundColor(getResources().getColor(R.color.white));
                    btnSports .setBackgroundColor(getResources().getColor(R.color.white));
                    btnOpinion.setBackgroundColor(getResources().getColor(R.color.white));
                    btnStudentLife.setBackgroundColor(getResources().getColor(R.color.white));
                    btnVideo.setBackgroundColor(getResources().getColor(R.color.white));
                }
                new FetchFeedTask().execute((Void) null);

            }
        });
        btnFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filter.equalsIgnoreCase("feature")){
                    filter = " ";
                    btnFeature.setBackgroundColor(getResources().getColor(R.color.white));}
                else{
                    filter = "feature";
                    btnNews.setBackgroundColor(getResources().getColor(R.color.white));
                    btnFeature.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    btnArts.setBackgroundColor(getResources().getColor(R.color.white));
                    btnSports .setBackgroundColor(getResources().getColor(R.color.white));
                    btnOpinion.setBackgroundColor(getResources().getColor(R.color.white));
                    btnStudentLife.setBackgroundColor(getResources().getColor(R.color.white));
                    btnVideo.setBackgroundColor(getResources().getColor(R.color.white));
                }
                new FetchFeedTask().execute((Void) null);

            }
        });
        btnArts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filter.equalsIgnoreCase("Arts & Entertainment")){
                    filter = " ";
                    btnArts.setBackgroundColor(getResources().getColor(R.color.white));}
                else{
                    filter = "Arts & Entertainment";
                    btnNews.setBackgroundColor(getResources().getColor(R.color.white));
                    btnFeature.setBackgroundColor(getResources().getColor(R.color.white));
                    btnArts.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    btnSports .setBackgroundColor(getResources().getColor(R.color.white));
                    btnOpinion.setBackgroundColor(getResources().getColor(R.color.white));
                    btnStudentLife.setBackgroundColor(getResources().getColor(R.color.white));
                    btnVideo.setBackgroundColor(getResources().getColor(R.color.white));
                }
                new FetchFeedTask().execute((Void) null);
            }
        });
        btnSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filter.equalsIgnoreCase("Sports")){
                    filter = " ";
                    btnSports.setBackgroundColor(getResources().getColor(R.color.white));}
                else{
                    filter = "Sports";
                    btnNews.setBackgroundColor(getResources().getColor(R.color.white));
                    btnFeature.setBackgroundColor(getResources().getColor(R.color.white));
                    btnArts.setBackgroundColor(getResources().getColor(R.color.white));
                    btnSports .setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    btnOpinion.setBackgroundColor(getResources().getColor(R.color.white));
                    btnStudentLife.setBackgroundColor(getResources().getColor(R.color.white));
                    btnVideo.setBackgroundColor(getResources().getColor(R.color.white));
                }
                new FetchFeedTask().execute((Void) null);
            }
        });
        btnOpinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filter.equalsIgnoreCase("Opinion")){
                    filter = " ";
                    btnOpinion.setBackgroundColor(getResources().getColor(R.color.white));}
                else{
                    filter = "Opinion";
                    btnNews.setBackgroundColor(getResources().getColor(R.color.white));
                    btnFeature.setBackgroundColor(getResources().getColor(R.color.white));
                    btnArts.setBackgroundColor(getResources().getColor(R.color.white));
                    btnSports .setBackgroundColor(getResources().getColor(R.color.white));
                    btnOpinion.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    btnStudentLife.setBackgroundColor(getResources().getColor(R.color.white));
                    btnVideo.setBackgroundColor(getResources().getColor(R.color.white));
                }
                new FetchFeedTask().execute((Void) null);
            }
        });
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filter.equalsIgnoreCase("The Shield Shows You")){
                    filter = " ";
                    btnVideo.setBackgroundColor(getResources().getColor(R.color.white));}
                else{
                    filter = "The Shield Shows You";
                    btnNews.setBackgroundColor(getResources().getColor(R.color.white));
                    btnFeature.setBackgroundColor(getResources().getColor(R.color.white));
                    btnArts.setBackgroundColor(getResources().getColor(R.color.white));
                    btnSports .setBackgroundColor(getResources().getColor(R.color.white));
                    btnOpinion.setBackgroundColor(getResources().getColor(R.color.white));
                    btnStudentLife.setBackgroundColor(getResources().getColor(R.color.white));
                    btnVideo.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
                new FetchFeedTask().execute((Void) null);
            }
        });
        btnStudentLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filter.equalsIgnoreCase("student life")){
                    filter = " ";
                    btnStudentLife.setBackgroundColor(getResources().getColor(R.color.white));}
                else{
                    filter = "student life";
                    btnNews.setBackgroundColor(getResources().getColor(R.color.white));
                    btnFeature.setBackgroundColor(getResources().getColor(R.color.white));
                    btnArts.setBackgroundColor(getResources().getColor(R.color.white));
                    btnSports .setBackgroundColor(getResources().getColor(R.color.white));
                    btnOpinion.setBackgroundColor(getResources().getColor(R.color.white));
                    btnStudentLife.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    btnVideo.setBackgroundColor(getResources().getColor(R.color.white));
                }
                new FetchFeedTask().execute((Void) null);
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


                new FetchFeedTask().execute((Void) null);

        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new FetchFeedTask().execute((Void) null);
            }
        });

        imbHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebView.class);
                String url = "https://spartanshield.org";
                intent.putExtra(MainActivity.EXTRA_MESSAGE, url);
                startActivity(intent);
            }
        });
    }

    public List<RssFeedModel> parseFeed(InputStream inputStream) throws XmlPullParserException, IOException {
        String title = null;
        String link = null;
        String description = null;
        String publisher = null;
        String time = null;
        String category = null;
        String imgurl = null;
        boolean isItem = false;
        List<RssFeedModel> items = new ArrayList<>();

        try {
            XmlPullParser xmlPullParser = Xml.newPullParser();
            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xmlPullParser.setInput(inputStream, null);

            xmlPullParser.nextTag();
            while (xmlPullParser.next() != XmlPullParser.END_DOCUMENT) {
                int eventType = xmlPullParser.getEventType();

                String name = xmlPullParser.getName();
                if(name == null)
                    continue;

                if(eventType == XmlPullParser.END_TAG) {
                    if(name.equalsIgnoreCase("item")) {
                        isItem = false;
                    }
                    continue;
                }

                if (eventType == XmlPullParser.START_TAG) {
                    if(name.equalsIgnoreCase("item")) {
                        isItem = true;
                        continue;
                    }
                }

                Log.d("MainActivity", "Parsing name ==> " + name);
                String result = "";
                if (xmlPullParser.next() == XmlPullParser.TEXT) {
                    result = xmlPullParser.getText();
                    xmlPullParser.nextTag();
                }

                if (result.equalsIgnoreCase("The student news site of Pleasant Valley High School"))
                    System.out.println("Deleted Introduction");
               else if (name.equalsIgnoreCase("title")) {
                    title = result;
                } else if (name.equalsIgnoreCase("link")) {
                    link = result;
                } else if (name.equalsIgnoreCase("description")) {
                    description = result.substring(0,result.length()-10) + "...";
                } else if (name.equalsIgnoreCase("pubdate")) {
                    time = result.substring(0,(result.length()-14));
                } else if (name.equalsIgnoreCase("dc:creator")) {
                    publisher = result;
                } else if (name.equalsIgnoreCase("category")) {
                    category = result;
                }





                if (title != null && link != null && description != null) {
                    if(isItem) {
                        if (filter.equalsIgnoreCase(" ")){
                        RssFeedModel item = new RssFeedModel(title, link, description,time,publisher);
                        items.add(item);}
                        else if (filter.equalsIgnoreCase(category))
                        {
                            RssFeedModel item = new RssFeedModel(title, link, description,time,publisher);
                            items.add(item);
                        }

                    }


                    title = null;
                    link = null;
                    description = null;
                    time = null;
                    isItem = false;
                    category = null;
                    publisher = null;
                }
            }

            return items;
        } finally {
            inputStream.close();
        }
    }

    private class FetchFeedTask extends AsyncTask<Void, Void, Boolean> {

        private String urlLink;

        @Override
        protected void onPreExecute() {
            mSwipeLayout.setRefreshing(true);
            urlLink = "https://spartanshield.org/feed";
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            if (TextUtils.isEmpty(urlLink))
                return false;

            try {
                URL url = new URL(urlLink);
                InputStream inputStream = url.openConnection().getInputStream();
                mFeedModelList = parseFeed(inputStream);
                return true;
            } catch (IOException e) {
                Log.e(TAG, "Error", e);
            } catch (XmlPullParserException e) {
                Log.e(TAG, "Error", e);
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            mSwipeLayout.setRefreshing(false);

            if (success) {
                // Fill RecyclerView
                mRecyclerView.setAdapter(new RssFeedListAdapter(mFeedModelList));
            } else {
                Toast.makeText(MainActivity.this,
                        "Enter a valid Rss feed url",
                        Toast.LENGTH_LONG).show();
            }
        }
    }


}
