package com.challenge.static_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    private Button sendMessageButton;

    interface OnButtonClickedListener {
        void onTopFragmentButtonClicked(String message);
    }

    OnButtonClickedListener listener;


    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hellow_world, container, false);
        sendMessageButton = view.findViewById(R.id.send_message_button);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onTopFragmentButtonClicked("I have been clicked!");
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Make sure the container activity implements the callback interface
        MainActivity activity = (MainActivity) context;
        try {
            if (context instanceof OnButtonClickedListener) {
                listener = (OnButtonClickedListener) context;
            }
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString() + " must implement OnButtonClickedListener");
        }
    }

    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();
    }
}
