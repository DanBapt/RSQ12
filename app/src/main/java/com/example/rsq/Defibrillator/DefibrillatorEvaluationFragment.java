package com.example.rsq.Defibrillator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.rsq.QuizViewModel;
import com.example.rsq.R;

import java.util.List;

public class DefibrillatorEvaluationFragment extends Fragment {
    private QuizViewModel quizViewModel;
    private LinearLayout questionnaireLayout; // Layout pour ajouter les questionnaires des participants

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_defibrillator_evaluation, container, false);
        questionnaireLayout = root.findViewById(R.id.questionnaire_layout); // Assurez-vous d'ajouter ce LinearLayout dans fragment_defibrillator_evaluation.xml
        quizViewModel = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);

        List<String> participantNames = ((DefibrillatorActivity) getActivity()).getParticipantNames();

        // Générer les questionnaires pour chaque participant
        for (String participantName : participantNames) {
            View participantQuestionnaire = inflater.inflate(R.layout.defibrillator_participant_questionnaire, questionnaireLayout, false);

            TextView participantNameTextView = participantQuestionnaire.findViewById(R.id.participant_name);
            participantNameTextView.setText(participantName);

            questionnaireLayout.addView(participantQuestionnaire);
        }

        Button validateButton = root.findViewById(R.id.button_submit);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vous devez maintenant récupérer les réponses de chaque questionnaire de participant
                // Cela nécessite probablement des modifications dans votre modèle de données, car vous stockez actuellement les réponses dans QuizViewModel.
                // Une approche possible serait de parcourir chaque vue de participantQuestionnaire dans questionnaireLayout et de récupérer les réponses de chaque questionnaire.

                // Par exemple :
                for (int i = 0; i < questionnaireLayout.getChildCount(); i++) {
                    View participantQuestionnaire = questionnaireLayout.getChildAt(i);

                    RadioGroup radioGroup1 = participantQuestionnaire.findViewById(R.id.radioGroup1);
                    RadioGroup radioGroup2 = participantQuestionnaire.findViewById(R.id.radioGroup2);
                    RadioGroup radioGroup3 = participantQuestionnaire.findViewById(R.id.radioGroup3);
                    RadioGroup radioGroup4 = participantQuestionnaire.findViewById(R.id.radioGroup4);
                    RadioGroup radioGroup5 = participantQuestionnaire.findViewById(R.id.radioGroup5);

                    int selectedId1 = radioGroup1.getCheckedRadioButtonId();
                    int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                    int selectedId3 = radioGroup3.getCheckedRadioButtonId();
                    int selectedId4 = radioGroup4.getCheckedRadioButtonId();
                    int selectedId5 = radioGroup5.getCheckedRadioButtonId();

                    RadioButton radioButton1 = radioGroup1.findViewById(selectedId1);
                    RadioButton radioButton2 = radioGroup2.findViewById(selectedId2);
                    RadioButton radioButton3 = radioGroup3.findViewById(selectedId3);
                    RadioButton radioButton4 = radioGroup4.findViewById(selectedId4);
                    RadioButton radioButton5 = radioGroup5.findViewById(selectedId5);

                    // À ce stade, vous pouvez stocker les réponses de chaque participant séparément.
                    // Notez que vous devrez probablement modifier votre QuizViewModel pour gérer un ensemble de réponses pour chaque participant.
                }
            }
        });

        return root;
    }
}
