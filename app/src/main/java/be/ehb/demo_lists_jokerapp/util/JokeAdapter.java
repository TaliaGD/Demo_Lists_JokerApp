package be.ehb.demo_lists_jokerapp.util;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import be.ehb.demo_lists_jokerapp.R;
import be.ehb.demo_lists_jokerapp.model.Joke;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> implements Filterable {


    class JokeViewHolder extends RecyclerView.ViewHolder{

        final TextView tvSetup;
        final Button btnClou;

        //btn listener
     final View.OnClickListener detailListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //welke card(rij)?
                int position = getAdapterPosition();

                //data in de bundel steken om door te geven
                Bundle data = new Bundle();
                data.putSerializable("passedJoke", items.get(position));
                //navigatie starten
                Navigation.findNavController(view).navigate(R.id.jokeList_to_details,data);
            }
        };

        //default constructor(zonder parameters)
        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSetup = itemView.findViewById(R.id.tv_setup);
            btnClou = itemView.findViewById(R.id.btn_clou);
            btnClou.setOnClickListener(detailListener);
        }
    }



    private ArrayList<Joke> items;
    private ArrayList<Joke> OGItems;

    public JokeAdapter() {
        items = new ArrayList<>();
        OGItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context conext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(conext);
        View card = layoutInflater.inflate(R.layout.joker_card, parent, false);


        return new JokeViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        Joke currentJoke = items.get(position);

        holder.tvSetup.setText(currentJoke.getSetup());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems(ArrayList<Joke> jokes){
        items.clear();
        items.addAll(jokes);
        OGItems.clear();
        OGItems.addAll(jokes);
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String input = constraint.toString();
                if(input.isEmpty()) {
                    items = OGItems;
                }else{
                    items = OGItems;
                    ArrayList<Joke> tempList = new ArrayList<>();
                    for (Joke element : items){
                        if (element.getSetup().contains(input)) {
                            tempList.add(element);
                        }
                    }
                        items = tempList;
                }

                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
            }
        };
    }
}
