package be.ehb.demo_lists_jokerapp.model;

public class Joke {

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
