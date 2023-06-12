package com.example.rsq.Pump;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.rsq.R;

public class PumpParametresFragment extends Fragment {

    private LinearLayout participantLayout;
    private EditText numParticipantsEditText;
    private Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pump_parametres, container, false);

        participantLayout = root.findViewById(R.id.participant_layout);
        numParticipantsEditText = root.findViewById(R.id.num_participants);
        submitButton = root.findViewById(R.id.submit_button_participant);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numParticipants;
                try {
                    numParticipants = Integer.parseInt(numParticipantsEditText.getText().toString());
                } catch (NumberFormatException e) {
                    numParticipants = 0;
                }
                updateParticipantFields(numParticipants);
            }
        });

        return root;
    }

    private void updateParticipantFields(int numParticipants) {
        participantLayout.removeAllViews();
        for (int i = 0; i < numParticipants; i++) {
            EditText participantNameEditText = new EditText(getContext());
            participantNameEditText.setHint("Participant " + (i + 1));
            participantLayout.addView(participantNameEditText);
        }
    }
}
