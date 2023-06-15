package com.example.rsq;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class QuizViewModel extends ViewModel {

    // Utilisez LiveData pour chaque question
    private MutableLiveData<String> answer1 = new MutableLiveData<>();
    private MutableLiveData<String> answer2 = new MutableLiveData<>();
    private MutableLiveData<String> answer3 = new MutableLiveData<>();

    // Nouvelle classe pour représenter les résultats d'un participant
    public static class ParticipantResults {
        public String participantName;
        public String answer1;
        public String answer2;
        public String answer3;

        public ParticipantResults(String participantName, String answer1, String answer2, String answer3) {
            this.participantName = participantName;
            this.answer1 = answer1;
            this.answer2 = answer2;
            this.answer3 = answer3;
        }
    }

    // Nouvelle propriété pour stocker les résultats des participants
    private MutableLiveData<List<ParticipantResults>> participantResults = new MutableLiveData<>(new ArrayList<>());

    // Propriété pour stocker les noms des participants
    private MutableLiveData<List<String>> participantNames = new MutableLiveData<>();

    public void setAnswer1(String answer) {
        answer1.setValue(answer);
    }

    public void setAnswer2(String answer) {
        answer2.setValue(answer);
    }

    public void setAnswer3(String answer) {
        answer3.setValue(answer);
    }

    public LiveData<String> getAnswer1() {
        return answer1;
    }

    public LiveData<String> getAnswer2() {
        return answer2;
    }

    public LiveData<String> getAnswer3() {
        return answer3;
    }

    // Nouvelles méthodes pour obtenir et définir les résultats des participants
    public LiveData<List<ParticipantResults>> getParticipantResults() {
        return participantResults;
    }

    public void setParticipantResults(List<ParticipantResults> results) {
        this.participantResults.setValue(results);
    }

    // Méthodes pour définir et obtenir les noms des participants
    public void setParticipantNames(List<String> names) {
        this.participantNames.setValue(names);
    }

    public LiveData<List<String>> getParticipantNames() {
        return this.participantNames;
    }
}
