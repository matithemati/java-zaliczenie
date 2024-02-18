// Wzorzec strukturalny proxy pozwala na kontrolowanie dostępu do innych obiektów
// poprzez dostarczenie alternatywnego obiektu reprezentującego ten sam interfejs.
// Proxy służy do kontroli dostępu, zastępowania obiektów oraz implementowania dodatkowej
// logiki wokół dostępu do rzeczywistego obiektu.

// Interfejs reprezentujący zdalny obiekt, który będzie używany przez Proxy
interface RemoteObject {
    void operation();
}

class RealRemoteObject implements RemoteObject {
    @Override
    public void operation() {
        System.out.println("RealRemoteObject: Performing operation...");
    }
}

// Proxy, który kontroluje dostęp do zdalnego obiektu i dodaje dodatkową funkcjonalność
class RemoteObjectProxy implements RemoteObject {
    private RealRemoteObject realRemoteObject;

    public RemoteObjectProxy() {
        // Proxy może tworzyć rzeczywisty obiekt tylko wtedy, gdy jest to potrzebne
    }

    @Override
    public void operation() {
        // Tworzenie rzeczywistego obiektu tylko wtedy, gdy jest to potrzebne
        if (realRemoteObject == null) {
            realRemoteObject = new RealRemoteObject();
        }

        // Przykładowa dodatkowa funkcjonalność dodana przez proxy
        System.out.println("RemoteObjectProxy: Pre-operation checks...");

        // Delegowanie rzeczywistej operacji do obiektu RealRemoteObject
        realRemoteObject.operation();

        // Przykładowa dodatkowa funkcjonalność dodana przez proxy
        System.out.println("RemoteObjectProxy: Post-operation tasks...");
    }
}

// Klasa testowa
public class Proxy {
    public static void main(String[] args) {
        // Używamy proxy do kontrolowania dostępu do zdalnego obiektu
        RemoteObject proxy = new RemoteObjectProxy();

        // Wywołujemy operację przez proxy
        proxy.operation();
    }
}
