// Wzorzec behawioralny - stan jest użyteczny, gdy obiekt musi zmieniać swoje zachowanie
// w zależności od swojego stanu, a liczba stanów jest znana i ograniczona.

// Interfejs reprezentujący stan
interface State {
    void handle();
}

// Konkretne stany
class StateA implements State {
    @Override
    public void handle() {
        System.out.println("Stan A");
    }
}

class StateB implements State {
    @Override
    public void handle() {
        System.out.println("Stan B");
    }
}

// Kontekst, który korzysta z różnych stanów
class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle();
    }
}

// Klasa testowa
public class StatePatternExample {
    public static void main(String[] args) {
        Context context = new Context();

        // Ustawiamy początkowy stan
        context.setState(new StateA());

        // Wywołujemy operację w zależności od aktualnego stanu
        context.request();

        // Zmieniamy stan
        context.setState(new StateB());

        // Wywołujemy operację w nowym stanie
        context.request();
    }
}
