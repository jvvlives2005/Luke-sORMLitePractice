package lukesterlee.c4q.nyc.ormlitepractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AccessCoderAdapter extends BaseAdapter {

    private Context mContext;
    private List<AccessCoder> mList;
    private LayoutInflater mInflater;

    @Bind(R.id.imageView_face) ImageView mImageView;
    @Bind(R.id.textView_name) TextView mTextViewName;
    @Bind(R.id.textView_gender) TextView mTextViewGender;

    public AccessCoderAdapter(Context mContext, List<AccessCoder> mList) {
        this.mContext = mContext;
        this.mList = mList;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public AccessCoder getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_access_coders, parent, false);
        }

        ButterKnife.bind(this, convertView);

        Picasso.with(mContext).load(getItem(position).getPicture()).resize(200, 200).centerCrop().into(mImageView);
        mTextViewName.setText(getItem(position).getName());
        mTextViewGender.setText(getItem(position).getGender());

        return convertView;
    }
}
