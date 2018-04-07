package wonmookapp.hs.kr.wonmookhs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-02-10.
 */


// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요

// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요
// 사용 안 하는 프래그먼트 입니다 건들지 마세요



public class PromotionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_promotion, container, false);

        TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.promotiontabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("정규동아리"));
        tabLayout.addTab(tabLayout.newTab().setText("자율동아리"));


        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.promotionpager);

        viewPager.setAdapter(new PagerAdapter
                (getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }


        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    PromotionFragment1 tab1 = new PromotionFragment1();
                    return tab1;
                case 1:
                    PromotionFragment2 tab2 = new PromotionFragment2();
                    return tab2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }













    /**
     * Created by Administrator on 2017-02-10.
     */

    public static class PromotionFragment1 extends ListFragment {

        Promotion1ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Promotion1ListViewAdapter() ;
            setListAdapter(adapter) ;

            adapter.addItem("Test", "카테고리 : IT" , "담당자 연락처 : 성주원" , "설명 없음");
            adapter.addItem("HOOK", "카테고리 : 예체능" , "담당자 연락처 : 010 4674 831" , "안녕하세요 원묵고 여자 댄스동아리\uD83C\uDF38HOOK\uD83C\uDF38입니다! \n" +
                    "저희 동아리는 여자 댄스 동아리라 매우 생기가 넘치고 편하고 즐거워요\uD83D\uDC4D\uD83C\uDFFB\n" +
                    "생기부때문에 걱정이 많을텐데 너무 걱정하지말고 고등학교 생활 즐겁게 춤추면서 보내는건 어떤가요? 혹시 해서 말하자면 모든 부원이 공부를 0순위로 두고 있어요 \uD83D\uDCAA그렇다고 생기부에 조금 적히거나 양이 적지 않으니 걱정 마세요!! (저희 담당쌤이 빵빵하게 적어주십니다\uD83D\uDC4D\uD83C\uDFFB) 축제의 꽃이 될 기회를 놓치지 마세요\uD83C\uDF3A\n" +
                    "축제만 올라가는게아니라 찬조도 소공연도 있어요\uD83D\uDE0A\n" +
                    "축제기간에 같이 축제준비도 하고 먹을것도 먹고!!!!!\n" +
                    "춤 못춰도 관심있거나 좋아하면 되니까 부담없이 편하게 와요~~\uD83D\uDE09\n" +
                    "✨춤출 인원은 무한대! 음악 편집과 댄스부원들 연습 하는거 체크해주고 함께 재밌는 추억 만들어 갈 스태프도 모집하고 있으니까 많이 오세요❣ 스탭 남여 상관없이 4명 모집합니다✨\n" +
                    "\uD83D\uDE01궁금한거 있으면 언제든지 페메해주세요\uD83D\uDE01\n" +
                    "                   \uD83D\uDC95간 단 하 게 정 리 하 자 면\uD83D\uDC95\n" +
                    "공부가 힘들 때 스트레스를 날려버릴 수 있는 동아리 ❗\n" +
                    "춤 연습 하면서 언니 , 친구들과 친목 다지며 좋은 추억 많이 만들수 있는 동아리\uD83D\uDC4D\n" +
                    "댄스부 중에 생기부 제일 길게 써주시는 선생님과 함께 합니다 ☺ ");

            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Promotion1ListViewitem item = ( Promotion1ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Promotion1ListViewAdapter extends BaseAdapter {

            private ArrayList<Promotion1ListViewitem> listViewItemList = new ArrayList() ;

            public Promotion1ListViewAdapter() {

            }

            @Override
            public int getCount() {
                return listViewItemList.size() ;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final int pos = position;
                final Context context = parent.getContext();

                if (convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.promotion1listview_item, parent, false);
                }

                TextView promotion1titleTextView = (TextView) convertView.findViewById(R.id.promotion1title);
                TextView promotiond1escTextView = (TextView) convertView.findViewById(R.id.promotion1desc);
                TextView promotiond1esc2TextView = (TextView) convertView.findViewById(R.id.promotion1desc2);
                TextView promotiond1esc3TextView = (TextView) convertView.findViewById(R.id.promotion1desc3);

                Promotion1ListViewitem listViewItem= listViewItemList.get(position);

                // 아이템 내 각 위젯에 데이터 반영
                promotion1titleTextView.setText(listViewItem.getTitle());
                promotiond1escTextView.setText(listViewItem.getDesc());
                promotiond1esc2TextView.setText(listViewItem.getDesc2());
                promotiond1esc3TextView.setText(listViewItem.getDesc3());

                return convertView;
            }


            // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
            @Override
            public long getItemId(int position) {
                return position ;
            }

            // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
            @Override
            public Object getItem(int position) {
                return listViewItemList.get(position) ;
            }

            // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
            public void addItem(String promotion1title, String promotion1desc , String promotion1desc2 , String promotion1desc3) {
                Promotion1ListViewitem item = new Promotion1ListViewitem();

                item.setPromotion1Title(promotion1title);
                item.setPromotion1Desc(promotion1desc);
                item.setPromotion1Desc2(promotion1desc2);
                item.setPromotion1Desc3(promotion1desc3);

                listViewItemList.add(item);
            }
        }

        public class Promotion1ListViewitem {
            private String promotion1titleStr ;
            private String promotion1descStr ;
            private String promotion1desc2Str ;
            private String promotion1desc3Str ;

            public void setPromotion1Title(String title) { promotion1titleStr = title ; }
            public void setPromotion1Desc(String desc) {promotion1descStr = desc ;}
            public void setPromotion1Desc2(String desc2) {promotion1desc2Str = desc2 ;}
            public void setPromotion1Desc3(String desc3) {promotion1desc3Str = desc3 ;}

            public String getTitle() {return this.promotion1titleStr ;}
            public String getDesc() { return this.promotion1descStr ; }
            public String getDesc2() { return this.promotion1desc2Str ; }
            public String getDesc3() { return this.promotion1desc3Str ; }
        }

    }










    /**
     * Created by Administrator on 2017-02-23.
     */

    public static class PromotionFragment2 extends ListFragment {

        Promotion2ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Promotion2ListViewAdapter() ;
            setListAdapter(adapter) ;

            adapter.addItem("Test", "카테고리 : IT" , "GeForce 동아리는 Android Studio를 이용한 어플리케이션 개발 동아리 입니다");

            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {
            // get TextView's Text.
            Promotion2ListViewitem item = (Promotion2ListViewitem) l.getItemAtPosition(position) ;

            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;

        }

        public void addItem(String title, String desc , String desc2) {
            adapter.addItem(title, desc , desc2) ;
        }

        public class Promotion2ListViewAdapter extends BaseAdapter {
            private ArrayList<Promotion2ListViewitem> listViewItemList = new ArrayList() ;

            public Promotion2ListViewAdapter() {

            }

            @Override
            public int getCount() {
                return listViewItemList.size() ;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final int pos = position;
                final Context context = parent.getContext();

                if (convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.promotion2listview_item, parent, false);
                }

                TextView promotion2titleTextView = (TextView) convertView.findViewById(R.id.promotion2title);
                TextView promotiond2escTextView = (TextView) convertView.findViewById(R.id.promotion2desc);
                TextView promotiond2esc2TextView = (TextView) convertView.findViewById(R.id.promotion2desc2);

                Promotion2ListViewitem listViewItem= listViewItemList.get(position);

                // 아이템 내 각 위젯에 데이터 반영
                promotion2titleTextView.setText(listViewItem.getTitle());
                promotiond2escTextView.setText(listViewItem.getDesc());
                promotiond2esc2TextView.setText(listViewItem.getDesc2());

                return convertView;
            }

            // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
            @Override
            public long getItemId(int position) {
                return position ;
            }

            // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
            @Override
            public Object getItem(int position) {
                return listViewItemList.get(position) ;
            }

            // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
            public void addItem(String promotion2title, String promotion2desc , String promotion2desc2) {
                Promotion2ListViewitem item = new Promotion2ListViewitem();

                item.setPromotion2Title(promotion2title);
                item.setPromotion2Desc(promotion2desc);
                item.setPromotion2Desc2(promotion2desc2);

                listViewItemList.add(item);
            }
        }

        public class Promotion2ListViewitem {
            private String promotion2titleStr ;
            private String promotion2descStr ;
            private String promotion2desc2Str ;

            public void setPromotion2Title(String title) { promotion2titleStr = title ; }
            public void setPromotion2Desc(String desc) {promotion2descStr = desc ;}
            public void setPromotion2Desc2(String desc2) {promotion2desc2Str = desc2 ;}

            public String getTitle() {return this.promotion2titleStr ;}
            public String getDesc() { return this.promotion2descStr ; }
            public String getDesc2() { return this.promotion2desc2Str ; }
        }

    }
}

