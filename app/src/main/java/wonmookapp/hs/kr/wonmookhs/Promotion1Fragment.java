package wonmookapp.hs.kr.wonmookhs;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Promotion1Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Wonmook", "onCreateTeacherLocalFragment");
        View inflatedView = inflater.inflate(R.layout.fragment_teacherloca, container, false);

        TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("이과"));
        tabLayout.addTab(tabLayout.newTab().setText("문과"));
        tabLayout.addTab(tabLayout.newTab().setText("공과"));
        tabLayout.addTab(tabLayout.newTab().setText("예체능과"));
        tabLayout.addTab(tabLayout.newTab().setText("기타"));


        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.pager);

        viewPager.setAdapter(new Promotion1Fragment.FragmentPagerAdapter
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
    public void onDestroyView() {
        Log.d("Wonmook", "OnDestroyTeacherLocalFragment");
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
                    Nature1Fragment tab1 = new Nature1Fragment();
                    return tab1;
                case 1:
                    Humanities1Fragment tab2 = new Humanities1Fragment();
                    return tab2;
                case 2:
                    Engineering1Fragment tab3 = new Engineering1Fragment();
                    return tab3;
                case 3:
                    Art1Fragment tab4 = new Art1Fragment();
                    return tab4;
                case 4:
                    Etc1Fragment tab5 = new Etc1Fragment();
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





    public static class Nature1Fragment extends ListFragment {

        Nature1ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Nature1ListViewAdapter() ;
            setListAdapter(adapter) ;

            //            adapter.addItem("Test", "카테고리 : IT" , "담당자 연락처 : 성주원" , "설명 없음");

            adapter.addItem("QM", "카테고리 : 과학실험" , "담당자 연락처 : 010 6612 9246" , "\uD83D\uDC99과학이 좋아서\n" +
                    "\uD83D\uDC9A재미없는 동아리가 좋지 않아서\n" +
                    "\uD83D\uDC9B동아리가 적당해서 \n" +
                    "모든게 좋은 QM에 들어와야 하는 이유!!\n" +
                    "\n" +
                    "☝첫째, 개교 11년 QM도 11년!!\n" +
                    "원묵 개교 이후로 원묵의 역사와 함께해온 전통있는‼ 동아리 QM. 지금까지 동아리를 이끌어온 멋진 선생님들과 선배님들 덕분에 어느 동아리보다 체계적이고 재미있는 동아리입니다.\n" +
                    "\n" +
                    "✌둘째, 역시는 역시인 이과탑 QM\n" +
                    "하고 싶은 실험들을 직접 계획하고 실험하는 QM에서는 헐..이걸 고등학생이..??하는 실험까지도 할 수 있습니다. 예를 들면 살아있는 쥐를 직접...? 쥐해부실험, 해열제를 만들어보는 아스피린 합성실험, 순간 온도 2000도씨 돌파!! 철을 만들어보는 테르밋 반응 폭파실험, 등등 수도 없이 많은 실험들을 직접 계획하고 실험해봤습니다.\n" +
                    "\n" +
                    "\uD83D\uDC4C셋째, 생기부 빵빵 QM\n" +
                    "QM과 함께라면 생기부란이 가득~~ 빈칸 없이 꽉꽉 채워질겁니다. QM에서 한 실험만 적어도 빈칸이 사라지는 기적\uD83C\uDF31 하지만 물론 생기부에 적히는 양만 중요한건 아닐거에요 그래서 QM은 여러가지 다채로운 활동들과 실험으로 꼭꼭 눌러담았습니다. 덕분에 서울대 선배님들이 모두 QM을 거쳐갔단건 비밀아닌 비밀\uD83D\uDC40\n" +
                    "\n" +
                    "✋넷째, 여러가지 다채로운 활동들\n" +
                    "고등학교하면 축제 아니겠어요? 동아리마다 부스를 운영해 축제를 즐기는 원묵고 축제 묵향제!! 그중에 하이라이트는 뭐니뭐니 해도 큐엠이죠.\uD83D\uDE01 솜사탕.야광팔찌. 쿨팩. 액체질소 얼음과자등 축제에 빠질수 없는 여러가지 음식과 소품들을 직접 만드는 행사를 해온 큐엠. 내년에는 신입생 여러분과 같이 해볼생각에 벌써 두근두근해요 ㅎㅎ\n" +
                    "고등학교 친구들과 함께 즐기는 축제뿐만이 아니라 다른 학교 학생들과 주민분들과 함께할 수 있는 수학과학체험전과 그외 여러가지 봉사활동까지~~ 모두 놓치지 말자구요\uD83D\uDC4F\uD83D\uDC4F");


            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Nature1ListViewitem item = (Nature1ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Nature1ListViewAdapter extends BaseAdapter {

            private ArrayList<Nature1ListViewitem> listViewItemList = new ArrayList() ;

            public Nature1ListViewAdapter() {

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

                Nature1ListViewitem listViewItem= listViewItemList.get(position);

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
                Nature1ListViewitem item = new Nature1ListViewitem();

                item.setPromotion1Title(promotion1title);
                item.setPromotion1Desc(promotion1desc);
                item.setPromotion1Desc2(promotion1desc2);
                item.setPromotion1Desc3(promotion1desc3);

                listViewItemList.add(item);
            }
        }

        public class Nature1ListViewitem {
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





    public static class Humanities1Fragment extends ListFragment {

        Humanities1ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Humanities1ListViewAdapter() ;
            setListAdapter(adapter) ;

            //            adapter.addItem("Test", "카테고리 : IT" , "담당자 연락처 : 성주원" , "설명 없음");

            adapter.addItem("Yz", "카테고리 : 인문사회탐구" , "담당자 연락처 : 부장 이준혁 (2-6) 010 2031 2750 " +
                    "차장 강미주 (2-3) 010 6320 0906 " ,
                    "안녕하세요 원묵고 동아리 \uD83C\uDF1FYz\uD83C\uDF1F 입니다! 1학년 2학년 신입부원 모집을 위해 홍보하러왔어요\uD83D\uDE09\n" +
                    "\n" +
                    "\n" +
                    "☝먼저! 개인별 또는 조별 탐구보고서를 작성하고 토론합니다 예를 들어, 작년에는 「진로결정여부와 학업성취도의 상관관계」 라는 주제로 토론을 했고, 설문조사나 면담을 하는 등 깊이있는 탐구활동을 진행했습니다. \n" +
                    "\n" +
                    "뿐만아니라❗각자 진로나 관심분야에 대하여 칼럼과 기사를 쓰기도 합니다. \n" +
                            "\n" +
                    "✌ 그외에는, 다양한 외부 체험활동과 축제 부스를 운영을 하고 있습니다. 올해는 색다르게 외부활동을 더 늘릴 생각이구요\uD83C\uDF88\n" +
                    "\n" +
                    "\n" +
                    "\uD83C\uDF1FYz\uD83C\uDF1F는 이렇게 많은 활동을 하는데요, \n" +
                    "\n" +
                    "자신이 쓴 탐구보고서, 칼럼, 기사 그리고 1년동안의 활동을 각자의 원하는 방향으로 생기부를 빵빵! 하게 채워주십니다.\n" +
                    "\n" +
                    "\n" +
                    "아직 진로 혹은 문이과도 결정하지 못한\uD83D\uDCA6 분들은 다양한 분야를 탐구해보는 기회가 될 수 있어요\uD83D\uDE4A\n" +
                    "\n" +
                    "\n" +
                    "면접은 3월 13일 월요일 사회윤리실입니다! 면접 지원시, 여기 담당자번호로 문자주세요 장기자랑 안해도 되니 부담없이 보러오세요\uD83D\uDC97\n" +
                    "\n" +
                    "\n" +
                    "더 궁금하신 점은 ☎");


            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Humanities1ListViewitem item = (Humanities1ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Humanities1ListViewAdapter extends BaseAdapter {

            private ArrayList<Humanities1ListViewitem> listViewItemList = new ArrayList() ;

            public Humanities1ListViewAdapter() {

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

                Humanities1ListViewitem listViewItem= listViewItemList.get(position);

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
                Humanities1ListViewitem item = new Humanities1ListViewitem();

                item.setPromotion1Title(promotion1title);
                item.setPromotion1Desc(promotion1desc);
                item.setPromotion1Desc2(promotion1desc2);
                item.setPromotion1Desc3(promotion1desc3);

                listViewItemList.add(item);
            }
        }

        public class Humanities1ListViewitem {
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






    public static class Engineering1Fragment extends ListFragment {

        Engineering1ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Engineering1ListViewAdapter() ;
            setListAdapter(adapter) ;

            //            adapter.addItem("Test", "카테고리 : IT" , "담당자 연락처 : 성주원" , "설명 없음");

            adapter.addItem("로봇반", "카테고리 : 로봇" , "담당자 연락처 : 010-8859-3453" , "" +
                    "원묵고에서 이과 동아리 중 유일하게 직접적인 기계 관련의 동아리입니다.\n" +
                    "일단 가장 중요한 생활기록부는 1년간 동아리 활동 중 매 차수마다 했던 활동들을 구체적으로\n" +
                    "적을 수 있습니다.\n" +
                    "매 차수마다 키트로 정해진 로봇을 만들긴 하나, 모듈러 방식의 로봇인지라, 자신이 원하는 대로도 만들 수 있습니다.\n" +
                    "또한, 원묵고에서 유일하게 3D프린터기를 사용할 수 있는 동아리이기도 합니다.\n" +
                    "수업은 매 차수마다 전문 강사님이 오셔서 강의를 하십니다.\n" +
                    "수업비는 없습니다.\n" +
                    "로봇이라고 해서 기계적인 수업, 딱딱한 수업이 아닙니다.\n" +
                    "그리고 학교 축제, 묵향제와 수학과학 체험전 부스운영으로 봉사활동시간도 확보가 가능합니다.\n" +
                    "기계 관련과의 진학을 희망하는 학생, 기계에 관심 있고 흥미를 느끼는 학생, 새롭고 참신한 동아리 활동을 시작해보고 싶은 학생들에게 로봇부를 추천합니다.\n" +
                    "\n" +
                    "동아리 가입 문의는 2-10 이희웅 학생이나, 4층 교무실의 이선길 선생님께 문의 바랍니다.");

            adapter.addItem("G.M.S", "카테고리 : 게임 제작" , "담당자 연락처 : 010 5285 2690" , "안녕하세요. G.M.S동아리 차장 박세진입니다.\n" +
                    "개학이 코앞으로 다가왔습니다 아직 동아리 결정을 내리지 못한 신입생 여러분들을 위해 저희동아리 홍보를 하겠습니다.\n" +
                    "저희동아리는 일단 ❇Game Maker S 라는 '게임을 만드는 사람들' 이란 이름으로 게임을 만드는 동아리입니다.\n" +
                    "저희 동아리에 4개의 팀이 있습니다.\n" +
                    "\uD83D\uDC9B첫번째 디자인,일러스트 팀 이팀은 게임에서 중요한 캐릭터 디자인을 맡고 있습니다.\n" +
                    "❤두번째 로 프로그래밍 팀 으로 제일 중요한 게임의 기반인 프로그램을 맡는 역할입니다.\n" +
                    "\uD83D\uDC9A세번째 시나리오 팀 이또한 중요합니다 스토리가 짜여지고 그 스토리의 토반대로 프로그램과 디자인이 결정되기 때문이죠.\n" +
                    "마지막으로 \n" +
                    "\uD83D\uDC99네번째 사운드 팀입니다.\n" +
                    "게임에서 사운드가 빠지면 섭하겠죠? 기본 배경음악 등등 중요한 임무를 갖고있죠.\n" +
                    "이렇게 4개의 팀 모두가 협동해서 만들어야 하나의 게임이되며 모두가 중요한 팀입니다.\n" +
                    " 면접을통해 뽑을 계획이며 할줄몰라도 선배들이 친절하게 차근차근 알려주니 게임쪽 분야 \uD83D\uDC96대학 이나 \uD83D\uDC9D직업에 생각이 있으신분은 망설이지 마시고 신청해 주세요.\n" +
                    "2학년도 뽑을거니 신청해주세요.");

            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Engineering1ListViewitem item = (Engineering1ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Engineering1ListViewAdapter extends BaseAdapter {

            private ArrayList<Engineering1ListViewitem> listViewItemList = new ArrayList() ;

            public Engineering1ListViewAdapter() {

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

                Engineering1ListViewitem listViewItem= listViewItemList.get(position);

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
                Engineering1ListViewitem item = new Engineering1ListViewitem();

                item.setPromotion1Title(promotion1title);
                item.setPromotion1Desc(promotion1desc);
                item.setPromotion1Desc2(promotion1desc2);
                item.setPromotion1Desc3(promotion1desc3);

                listViewItemList.add(item);
            }
        }

        public class Engineering1ListViewitem {
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









    public static class Art1Fragment extends ListFragment {

        Art1ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Art1ListViewAdapter() ;
            setListAdapter(adapter) ;

            //            adapter.addItem("Test", "카테고리 : IT" , "담당자 연락처 : 성주원" , "설명 없음");

            adapter.addItem("HOOK", "카테고리 : 댄스" , "담당자 연락처 : 010 4674 8313" , "안녕하세요 원묵고 여자 댄스동아리\uD83C\uDF38HOOK\uD83C\uDF38입니다! \n" +
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

            adapter.addItem("이치스", "카테고리 : 밴드" , "담당자 연락처 : 010 5042 0014" , "안녕하세요!원묵고 원조밴드부 \uD83D\uDC99이치스\uD83D\uDC99 입니다!\n" +
                    "다름이 아니라 저희 오디션일정 변경과 홍보공연 장소에대해 자세히 말씀드리려 합니다\uD83D\uDE0A\n" +
                    "\n" +
                    "오디션일정은 월요일(13일) 점심시간, 화요일(14일) 방과후에 할 예정입니다\uD83E\uDD17\uD83E\uDD17\uD83E\uDD17\n" +
                    "홍보때 말했던 것처럼 ❤보컬❤건반❤일렉❤드럼❤베이스❤스태프❤\n" +
                    "뽑습니다! 음악실에서 진행되기 때문에 건반과 드럼은 준비되어있고 일렉과 베이스는 개인준비로 해오셔야 합니다!\n" +
                    "\n" +
                    "홍보공연은 14일 화요일에 향학당 쪽 야외에 둥근 무대가 있는데 점심시간에 공연할 예정입니다~ 이치스에 관심이 없으시더라도 많이와서 구경해주세요\uD83E\uDD1E\uD83E\uDD1E");

            adapter.addItem("오케스트라", "카테고리 : 오케스트라" , "담당자 연락처 : 010 9901 1446" , "안녕하세요\uD83D\uDE4C모든 행사의 시작을 맡고있는 '오케스트라'동아리 입니다!!\uD83D\uDE0D\n" +
                    "평소에 음악에 관심이 많고 현악기.관악기.타악기를 조금이라도 연주하실수 있으시다면 누구든지 환영입니다\uD83D\uDC4D\uD83D\uDC4D\n" +
                    "저희 동아리의 장점은\uD83D\uDE09\n" +
                    "\n" +
                    "첫째!!너무나도 화목한 분위기입니다!서로 맞춰가야하는 동아리이니까 더욱더 화목하겠지요?그리고 선배들도 정말 착하답니다\uD83D\uDE4C\n" +
                    "\n" +
                    "둘째!!학교관리 동아리라 악기가 지원됩니다!!현재 바이올린,첼로,신디,스네어 등 다양한 악기가 지원되어있어서 악기가 없어도 부담이 없습니다\uD83D\uDC4D\uD83D\uDC4D(아쉽지만 지원되지 않는 악기도 있습니다ㅜ)\n" +
                    "\n" +
                    "마지막으로 지휘선생님이 오셔서 지도해주신다는 점입니다!!\n" +
                    "\n" +
                    "생기부가 중요하다고 생각해서 이런 예체능 동아리는 들어가기 꺼려하시는 분들이 많은데 저희 동아리는 생기부도 잘 써주시고 정말 좋아요\uD83D\uDE1C오케스트라 동아리를 통해 자신의 실력도 쌓고 합주하는 능력도 함께 길러보아요\uD83D\uDE46\uD83D\uDE46");



            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Art1ListViewitem item = (Art1ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Art1ListViewAdapter extends BaseAdapter {

            private ArrayList<Art1ListViewitem> listViewItemList = new ArrayList() ;

            public Art1ListViewAdapter() {

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

                Art1ListViewitem listViewItem= listViewItemList.get(position);

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
                Art1ListViewitem item = new Art1ListViewitem();

                item.setPromotion1Title(promotion1title);
                item.setPromotion1Desc(promotion1desc);
                item.setPromotion1Desc2(promotion1desc2);
                item.setPromotion1Desc3(promotion1desc3);

                listViewItemList.add(item);
            }
        }

        public class Art1ListViewitem {
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


    public static class Etc1Fragment extends ListFragment {

        Promotion1Fragment.Etc1Fragment.Etc1ListViewAdapter adapter ;

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState) {

            adapter = new Promotion1Fragment.Etc1Fragment.Etc1ListViewAdapter() ;
            setListAdapter(adapter) ;

            //            adapter.addItem("Test", "카테고리 : IT" , "담당자 연락처 : 성주원" , "설명 없음");

            adapter.addItem("방송부", "카테고리 : 방송" , "담당자 연락처 : 010-4249-0565" +
                    "\n010-9167-4145" , "안녕하세요 신입생여러분!!!! 지금 고등학교 갓 입학했는데 동아리때문에 고민중이시죠?\uD83D\uDE23 그래서 저희 ☞방송부☜를 홍보하려고 왔어요.\n" +
                    "\n" +
                    "저희동아리의 특징은\n" +
                    "\n" +
                    "첫째! 방송반 부장으로 뽑힌 학생은 학생회에 들어갈 수 있습니다!\n" +
                    "\n" +
                    "둘째!! 저희는 학교주요행사에 다참여해서 방송관련된일들을 도와주고있어요 축제,끼자랑,각동아리 발표회, 신입생ot, 격주 수요일마다있는 강의 등등 저희 방송반은 여러가지 활동들을 하고있습니다\uD83D\uDE0D\n" +
                    "\n" +
                    "셋째!! 매주 수요일,금요일 점심시간 음악방송과 다른행사활동을 하면서 엔지니어,방송작가,감독,아나운서등 다양한 역할들을 직접 맡아서 해보면서 실력을 쌓을수있어요\uD83D\uDE1D\n" +
                    "\n" +
                    "넷째!! 방송에관련된 동아리중 제대로된 방송장비를 만지고 체험해보고 직접 다루는 동아리는 저희동아리밖에 없어요\uD83D\uDE1A\n" +
                    "\n" +
                    "다섯째!! 동아리시간말고도 하는활동이 다양하고 많아서 생기부에 쓸내용이 많아지고 선후배간의 사이도 좋아요!!\uD83D\uDC95\uD83D\uDC95\n" +
                    "\n" +
                    "여섯째!! 시험기간에는 조용하고 저희만쓸수있는 방송부에서 각자 공부할수 있도록 해드려요ㅎㅎ\n" +
                    "\n" +
                    "저희 방송부는 꿈이 방송관련쪽이신분들은 더없이 좋은 동아리이구요 방송관련쪽이 아니시더라도 정말 재밌고 좋고 특별한 활동등을 통해서 흥미를 느끼실수 있는동아리에요!!! 면접일시와 장소등은 나중에따로 홍보돌때와 포스터로 공지해드릴테니 많이와주세요♥♥♥\n" +
                    "\n" +
                    "궁금하신점이 있으시면 부담갖지 말고 바로 010-4249-0565 혹은 010-9167-4145로 전화, 문자, 카톡, 페메를주시거나 페이스북 원묵고 방송반 페이지로 페메주시면 친절하게 답해드릴게요\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D");

            return super.onCreateView(inflater, container, savedInstanceState);
        }



        @Override
        public void onListItemClick (ListView l, View v, int position, long id) {

            // get TextView's Text.
            Promotion1Fragment.Etc1Fragment.Etc1ListViewitem item = (Promotion1Fragment.Etc1Fragment.Etc1ListViewitem) l.getItemAtPosition(position) ;


            String titleStr = item.getTitle() ;
            String descStr = item.getDesc() ;
            String desc2Str = item.getDesc2() ;
            String desc3Str = item.getDesc3() ;

        }

        public void addItem(String title, String desc , String desc2 , String desc3) {
            adapter.addItem(title, desc , desc2 , desc3) ;
        }

        public class Etc1ListViewAdapter extends BaseAdapter {

            private ArrayList<Etc1ListViewitem> listViewItemList = new ArrayList() ;

            public Etc1ListViewAdapter() {

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

                Promotion1Fragment.Etc1Fragment.Etc1ListViewitem listViewItem= listViewItemList.get(position);

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
                Promotion1Fragment.Etc1Fragment.Etc1ListViewitem item = new Promotion1Fragment.Etc1Fragment.Etc1ListViewitem();

                item.setPromotion1Title(promotion1title);
                item.setPromotion1Desc(promotion1desc);
                item.setPromotion1Desc2(promotion1desc2);
                item.setPromotion1Desc3(promotion1desc3);

                listViewItemList.add(item);
            }
        }

        public class Etc1ListViewitem {
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




}