package lukesterlee.c4q.nyc.ormlitepractice;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends ActionBarActivity {

    @Bind(R.id.listView) ListView mListView;
    private AccessCoderAdapter mAdapter;
    private DatabaseHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        new DatabaseTask().execute();

    }

    private class DatabaseTask extends AsyncTask<Void, Void, List<AccessCoder>> {
        @Override
        protected List<AccessCoder> doInBackground(Void... params) {

            mHelper = DatabaseHelper.getInstance(getApplicationContext());

            try {
                if (mHelper.loadData().size() == 0) {
                    mHelper.insertRow(R.drawable.allison, "Allison", "Female");
                    mHelper.insertRow(R.drawable.alvin, "Alvin", "Male");
                    mHelper.insertRow(R.drawable.charlyn, "Charlyn", "Female");
                }

                return mHelper.loadData();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<AccessCoder> accessCoders) {
            mAdapter = new AccessCoderAdapter(MainActivity.this, accessCoders);
            mListView.setAdapter(mAdapter);
        }
    }

}
