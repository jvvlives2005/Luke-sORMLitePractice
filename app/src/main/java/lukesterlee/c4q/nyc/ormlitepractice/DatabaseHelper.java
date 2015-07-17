package lukesterlee.c4q.nyc.ormlitepractice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String MYDB = "mydb.db";
    private static final int VERSION = 2;

    private static DatabaseHelper mHelper;


    public static synchronized DatabaseHelper getInstance(Context context) {
        if(mHelper == null) {
            mHelper = new DatabaseHelper(context.getApplicationContext());
        }
        return mHelper;
    }

    public DatabaseHelper(Context context) {
        super(context, MYDB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, AccessCoder.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource, AccessCoder.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRow(int picture, String name, String gender) throws SQLException {
        AccessCoder coder = new AccessCoder(picture, name, gender);
        getDao(AccessCoder.class).create(coder);
    }

    public List<AccessCoder> loadData() throws SQLException {
        return getDao(AccessCoder.class).queryForAll();
    }
}
