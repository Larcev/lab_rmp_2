package com.example.lab_rmp_2;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {
    private Callbacks mCallbacks;

    public interface Callbacks {
        void onFirstButtonClicked();
        void onSecondButtonClicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Callbacks) {
            mCallbacks = (Callbacks) context;
        } else {
            throw new RuntimeException(context.toString() + " должен реализовывать MainFragment.Callbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button btnFirst = view.findViewById(R.id.btn_first);
        Button btnSecond = view.findViewById(R.id.btn_second);

        btnFirst.setOnClickListener(v -> {
            if (mCallbacks != null) {
                mCallbacks.onFirstButtonClicked();
            }
        });
        btnSecond.setOnClickListener(v -> {
            if (mCallbacks != null) {
                mCallbacks.onSecondButtonClicked();
            }
        });
        return view;
    }
}
