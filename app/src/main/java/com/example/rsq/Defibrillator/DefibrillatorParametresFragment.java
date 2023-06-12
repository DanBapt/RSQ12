package com.example.rsq.Defibrillator;

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

import com.example.rsq.R;

public class DefibrillatorParametresFragment extends Fragment {

    private LinearLayout participantLayout;
    private EditText numParticipantsEditText;
    private Button submitButton;
    private Button submitNamesButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_defibrillator_parametres, container, false);

        participantLayout = root.findViewById(R.id.participant_layout);
        numParticipantsEditText = root.findViewById(R.id.num_participants);
        submitButton = root.findViewById(R.id.submit_button_participant);
        submitNamesButton = new Button(getContext());
        submitNamesButton.setText("Valider les noms");
        submitNamesButton.setVisibility(View.GONE); // le bouton sera invisible par défaut

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
                submitNamesButton.setVisibility(View.VISIBLE); // le bouton devient visible après avoir cliqué sur "Submit"
            }
        });

        participantLayout.addView(submitNamesButton);

        submitNamesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logique pour traiter les noms des participants et passer à l'onglet suivant
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
        participantLayout.addView(submitNamesButton);  // Assurez-vous que le bouton "Submit Names" est toujours en bas
    }
}
