package com.example.vanya.finalexamprep;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {


    public static FragmentOne newInstance(String paramOne) {

        Bundle args = new Bundle();
        args.putString("Param",paramOne);
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }


    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        TextView textView = new TextView(getActivity());
//        textView.setText(R.string.hello_blank_fragment);
        String param1 = getArguments().getString("Param");
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        getActivity().setTitle(param1);
        //Toast.makeText(getActivity(),param1,Toast.LENGTH_SHORT);
        return view;
    }

    public interface ABC{
        void abcClick(String string);
    }

    ABC obj;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        obj = (ABC) activity;
        obj.abcClick("Vanya Sehgal");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        obj = null;
    }
}
