package com.example.rsq.Pump;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.rsq.QuizViewModel;
import com.example.rsq.R;

import java.util.List;

public class PumpResultsFragment extends Fragment {

    private QuizViewModel quizViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pump_results, container, false);

        final LinearLayout resultLayout = root.findViewById(R.id.result_layout); // supposons que vous avez un LinearLayout pour afficher les résultats

        quizViewModel = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);

        quizViewModel.getParticipantResults().observe(getViewLifecycleOwner(), new Observer<List<QuizViewModel.ParticipantResults>>() {
            @Override
            public void onChanged(List<QuizViewModel.ParticipantResults> participantResults) {
                resultLayout.removeAllViews(); // retirez d'abord toutes les vues existantes

                for (QuizViewModel.ParticipantResults results : participantResults) {
                    View participantResultView = inflater.inflate(R.layout.pump_participant_results, resultLayout, false);

                    TextView participantNameTextView = participantResultView.findViewById(R.id.participant_name);
                    TextView answer1TextView = participantResultView.findViewById(R.id.answer1);
                    TextView answer2TextView = participantResultView.findViewById(R.id.answer2);
                    TextView answer3TextView = participantResultView.findViewById(R.id.answer3);

                    participantNameTextView.setText(results.participantName);
                    answer1TextView.setText("Gestes de premier secours immédiats et efficaces : " + results.answer1);
                    answer2TextView.setText("Pose d'un garrot efficace : " + results.answer2);
                    answer3TextView.setText("Bilan effectué en conformité : " + results.answer3);

                    resultLayout.addView(participantResultView); // ajoutez la vue au layout
                }
            }
        });

        return root;
    }
}
