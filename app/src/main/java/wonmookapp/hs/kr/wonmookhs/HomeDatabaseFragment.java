package wonmookapp.hs.kr.wonmookhs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HomeDatabaseFragment extends Fragment implements
        GoogleApiClient.OnConnectionFailedListener{

    public static class RoomViewHolder extends RecyclerView.ViewHolder{
        public TextView roomName;
        public TextView roomDate;
        public TextView roomDescription;

        public RoomViewHolder(View v){
            super(v);
            roomName = (TextView)itemView.findViewById(R.id.name);
            roomDate = (TextView)itemView.findViewById(R.id.date);
            roomDescription = (TextView)itemView.findViewById(R.id.description);
        }
    }
    public static final String HOMEDB = "homedb";
    //private String mUsername;
    //private String mPhotoUrl;
    //private SharedPreferences mSharedPreferences;
    //private GoogleApiClient mGoogleApiClient;
    //public static final String ANONYMOUS = "anonymous";
    private static final String TAG = "HomeDatabaseFragment";
    //Recycler View Setup
    private RecyclerView mRoomRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    // Firebase instance variables
    //private FirebaseAuth mFirebaseAuth;
    //private FirebaseUser mFirebaseUser;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<HomeCardViewRoom, RoomViewHolder> mFirebaseAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homedatabase_recyclerview, container, false);
        mRoomRecyclerView = (RecyclerView) rootView.findViewById(R.id.roomRecyclerView);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setStackFromEnd(true);

        // Initialize Firebase Auth
        /*
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        } else {
            mUsername = mFirebaseUser.getDisplayName();
            if (mFirebaseUser.getPhotoUrl() != null) {
                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            }
        }

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API)
                .build();
        */
        //Database Initialization
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<HomeCardViewRoom, RoomViewHolder>(
                HomeCardViewRoom.class,
                R.layout.homedatabase_cardview,
                RoomViewHolder.class,
                mFirebaseDatabaseReference.child(HOMEDB)) {
            @Override
            protected void populateViewHolder(RoomViewHolder viewHolder, HomeCardViewRoom model, int position) {
                viewHolder.roomName.setText(model.gethomeName());
                viewHolder.roomDate.setText(model.gethomeDate());
                viewHolder.roomDescription.setText(model.gethomeDescription());
            }
        };

        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(){
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount){
                super.onItemRangeInserted(positionStart, itemCount);
                int roomCount = mFirebaseAdapter.getItemCount();
                int lastVisiblePosition = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisiblePosition == -1 || (positionStart >= (roomCount -1) && lastVisiblePosition == (positionStart -1))){
                    mRoomRecyclerView.scrollToPosition(positionStart);
                }
            }
        });
        mRoomRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRoomRecyclerView.setAdapter(mFirebaseAdapter);




        return rootView;
    }




    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in.
        // TODO: Add code to check if user is signed in.
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
        Toast.makeText(getActivity(), "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }
}
