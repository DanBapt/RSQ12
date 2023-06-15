package com.example.rsq.Pump;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.rsq.QuizViewModel;
import com.example.rsq.R;

import java.util.ArrayList;
import java.util.List;

public class PumpParametresFragment extends Fragment {

    private LinearLayout participantLayout;
    private EditText numParticipantsEditText;
    private Button submitButton;
    private Button submitNamesButton;
    private QuizViewModel quizViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pump_parametres, container, false);

        quizViewModel = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);

        participantLayout = root.findViewById(R.id.participant_layout);
        numParticipantsEditText = root.findViewById(R.id.num_participants);
        submitButton = root.findViewById(R.id.submit_button_participant);

        submitNamesButton = new Button(getContext());
        submitNamesButton.setText("Valider les noms");
        submitNamesButton.setVisibility(View.GONE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numParticipants;
                try {
                    numParticipants = Integer.parseInt(numParticipantsEditText.getText().toString());
                    Log.d("NumParticipants", "Number of participants: " + numParticipants);
                } catch (NumberFormatException e) {
                    numParticipants = 0;
                }
                updateParticipantFields(numParticipants);
                submitNamesButton.setVisibility(View.VISIBLE);

                submitNamesButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int numParticipants = participantLayout.getChildCount() - 1;
                        List<String> participantNames = new ArrayList<>();
                        for (int i = 0; i < numParticipants; i++) {
                            EditText participantNameEditText = (EditText) participantLayout.getChildAt(i);
                            participantNames.add(participantNameEditText.getText().toString());
                        }

                        quizViewModel.setParticipantNames(participantNames);
                    }
                });
            }
        });

        participantLayout.addView(submitNamesButton);

        return root;
    }

    private void updateParticipantFields(int numParticipants) {
        participantLayout.removeAllViews();
        for (int i = 0; i < numParticipants; i++) {
            EditText participantNameEditText = new EditText(getContext());
            participantNameEditText.setHint("Participant " + (i + 1));
            participantLayout.addView(participantNameEditText);
        }
        participantLayout.addView(submitNamesButton);
    }
}
