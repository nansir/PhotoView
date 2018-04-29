package com.sir.app.photoview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.sir.library.photoview.PhotoView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new SamplePagerAdapter(this));
    }


    static class SamplePagerAdapter extends PagerAdapter {

        private static final String[] sDrawables = {
                "http://preview.quanjing.com/pm0207/pm0207-2881es.jpg",
                "http://www.taopic.com/uploads/allimg/140326/235113-1403260G01561.jpg",
                "http://scimg.jb51.net/allimg/150415/14-15041511223U18.jpg"
        };
        Context mContext;

        public SamplePagerAdapter(Context context) {
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return sDrawables.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            //photoView.setImageResource(sDrawables[position]);
            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            Picasso.with(mContext)
                    .load(sDrawables[position])
                    .into(photoView);
            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
