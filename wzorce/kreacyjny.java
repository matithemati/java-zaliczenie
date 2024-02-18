// Wzorzec typu Fabryka abstrakcyjna — wykorzystuje super fabrykę do tworzenia fabryk, których następnie używamy do tworzenia obiektów.
// Wzorzec ten pozwala na tworzenie obiektów zależnych od siebie, ale niezależnych od sposobu ich tworzenia.
// Wzorzec ten wykorytstałem podczas zdania w Springu.

interface CarFactory {
    AbstractCarA createCarA();
    AbstractCarB createCarB();
}

class Dealer1 implements CarFactory {
    @Override
    public AbstractCarA createCarA() {
        return new CarA1();
    }

    @Override
    public AbstractCarB createCarB() {
        return new CarB1();
    }
}

class Dealer2 implements CarFactory {
    @Override
    public AbstractCarA createCarA() {
        return new CarA2();
    }

    @Override
    public AbstractCarB createCarB() {
        return new CarB2();
    }
}

interface AbstractCarA {
    void operationA();
}

class CarA1 implements AbstractCarA {
    @Override
    public void operationA() {
        System.out.println("Operation A for Product A1");
    }
}

class CarA2 implements AbstractCarA {
    @Override
    public void operationA() {
        System.out.println("Operation A for Product A2");
    }
}

interface AbstractCarB {
    void operationB();
}

class CarB1 implements AbstractCarB {
    @Override
    public void operationB() {
        System.out.println("Operation B for Product B1");
    }
}

class CarB2 implements AbstractCarB {
    @Override
    public void operationB() {
        System.out.println("Operation B for Product B2");
    }
}
