package com.example.rsq;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {
    // Utilisez LiveData pour chaque question
    private MutableLiveData<String> answer1 = new MutableLiveData<>();
    private MutableLiveData<String> answer2 = new MutableLiveData<>();
    private MutableLiveData<String> answer3 = new MutableLiveData<>();
    private MutableLiveData<String> answer4 = new MutableLiveData<>();
    private MutableLiveData<String> answer5 = new MutableLiveData<>();

    // Ajoutez des méthodes pour définir les réponses
    public void setAnswer1(String answer) {
        answer1.setValue(answer);
    }

    public void setAnswer2(String answer) {
        answer2.setValue(answer);
    }

    public void setAnswer3(String answer) {
        answer3.setValue(answer);
    }

    public void setAnswer4(String answer) {
        answer4.setValue(answer);
    }

    public void setAnswer5(String answer) {
        answer5.setValue(answer);
    }

    // Ajoutez des méthodes pour obtenir les réponses
    public LiveData<String> getAnswer1() {
        return answer1;
    }

    public LiveData<String> getAnswer2() {
        return answer2;
    }

    public LiveData<String> getAnswer3() {
        return answer3;
    }

    public LiveData<String> getAnswer4() {
        return answer4;
    }

    public LiveData<String> getAnswer5() {
        return answer5;
    }
}
