package edu.uwyo.mkelly21.helloworld;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.os.Build.VERSION;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link myFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link myFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class myFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button entr;
    Fragment myFrag;
    EditText input;
    String name;
    String TAG = "Fragment";
    private OnFragmentInteractionListener mListener;
    public myFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment myFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static myFragment newInstance(String param1, String param2) {
        myFragment fragment = new myFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    //not sure if this should be changed but I got it working with it being left alone...
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_my, container, false);


        input = (EditText) myView.findViewById(R.id.inText);


        entr = (Button) myView.findViewById(R.id.Enter);
        entr.setOnClickListener(new View.OnClickListener(){
            //button listener
            public void onClick(View v)
            {
                name = input.getText().toString();
                Toast.makeText(getActivity(), "Hello " + name, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "button was pressed");
            }
        });

        return myView;
    }

    public void displayName(String inName){
        name = inName;
        //button was pressed
        Toast.makeText(getActivity(), "Hello " + name, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "button was pressed");
    }

    //I put this code that I found on StackOverflow here because I was having issues without it....
    // I believe the API I was using was 23 and was trying an outdated onAttach method.
    @Override public void onAttach(Context context) {
        //This method avoid to call super.onAttach(context) if I'm not using api 23 or more
        if (Build.VERSION.SDK_INT >= 23) {
        super.onAttach(context);
        onAttachToContext(context);
        }
        Log.d(TAG, "in onAttach for api >= 23");
    }

    /*
     * Deprecated on API 23
     * Use onAttachToContext instead
     */
    @SuppressWarnings("deprecation")
    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < 23) {
            onAttachToContext(activity);
        }
        Log.d(TAG, "in onAttach for api < 23");
    }

    /*
     * This method will be called from one of the two previous method
     */
    protected void onAttachToContext(Context context) {}

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        Log.d(TAG, "detach");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String data);
    }
}
