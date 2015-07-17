package lukesterlee.c4q.nyc.ormlitepractice;


import android.renderscript.Element;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
