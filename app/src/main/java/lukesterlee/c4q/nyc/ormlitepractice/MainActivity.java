package lukesterlee.c4q.nyc.ormlitepractice;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends ActionBarActivity {

    //private ListView mListView;

    @Bind(R.id.listView) ListView mListView;
    private DatabaseHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mListView = (ListView) findViewById(R.id.listView);

        ButterKnife.bind(this);
        new DatabaseTask().execute();

    }

    private class DatabaseTask extends AsyncTask <Void, Void, List<AccessCoder>> {

        @Override
        protected List<AccessCoder> doInBackground(Void... params) {

            mHelper = DatabaseHelper.getInstance(getApplicationContext());

            try {
                if (mHelper.loadData().size() == 0) {
                    mHelper.insertRow(R.drawable.allison, "Allison", "Female");
                }
            }
                return mHelper.loadData();



        }

        @Override
        protected void onPostExecute(List<AccessCoder> accessCoders) {
            super.onPostExecute(accessCoders);
        }
    }


}
