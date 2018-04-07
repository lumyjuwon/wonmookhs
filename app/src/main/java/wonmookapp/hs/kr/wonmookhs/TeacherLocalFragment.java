package wonmookapp.hs.kr.wonmookhs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TeacherLocalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("ITPANGPANG","onCreateTeacherLocalFragment");
        View inflatedView = inflater.inflate(R.layout.fragment_teacherloca, container, false);

        TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("1층"));
        tabLayout.addTab(tabLayout.newTab().setText("2층"));
        tabLayout.addTab(tabLayout.newTab().setText("3층"));
        tabLayout.addTab(tabLayout.newTab().setText("4층"));
        tabLayout.addTab(tabLayout.newTab().setText("5층"));
        tabLayout.addTab(tabLayout.newTab().setText("6층"));


        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.pager);

        viewPager.setAdapter(new FragmentPagerAdapter
                (getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(0);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return inflatedView;
    }

    @Override
    public void onDestroyView()
    {
        Log.d("ITPANGPANG","OnDestroyTeacherLocalFragment");
        super.onDestroyView();
    }



    public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public FragmentPagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    FloorFragment.Floor1Fragment tab1 = new FloorFragment.Floor1Fragment();
                    return tab1;
                case 1:
                    FloorFragment.Floor2Fragment tab2 = new FloorFragment.Floor2Fragment();
                    return tab2;
                case 2:
                    FloorFragment.Floor3Fragment tab3 = new FloorFragment.Floor3Fragment();
                    return tab3;
                case 3:
                    FloorFragment.Floor4Fragment tab4 = new FloorFragment.Floor4Fragment();
                    return tab4;
                case 4:
                    FloorFragment.Floor5Fragment tab5 = new FloorFragment.Floor5Fragment();
                    return tab5;
                case 5:
                    FloorFragment.Floor6Fragment tab6 = new FloorFragment.Floor6Fragment();
                    return tab6;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

    @Override
    public void onDestroy()
    {
        Log.d("ITPANGPANG","onDestroyFragmentPagerAdapter");
        super.onDestroy();
    }

}




