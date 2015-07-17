package lukesterlee.c4q.nyc.ormlitepractice;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**  To make the layout with image and text
 *
 * The class where it tells helper how to do this
 *
 * Created by c4q-joshelynvivas on 7/16/15.
 */

//make the database table with the appropriate variables
@DatabaseTable
public class AccessCoder {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int picture;

    @DatabaseField
    private String name;

    @DatabaseField
    private String gender;


    public AccessCoder() {

    }

    public AccessCoder(int picture, String name, String gender) {
        this.gender = gender;
        this.name = name;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setPicture(Integer picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

}
