package be.ehb.demo_lists_jokerapp.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import be.ehb.demo_lists_jokerapp.R;
import be.ehb.demo_lists_jokerapp.model.Joke;
import be.ehb.demo_lists_jokerapp.model.JokeViewModel;
import be.ehb.demo_lists_jokerapp.util.JokeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokeListFragment extends Fragment {

    private SearchView.OnQueryTextListener searchListener = new SearchView.OnQueryTextListener() {
       //pas filteren na zoeken
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }
//per letter filteren automatisch
        @Override
        public boolean onQueryTextChange(String newText) {
            adapter.getFilter().filter(newText);
            return false;
        }
    };
    private JokeAdapter adapter;

    public JokeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View rootView = inflater.inflate(R.layout.fragment_joke_list, container,false);

       //noodzakelijk omp search in te voegen
       setHasOptionsMenu(true);

       //verwijzing naar UI
       RecyclerView rvJokes = rootView.findViewById(R.id.rv_jokes);
       //opvuling recycler, kan als lijst of grid
        rvJokes.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        //adapter, nodig om data om te zetten in iets visueel(in dit geval card)
        adapter = new JokeAdapter();
        rvJokes.setAdapter(adapter);

        //verwijzing naar viewModel, waar staat alle data
        JokeViewModel model = new ViewModelProvider(this).get(JokeViewModel.class);
        model.getJokes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Joke>>() {
            @Override
            public void onChanged(ArrayList<Joke> jokes) {
                adapter.addItems(jokes);
            }
        });

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.search_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.mi_search).getActionView();
        searchView.setOnQueryTextListener(searchListener);

        super.onCreateOptionsMenu(menu, inflater);
    }
}
