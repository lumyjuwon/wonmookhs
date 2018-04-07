package wonmookapp.hs.kr.wonmookhs;

import android.content.Context;
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
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Promotion2Fragment extends Fragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_teacherloca, container, false);

        TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("이과"));
        tabLayout.addTab(tabLayout.newTab().setText("문과"));
        tabLayout.addTab(tabLayout.newTab().setText("공과"));
        tabLayout.addTab(tabLayout.newTab().setText("예체능과"));
        tabLayout.addTab(tabLayout.newTab().setText("기타"));


        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.pager);

        viewPager.setAdapter(new Promotion2Fragment.FragmentPagerAdapter
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
                    Promotion2Fragment.Nature2Fragment tab1 = new Promotion2Fragment.Nature2Fragment();
                    return tab1;
                case 1:
                    Promotion2Fragment.Humanities2Fragment tab2 = new Promotion2Fragment.Humanities2Fragment();
                    return tab2;
                case 2:
                    Promotion2Fragment.Engineering2Fragment tab3 = new Promotion2Fragment.Engineering2Fragment();
                    return tab3;
                case 3:
                    Promotion2Fragment.Art2Fragment tab4 = new Promotion2Fragment.Art2Fragment();
                    return tab4;
                case 4:
                    Promotion2Fragment.Etc2Fragment tab5 = new Promotion2Fragment.Etc2Fragment();
                    return tab5;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }





    public static class Nature2Fragment extends ListFragment {

        Promotion2Fragment.Nature2Fragment.Nature2ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Promotion2Fragment.Nature2Fragment.Nature2ListViewAdapter() ;
            setListAdapter(adapter) ;

            //adapter.addItem("Test", "카테고리 : IT" , "담당자 연락처 : 성주원" , "설명 없음");
            adapter.addItem("등록 된 동아리가 없습니다", "등록을 신청 해주시기 바랍니다" , "담당자 연락처 : 메뉴 -> 어플리케이션 센터 참고" , null);



            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Promotion2Fragment.Nature2Fragment.Nature2ListViewitem item = (Promotion2Fragment.Nature2Fragment.Nature2ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Nature2ListViewAdapter extends BaseAdapter {

            private ArrayList<Nature2ListViewitem> listViewItemList = new ArrayList() ;

            public Nature2ListViewAdapter() {

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
                TextView promotiond2esc3TextView = (TextView) convertView.findViewById(R.id.promotion2desc3);

                Promotion2Fragment.Nature2Fragment.Nature2ListViewitem listViewItem= listViewItemList.get(position);

                // 아이템 내 각 위젯에 데이터 반영
                promotion2titleTextView.setText(listViewItem.getTitle());
                promotiond2escTextView.setText(listViewItem.getDesc());
                promotiond2esc2TextView.setText(listViewItem.getDesc2());
                promotiond2esc3TextView.setText(listViewItem.getDesc3());

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
            public void addItem(String promotion2title, String promotion2desc , String promotion2desc2 , String promotion2desc3) {
                Promotion2Fragment.Nature2Fragment.Nature2ListViewitem item = new Promotion2Fragment.Nature2Fragment.Nature2ListViewitem();

                item.setPromotion2Title(promotion2title);
                item.setPromotion2Desc(promotion2desc);
                item.setPromotion2Desc2(promotion2desc2);
                item.setPromotion2Desc3(promotion2desc3);

                listViewItemList.add(item);
            }
        }

        public class Nature2ListViewitem {
            private String promotion2titleStr ;
            private String promotion2descStr ;
            private String promotion2desc2Str ;
            private String promotion2desc3Str ;

            public void setPromotion2Title(String title) { promotion2titleStr = title ; }
            public void setPromotion2Desc(String desc) {promotion2descStr = desc ;}
            public void setPromotion2Desc2(String desc2) {promotion2desc2Str = desc2 ;}
            public void setPromotion2Desc3(String desc3) {promotion2desc3Str = desc3 ;}

            public String getTitle() {return this.promotion2titleStr ;}
            public String getDesc() { return this.promotion2descStr ; }
            public String getDesc2() { return this.promotion2desc2Str ; }
            public String getDesc3() { return this.promotion2desc3Str ; }
        }

    }





    public static class Humanities2Fragment extends ListFragment {

        Promotion2Fragment.Humanities2Fragment.Humanities2ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Promotion2Fragment.Humanities2Fragment.Humanities2ListViewAdapter() ;
            setListAdapter(adapter) ;

            //adapter.addItem("Test", "카테고리 : IT" , "담당자 연락처 : 성주원" , "설명 없음");
            adapter.addItem("등록 된 동아리가 없습니다", "등록을 신청 해주시기 바랍니다" , "담당자 연락처 : 메뉴 -> 어플리케이션 센터 참고" , null);

            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Promotion2Fragment.Humanities2Fragment.Humanities2ListViewitem item = (Promotion2Fragment.Humanities2Fragment.Humanities2ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Humanities2ListViewAdapter extends BaseAdapter {

            private ArrayList<Humanities2ListViewitem> listViewItemList = new ArrayList() ;

            public Humanities2ListViewAdapter() {

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
                TextView promotiond2esc3TextView = (TextView) convertView.findViewById(R.id.promotion2desc3);

                Promotion2Fragment.Humanities2Fragment.Humanities2ListViewitem listViewItem= listViewItemList.get(position);

                // 아이템 내 각 위젯에 데이터 반영
                promotion2titleTextView.setText(listViewItem.getTitle());
                promotiond2escTextView.setText(listViewItem.getDesc());
                promotiond2esc2TextView.setText(listViewItem.getDesc2());
                promotiond2esc3TextView.setText(listViewItem.getDesc3());

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
            public void addItem(String promotion2title, String promotion2desc , String promotion2desc2 , String promotion2desc3) {
                Promotion2Fragment.Humanities2Fragment.Humanities2ListViewitem item = new Promotion2Fragment.Humanities2Fragment.Humanities2ListViewitem();

                item.setPromotion2Title(promotion2title);
                item.setPromotion2Desc(promotion2desc);
                item.setPromotion2Desc2(promotion2desc2);
                item.setPromotion2Desc3(promotion2desc3);

                listViewItemList.add(item);
            }
        }

        public class Humanities2ListViewitem {
            private String promotion2titleStr ;
            private String promotion2descStr ;
            private String promotion2desc2Str ;
            private String promotion2desc3Str ;

            public void setPromotion2Title(String title) { promotion2titleStr = title ; }
            public void setPromotion2Desc(String desc) {promotion2descStr = desc ;}
            public void setPromotion2Desc2(String desc2) {promotion2desc2Str = desc2 ;}
            public void setPromotion2Desc3(String desc3) {promotion2desc3Str = desc3 ;}

            public String getTitle() {return this.promotion2titleStr ;}
            public String getDesc() { return this.promotion2descStr ; }
            public String getDesc2() { return this.promotion2desc2Str ; }
            public String getDesc3() { return this.promotion2desc3Str ; }
        }

    }






    public static class Engineering2Fragment extends ListFragment {

        Promotion2Fragment.Engineering2Fragment.Engineering2ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Promotion2Fragment.Engineering2Fragment.Engineering2ListViewAdapter() ;
            setListAdapter(adapter) ;

            adapter.addItem("We are developers", "카테고리 : 어플리케이션 개발" , "담당자 연락처 : 010 9688 1278" , "We are developers 자율동아리는 원묵고등학교 어플리케이션을 개발 및 " +
                    "관리하고 있는 자율동아리입니다. 저희 자율동아리는 3학년 개발진 분들이 1학년 및 2학년 후배분들에게 학교 어플리케이션 관리 및 개발하는 방법을 알려드리며 , 저희가" +
                    " 졸업하고 나서도 저희 대신 저희의 역할을 꾸준하게 이어나가실 후배 분들을 모집하고 있습니다. We are developers 자율동아리에 대한 가입 정보는 추후 교내에서 알려드릴 예정입니다. ");

            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Promotion2Fragment.Engineering2Fragment.Engineering2ListViewitem item = (Promotion2Fragment.Engineering2Fragment.Engineering2ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Engineering2ListViewAdapter extends BaseAdapter {

            private ArrayList<Engineering2ListViewitem> listViewItemList = new ArrayList() ;

            public Engineering2ListViewAdapter() {

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
                TextView promotiond2esc3TextView = (TextView) convertView.findViewById(R.id.promotion2desc3);

                Promotion2Fragment.Engineering2Fragment.Engineering2ListViewitem listViewItem= listViewItemList.get(position);

                // 아이템 내 각 위젯에 데이터 반영
                promotion2titleTextView.setText(listViewItem.getTitle());
                promotiond2escTextView.setText(listViewItem.getDesc());
                promotiond2esc2TextView.setText(listViewItem.getDesc2());
                promotiond2esc3TextView.setText(listViewItem.getDesc3());

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
            public void addItem(String promotion2title, String promotion2desc , String promotion2desc2 , String promotion2desc3) {
                Promotion2Fragment.Engineering2Fragment.Engineering2ListViewitem item = new Promotion2Fragment.Engineering2Fragment.Engineering2ListViewitem();

                item.setPromotion2Title(promotion2title);
                item.setPromotion2Desc(promotion2desc);
                item.setPromotion2Desc2(promotion2desc2);
                item.setPromotion2Desc3(promotion2desc3);

                listViewItemList.add(item);
            }
        }

        public class Engineering2ListViewitem {
            private String promotion2titleStr ;
            private String promotion2descStr ;
            private String promotion2desc2Str ;
            private String promotion2desc3Str ;

            public void setPromotion2Title(String title) { promotion2titleStr = title ; }
            public void setPromotion2Desc(String desc) {promotion2descStr = desc ;}
            public void setPromotion2Desc2(String desc2) {promotion2desc2Str = desc2 ;}
            public void setPromotion2Desc3(String desc3) {promotion2desc3Str = desc3 ;}

            public String getTitle() {return this.promotion2titleStr ;}
            public String getDesc() { return this.promotion2descStr ; }
            public String getDesc2() { return this.promotion2desc2Str ; }
            public String getDesc3() { return this.promotion2desc3Str ; }
        }

    }









    public static class Art2Fragment extends ListFragment {

        Promotion2Fragment.Art2Fragment.Art2ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Promotion2Fragment.Art2Fragment.Art2ListViewAdapter() ;
            setListAdapter(adapter) ;

            //adapter.addItem("Test", "카테고리 : IT" , "담당자 연락처 : 성주원" , "설명 없음");
            adapter.addItem("등록 된 동아리가 없습니다", "등록을 신청 해주시기 바랍니다" , "담당자 연락처 : 메뉴 -> 어플리케이션 센터 참고" , null);


            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Promotion2Fragment.Art2Fragment.Art2ListViewitem item = (Promotion2Fragment.Art2Fragment.Art2ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Art2ListViewAdapter extends BaseAdapter {

            private ArrayList<Art2ListViewitem> listViewItemList = new ArrayList() ;

            public Art2ListViewAdapter() {

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
                TextView promotiond2esc3TextView = (TextView) convertView.findViewById(R.id.promotion2desc3);

                Promotion2Fragment.Art2Fragment.Art2ListViewitem listViewItem= listViewItemList.get(position);

                // 아이템 내 각 위젯에 데이터 반영
                promotion2titleTextView.setText(listViewItem.getTitle());
                promotiond2escTextView.setText(listViewItem.getDesc());
                promotiond2esc2TextView.setText(listViewItem.getDesc2());
                promotiond2esc3TextView.setText(listViewItem.getDesc3());

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
            public void addItem(String promotion2title, String promotion2desc , String promotion2desc2 , String promotion2desc3) {
                Promotion2Fragment.Art2Fragment.Art2ListViewitem item = new Promotion2Fragment.Art2Fragment.Art2ListViewitem();

                item.setPromotion2Title(promotion2title);
                item.setPromotion2Desc(promotion2desc);
                item.setPromotion2Desc2(promotion2desc2);
                item.setPromotion2Desc3(promotion2desc3);

                listViewItemList.add(item);
            }
        }

        public class Art2ListViewitem {
            private String promotion2titleStr ;
            private String promotion2descStr ;
            private String promotion2desc2Str ;
            private String promotion2desc3Str ;

            public void setPromotion2Title(String title) { promotion2titleStr = title ; }
            public void setPromotion2Desc(String desc) {promotion2descStr = desc ;}
            public void setPromotion2Desc2(String desc2) {promotion2desc2Str = desc2 ;}
            public void setPromotion2Desc3(String desc3) {promotion2desc3Str = desc3 ;}

            public String getTitle() {return this.promotion2titleStr ;}
            public String getDesc() { return this.promotion2descStr ; }
            public String getDesc2() { return this.promotion2desc2Str ; }
            public String getDesc3() { return this.promotion2desc3Str ; }
        }

    }

    public static class Etc2Fragment extends ListFragment {

        Promotion2Fragment.Etc2Fragment.Etc2ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Promotion2Fragment.Etc2Fragment.Etc2ListViewAdapter() ;
            setListAdapter(adapter) ;

            adapter.addItem("W.F.N (The World's Florence Nightingale)", "카테고리 : 간호" , "담당자 연락처 : 010-4322-6037\n" +
                    "카카오톡 아이디 : AAA3215" , "저희 간호자율동아리의 정식명칭은 W.F.N(The World's Florence Nightingale)이며 이는 대한민국을 넘어 전세계적의 나이팅게일이 되자는 다짐과 열정의 뜻을 담고 있습니다\uD83D\uDE0A 미래의 보건의료인!!!!!!! 특히 간호인을 희망하신다면 W.F.N에서 이루어지는 다양한 활동들을 통해 자신의 꿈을 현실로 만드시길 진심으로 바랍니다" +
                    "\uD83D\uDE04\uD83D\uDE04\uD83D\uDE04 저희는 간호의료기구 및 간호용어 조사, 간호학 박물관 견학 등의 활동을 통해 보다 전문적인 간호지식을 습득할 수 있는 시간을 마련할 것이며 더불어 생명윤리에 관한 주제를 선정해 자신의 의견을 발표하고 토론하는 활동을 통해 자신의 올바른 생명가치관을 확립하고 더 넓은 시야를 만들 수 있도록 할 것 입니다! 이러한 활동들을 통해 ♡보다 준비된 간호인♡과 꿈을 현실로 만들 수 있는 시간을 가질 예정입니다\uD83D\uDE3B 보건의료인에 대한 열정먼 있으시다면 누구든 환영입니다~♡.♡");

            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Promotion2Fragment.Etc2Fragment.Etc2ListViewitem item = (Promotion2Fragment.Etc2Fragment.Etc2ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Etc2ListViewAdapter extends BaseAdapter {

            private ArrayList<Etc2ListViewitem> listViewItemList = new ArrayList() ;

            public Etc2ListViewAdapter() {

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

                TextView Promotion2titleTextView = (TextView) convertView.findViewById(R.id.promotion2title);
                TextView promotiond1escTextView = (TextView) convertView.findViewById(R.id.promotion2desc);
                TextView promotiond1esc2TextView = (TextView) convertView.findViewById(R.id.promotion2desc2);
                TextView promotiond1esc3TextView = (TextView) convertView.findViewById(R.id.promotion2desc3);

                Promotion2Fragment.Etc2Fragment.Etc2ListViewitem listViewItem= listViewItemList.get(position);

                // 아이템 내 각 위젯에 데이터 반영
                Promotion2titleTextView.setText(listViewItem.getTitle());
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
            public void addItem(String Promotion2title, String Promotion2desc , String Promotion2desc2 , String Promotion2desc3) {
                Promotion2Fragment.Etc2Fragment.Etc2ListViewitem item = new Promotion2Fragment.Etc2Fragment.Etc2ListViewitem();

                item.setPromotion2Title(Promotion2title);
                item.setPromotion2Desc(Promotion2desc);
                item.setPromotion2Desc2(Promotion2desc2);
                item.setPromotion2Desc3(Promotion2desc3);

                listViewItemList.add(item);
            }
        }

        public class Etc2ListViewitem {
            private String Promotion2titleStr ;
            private String Promotion2descStr ;
            private String Promotion2desc2Str ;
            private String Promotion2desc3Str ;

            public void setPromotion2Title(String title) { Promotion2titleStr = title ; }
            public void setPromotion2Desc(String desc) {Promotion2descStr = desc ;}
            public void setPromotion2Desc2(String desc2) {Promotion2desc2Str = desc2 ;}
            public void setPromotion2Desc3(String desc3) {Promotion2desc3Str = desc3 ;}

            public String getTitle() {return this.Promotion2titleStr ;}
            public String getDesc() { return this.Promotion2descStr ; }
            public String getDesc2() { return this.Promotion2desc2Str ; }
            public String getDesc3() { return this.Promotion2desc3Str ; }
        }

    }



}
