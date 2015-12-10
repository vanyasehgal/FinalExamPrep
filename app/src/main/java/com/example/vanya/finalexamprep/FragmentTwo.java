package com.example.vanya.finalexamprep;


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
public class FragmentTwo extends Fragment {


    public FragmentTwo() {
        // Required empty public constructor
    }


    public static FragmentTwo newInstance(String paramOne) {

        Bundle args = new Bundle();
        args.putString("Param",paramOne);
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        String paramOne = getArguments().getString("Param");
        getActivity().setTitle(paramOne);
        //Toast.makeText(getActivity(),paramOne,Toast.LENGTH_SHORT);
        View view = inflater.inflate(R.layout.fragment_two,container,false);
        return view;
    }

    public interface ABCDEF{
        void abcdefClick(String string);
    }


}
