package com.example.rsq.Defibrillator;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.rsq.QuizViewModel;
import com.example.rsq.R;

public class DefibrillatorResultsFragment extends Fragment {
    private QuizViewModel quizViewModel;

    public DefibrillatorResultsFragment() {
        // Required empty public constructor
    }

    public static DefibrillatorResultsFragment newInstance() {
        return new DefibrillatorResultsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_defibrillator_results, container, false);

        quizViewModel = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);

        // Supposez que vous avez un TextView pour chaque réponse
        TextView answer1TextView = root.findViewById(R.id.answer1);
        TextView answer2TextView = root.findViewById(R.id.answer2);
        TextView answer3TextView = root.findViewById(R.id.answer3);
        TextView answer4TextView = root.findViewById(R.id.answer4);
        TextView answer5TextView = root.findViewById(R.id.answer5);

        quizViewModel.getAnswer1().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String answer) {
                // Mettez à jour votre interface utilisateur avec la réponse
                answer1TextView.setText("Mise en place rapide du défibrillateur : " + answer);
            }
        });

        quizViewModel.getAnswer2().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String answer) {
                // Mettez à jour votre interface utilisateur avec la réponse
                answer2TextView.setText("Insufflation efficace : " + answer);
            }
        });

        quizViewModel.getAnswer3().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String answer) {
                // Mettez à jour votre interface utilisateur avec la réponse
                answer3TextView.setText("Sécurité : " + answer);
            }
        });

        quizViewModel.getAnswer4().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String answer) {
                // Mettez à jour votre interface utilisateur avec la réponse
                answer4TextView.setText("Bilan en cours de RCP : " + answer);
            }
        });

        quizViewModel.getAnswer5().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String answer) {
                // Mettez à jour votre interface utilisateur avec la réponse
                answer5TextView.setText("Bilan effectué en conformité : " + answer);
            }
        });

        return root;
    }
}
