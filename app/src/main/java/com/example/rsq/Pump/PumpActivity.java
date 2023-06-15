package com.example.rsq.Pump;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

import com.example.rsq.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PumpActivity extends AppCompatActivity {

    private List<String> participantNames = new ArrayList<>();
    public void updateParticipantNames(List<String> names) {
        this.participantNames = names;
    }
    public void navigateToResultsFragment() {
        // Code to switch to the ResultsFragment
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pump);

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        PagerAdapter pagerAdapter = new PagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        // Use TabLayoutMediator to link TabLayout and ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Paramètres");
                            break;
                        case 1:
                            tab.setText("Évaluation");
                            break;
                        case 2:
                            tab.setText("Résultats");
                            break;
                    }
                }).attach();
    }

    // Use FragmentStateAdapter instead of FragmentPagerAdapter
    public class PagerAdapter extends FragmentStateAdapter {

        public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Log.d("PagerAdapter", "Creating fragment for position: " + position); // Added
            switch (position) {
                case 0:
                    // Remplacer avec votre nouveau fragment
                    return new PumpParametresFragment();
                case 1:
                    Log.d("PagerAdapter", "Creating PumpEvaluationFragment"); // Added
                    return new PumpEvaluationFragment();
                case 2:
                    Log.d("PagerAdapter", "Creating PumpResultsFragment"); // Added
                    return new PumpResultsFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return 3;  // Nous avons maintenant trois onglets
        }
    }
    public List<String> getParticipantNames() {
        return participantNames;
    }
}
