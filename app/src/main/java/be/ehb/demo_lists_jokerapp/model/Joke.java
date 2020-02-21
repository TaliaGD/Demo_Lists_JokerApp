package be.ehb.demo_lists_jokerapp.model;

import java.io.Serializable;
//serialazable nodig om data kunnen doorsturen naar tweede scherm
public class Joke implements Serializable {

    private String setup;
    private String punchline;
    //constructor (snel Alt+insert)


    public Joke(String setup, String punchline) {
        this.setup = setup;
        this.punchline = punchline;
    }

    //getters en setters
    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

}
