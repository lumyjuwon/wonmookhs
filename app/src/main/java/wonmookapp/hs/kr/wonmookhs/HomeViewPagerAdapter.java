package wonmookapp.hs.kr.wonmookhs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {

    Fragment[] fragments = new Fragment[2];


    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments[0] = new MainActivity.Page_1();
        fragments[1] = new MainActivity.Page_2();
        /*fragments[2] = new MainActivity.Page_3();
        fragments[3] = new MainActivity.Page_4();*/
    }

    //아래의 메서드들의 호출 주체는 ViewPager이다.
    //ListView와 원리가 같다.

    /*
     * 여러 프레그먼트 중 어떤 프레그먼트를 보여줄지 결정
     */
    public Fragment getItem(int arg0) {
        return fragments[arg0];
    }

    /*
     * 보여질 프레그먼트가 몇개인지 결정
     */
    public int getCount() {
        return fragments.length;
    }
}