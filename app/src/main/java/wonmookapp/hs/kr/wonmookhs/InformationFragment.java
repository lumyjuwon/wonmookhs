package wonmookapp.hs.kr.wonmookhs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InformationFragment extends ListFragment {

    InformationListViewAdapter adapter ;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        adapter = new InformationListViewAdapter() ;
        setListAdapter(adapter) ;

        adapter.addItem("향학당", "학기 중 : 오전 9 시 ~ 오후 12 시" , "방학 중 : 오전 9 시 ~ 오후 10 시");
        adapter.addItem("도서관", "학기 중 : 오전 9 시 ~ 오후 6 시" , "방학 중 : 오전 9 시 ~ 오후 6 시 ");
        adapter.addItem("체육관", "학기 중 : 오전 9 시 ~ 오후 6 시" , "방학 중 : 휴무");
        adapter.addItem("급식실", "점심 : 오전 12 시 ~ 오후 1시 10분" , "석식 : 오후 5시 50 분~ 오후 7시");
        adapter.addItem("탁구장", "학기 중 : 오전 9 시 ~ 오후 6 시 30 분" , "방학 중 : 휴무");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick (ListView l, View v, int position, long id) {
        // get TextView's Text.
        InformationListViewitem item = (InformationListViewitem) l.getItemAtPosition(position) ;

        String titleStr = item.getTitle() ;
        String descStr = item.getDesc() ;
        String desc2Str = item.getDesc2() ;

    }

    public void addItem(String title, String desc , String desc2) {
        adapter.addItem(title, desc , desc2) ;
    }

    public class InformationListViewAdapter extends BaseAdapter {
        private ArrayList<InformationListViewitem> listViewItemList = new ArrayList() ;

        public InformationListViewAdapter() {

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
                convertView = inflater.inflate(R.layout.informationlistview_item, parent, false);
            }

            TextView informationtitleTextView = (TextView) convertView.findViewById(R.id.informationtitle);
            TextView informationdescTextView = (TextView) convertView.findViewById(R.id.informationdesc);
            TextView informationdesc2TextView = (TextView) convertView.findViewById(R.id.informationdesc2);

            InformationListViewitem listViewItem= listViewItemList.get(position);

            // 아이템 내 각 위젯에 데이터 반영
            informationtitleTextView.setText(listViewItem.getTitle());
            informationdescTextView.setText(listViewItem.getDesc());
            informationdesc2TextView.setText(listViewItem.getDesc2());

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
        public void addItem(String informationtitle, String informationdesc , String informationdesc2) {
            InformationListViewitem item = new InformationListViewitem();

            item.setInformationTitle(informationtitle);
            item.setInformationDesc(informationdesc);
            item.setInformationDesc2(informationdesc2);

            listViewItemList.add(item);
        }
    }

    public class InformationListViewitem {
        private String informationtitleStr ;
        private String informationdescStr ;
        private String informationdesc2Str ;

        public void setInformationTitle(String title) { informationtitleStr = title ; }
        public void setInformationDesc(String desc) {informationdescStr = desc ;}
        public void setInformationDesc2(String desc2) {
            informationdesc2Str = desc2 ;
        }

        public String getTitle() {
            return this.informationtitleStr ;
        }
        public String getDesc() { return this.informationdescStr ; }
        public String getDesc2() { return this.informationdesc2Str ; }
    }

}
