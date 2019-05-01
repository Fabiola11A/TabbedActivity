package com.example.tabbedactivity.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.example.tabbedactivity.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(// este método es el que me permite asociar un fragment con su correspondiente vista
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView= null;
        switch(getArguments().getInt(ARG_SECTION_NUMBER)){//MÉTODO que me diria en que seccion estoy/dependiendo del
            //numero de TABS se agregan los cases 
            case 1:
                rootView = inflater.inflate(R.layout.fragment_main, container, false);
                break;
            case 2:
                //AQUI SE CARGARIA OTRA PAGINA
                rootView = inflater.inflate(R.layout.fragment_fragment_tweets, container, false);
                break;
        }

        return rootView;
    }
}