package be.ehb.demo_lists_jokerapp.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class JokeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Joke>> jokes;

    public MutableLiveData<ArrayList<Joke>> getJokes() {
        if(jokes == null){
            jokes = new MutableLiveData<>();
            loadJokes();
        }
        return jokes;
    }
//in het echt komt dit uit een backend ofdata base
    private void loadJokes() {
    ArrayList<Joke> newJokes = new ArrayList<>();

    newJokes.add(new Joke("Het is blauw en weegt niet veel", "Lichtblauw"));
    newJokes.add(new Joke("Het is zwart en als het uit een boom valt is uw kachel kapot", "uw kachel"));
    newJokes.add(new Joke("Het is grijs en als het in uw oog vliegt zijt ge dood", "een boeing"));
    newJokes.add(new Joke("Wat zegt een zandkorrel in de woestijn", "Help ik ben omsingeld"));
    newJokes.add(new Joke("Hoeveel inginieurs heb je nodig om een lamp op te hangen", "één"));
    newJokes.add(new Joke("c", "d"));
    newJokes.add(new Joke("d", "e"));
    newJokes.add(new Joke("e", "f"));

    jokes.postValue(newJokes);
    }
}
