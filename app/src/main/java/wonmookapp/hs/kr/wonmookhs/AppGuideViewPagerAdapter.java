package wonmookapp.hs.kr.wonmookhs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Administrator on 2017-06-05.
 */

public class AppGuideViewPagerAdapter extends FragmentStatePagerAdapter{

    Fragment[] fragments = new Fragment[6];

    public AppGuideViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        fragments[0] = new AppGuide.AppGuidePage1();
        fragments[1] = new AppGuide.AppGuidePage2();
        fragments[2] = new AppGuide.AppGuidePage3();
        fragments[3] = new AppGuide.AppGuidePage4();
        fragments[4] = new AppGuide.AppGuidePage5();
        fragments[5] = new AppGuide.AppGuidePage6();
    }

    public Fragment getItem(int arg0) {
        return fragments[arg0];
    }

    public int getCount() {
        return fragments.length;
    }

}
