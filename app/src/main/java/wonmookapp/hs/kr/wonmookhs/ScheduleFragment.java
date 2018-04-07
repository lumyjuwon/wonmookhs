package wonmookapp.hs.kr.wonmookhs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class ScheduleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_schoolschedule, container, false);

        final String[] schedulemonth = {"2017년 4월", "2017년 5월", "2017년 6월", "2017년 7월"};

        final Integer[] schedulemonthimage = {R.drawable.m_201704, R.drawable.m_201705, R.drawable.m_201706, R.drawable.m_201707};

        final Spinner schedulespinner = (Spinner) rootView.findViewById(R.id.spinner_schedule);
        final ImageView schedulecalendar = (ImageView) rootView.findViewById(R.id.schedulecalendar);
        schedulecalendar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        schedulecalendar.setPadding(5, 5, 5, 5);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String> (getActivity(), android.R.layout.simple_spinner_item, schedulemonth);

        schedulespinner.setAdapter(adapter);

        schedulespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                schedulecalendar.setImageResource(schedulemonthimage[arg2]);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        return rootView;
    }

    @Override
    public void onDestroyView()
    {
        Log.d("ITPANGPANG","OnDestroyTeacherLocalFragment");
        super.onDestroyView();
    }

}