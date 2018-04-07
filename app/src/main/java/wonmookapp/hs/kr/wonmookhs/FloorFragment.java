package wonmookapp.hs.kr.wonmookhs;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class FloorFragment extends Activity {

    public static class Floor6Fragment extends Fragment {

        private ImageSwitcher sw6;
        private Button admissioncouncelingcenter, thirdgradeedu, sixthfl;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Log.d("ITPANGPANG","onCreateView(Floor6)");
            View rootView = inflater.inflate(R.layout.fragment_floor6, container, false);

            sw6 = (ImageSwitcher) rootView.findViewById(R.id.sixthimagesw);
            admissioncouncelingcenter = (Button) rootView.findViewById(R.id.AdmissionCounselingCenter);
            thirdgradeedu = (Button) rootView.findViewById(R.id.ThirdGradeEdu);
            sixthfl = (Button) rootView.findViewById(R.id.sixthfloor);

            sw6.setFactory(new ViewSwitcher.ViewFactory(){
                @Override
                public View makeView() {
                    ImageView imageView = new ImageView(getActivity().getApplicationContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return imageView;
                }
            });

            admissioncouncelingcenter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw6.setImageResource(R.drawable.admissioncouncelingcenter);
                }
            });
            thirdgradeedu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw6.setImageResource(R.drawable.thirdgradeedu);
                }
            });

            sixthfl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw6.setImageResource(R.drawable.floor6);
                }
            });

            return rootView;

        }

        @Override
        public void onDestroy()
        {
            Log.d("ITPANGPANG","onDestoryFloorFragment");
            super.onDestroy();
        }

    }

    public static class Floor5Fragment extends Fragment {

        private ImageSwitcher sw5;
        private Button eduwelfare, secondgradeedu, lifemanneredu, humansocialedu, scientificinformationedu, fifthfl;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Log.d("ITPANGPANG","onCreateView(Floor5)");
            final View rootView = inflater.inflate(R.layout.fragment_floor5, container, false);

            sw5 = (ImageSwitcher) rootView.findViewById(R.id.fifthimagesw);
            eduwelfare = (Button) rootView.findViewById(R.id.eduwelfare);
            secondgradeedu = (Button) rootView.findViewById(R.id.SecondGradeEdu);
            lifemanneredu = (Button) rootView.findViewById(R.id.LifeMannerEdu);
            humansocialedu = (Button) rootView.findViewById(R.id.HumanSocialEdu);
            scientificinformationedu = (Button) rootView.findViewById(R.id.ScientificInformationEdu);
            fifthfl = (Button) rootView.findViewById(R.id.fifthfloor);

            sw5.setFactory(new ViewSwitcher.ViewFactory(){
                @Override
                public View makeView() {
                    ImageView imageView = new ImageView(getActivity().getApplicationContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return imageView;
                }
            });
            eduwelfare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw5.setImageResource(R.drawable.eduwelfare);
                }
            });
            secondgradeedu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw5.setImageResource(R.drawable.secondgradeedu);
                }
            });
            lifemanneredu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw5.setImageResource(R.drawable.lifemanneredu);
                }
            });
            humansocialedu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw5.setImageResource(R.drawable.humansocialedu);
                }
            });
            scientificinformationedu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw5.setImageResource(R.drawable.scientificinformationedu);
                }
            });
            fifthfl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw5.setImageResource(R.drawable.floor5);

                }

            });

            return rootView;

        }

        @Override
        public void onDestroy()
        {
            Log.d("ITPANGPANG","onDestroyView(5)");
            super.onDestroy();
        }

    }

    public static class Floor4Fragment extends Fragment {

        private ImageSwitcher sw4;
        private Button artroom, fourthfl, creative;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Log.d("ITPANGPANG","onCreateView(Floor4)");
            View rootView = inflater.inflate(R.layout.fragment_floor4, container, false);

            sw4 = (ImageSwitcher) rootView.findViewById(R.id.fourthimagesw);
            artroom = (Button) rootView.findViewById(R.id.artroom);
            fourthfl = (Button) rootView.findViewById(R.id.fourthfloor);
            creative = (Button) rootView.findViewById(R.id.CreativeExeperientialEdu);


            sw4.setFactory(new ViewSwitcher.ViewFactory(){
                @Override
                public View makeView() {
                    ImageView imageView = new ImageView(getActivity().getApplicationContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return imageView;
                }
            });
            artroom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw4.setImageResource(R.drawable.artroom);
                }
            });
            creative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw4.setImageResource(R.drawable.creativeexeperientialedu);
                }
            });

            fourthfl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw4.setImageResource(R.drawable.floor4);
                }
            });

            return rootView;

        }

        @Override
        public void onDestroy()
        {
            Log.d("ITPANGPANG","onDestroyView(4)");
            super.onDestroy();
        }

    }

    public static class Floor3Fragment extends Fragment {

        private ImageSwitcher sw3;
        private Button teachersroom1, thirdfl, firstgradeedu;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Log.d("ITPANGPANG","onCreateView(Floor3)");
            View rootView = inflater.inflate(R.layout.fragment_floor3, container, false);

            sw3 = (ImageSwitcher) rootView.findViewById(R.id.thirdimagesw);
            teachersroom1 = (Button) rootView.findViewById(R.id.FirstTeachersRoom);
            thirdfl = (Button) rootView.findViewById(R.id.thirdfloor);
            firstgradeedu = (Button) rootView.findViewById(R.id.FirstGradeEdu);


            sw3.setFactory(new ViewSwitcher.ViewFactory(){
                @Override
                public View makeView() {
                    ImageView imageView = new ImageView(getActivity().getApplicationContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return imageView;
                }
            });
            teachersroom1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw3.setImageResource(R.drawable.firstteachersroom);
                }
            });
            firstgradeedu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw3.setImageResource(R.drawable.firstgradeedu);
                }
            });

            thirdfl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw3.setImageResource(R.drawable.floor3);
                }
            });

            return rootView;

        }

        @Override
        public void onDestroy()
        {
            Log.d("ITPANGPANG","onDestroyView(3)");
            super.onDestroy();
        }
    }

    public static class Floor2Fragment extends Fragment {

        private ImageSwitcher sw2;
        private Button admin,secondfl;
        //Context context;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Log.d("ITPANGPANG","onCreateView(Floor2)");
            View rootView = inflater.inflate(R.layout.fragment_floor2, container, false);

            //context = context.getApplicationContext();

            sw2 = (ImageSwitcher) rootView.findViewById(R.id.secondimagesw);
            admin = (Button) rootView.findViewById(R.id.administration_office);
            secondfl = (Button) rootView.findViewById(R.id.secondfloor);


            sw2.setFactory(new ViewSwitcher.ViewFactory(){
                @Override
                public View makeView() {
                    ImageView imageView = new ImageView(getActivity().getApplicationContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return imageView;
                }
            });
            admin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw2.setImageResource(R.drawable.administration_office);
                }
            });
            secondfl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sw2.setImageResource(R.drawable.floor2);
                }
            });

            return rootView;

        }

        @Override
        public void onDestroy()
        {
            Log.d("ITPANGPANG","onDestroyView(2)");
            super.onDestroy();
        }

    }

    public static class Floor1Fragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Log.d("ITPANGPANG","onCreateView(Floor1)");
            View rootView = inflater.inflate(R.layout.fragment_floor1, container, false);

            return rootView;

        }

        @Override
        public void onDestroy()
        {
            Log.d("ITPANGPANG","onDestroyView(1)");
            super.onDestroy();
        }

    }

    @Override
    public void onStop()
    {
        Log.d("LOG","onDestoryFloorActivity");
        super.onStop();
    }

}
