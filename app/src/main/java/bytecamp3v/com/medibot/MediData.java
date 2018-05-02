package bytecamp3v.com.medibot;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MediData extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    String name;
    ViewPager viewPager;
    MorningFragment morningFragment;
    EveningFragment eveningFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medi_data);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        name = getIntent().getStringExtra("name");
        toolbar.setTitle(name);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(2);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);

        //myRecyclerView = (RecyclerView) findViewById(R.id.myrecyclerview);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        morningFragment = new MorningFragment();
        morningFragment.setName(name);
        eveningFragment = new EveningFragment();
        eveningFragment.setName(name);
        viewPagerAdapter.addFragment(morningFragment,"MORNING");
        viewPagerAdapter.addFragment(eveningFragment,"EVENING");
        viewPager.setAdapter(viewPagerAdapter);

    }
}
