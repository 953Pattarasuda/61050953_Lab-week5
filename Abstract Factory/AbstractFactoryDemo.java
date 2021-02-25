
interface HotDrink
{
    void consume();
}

class Tea implements HotDrink
{
    @Override
    public void consume()
    {
        System.out.println("This tea is nice but I'd prefer it with milk.");
    }
}

class Coffee implements HotDrink
{
    @Override
    public void consume()
    {
        System.out.println("This coffee is delicious");
    }
}

interface HotDrinkFactory
{
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory
{
    @Override
    public HotDrink prepare(int amount)
    {
        System.out.println("Put in tea bag, boil water, pour "+ amount + "ml, add lemon, enjoy!");
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory
{
    @Override
    public HotDrink prepare(int amount)
    {
        System.out.println("Grind some beans, boil water, pour "+ amount + " ml, add cream and sugar, enjoy!");
        return new Coffee();
    }
}

class HotDrinkMachine
{
    public enum AvailableDrink
    {
        COFFEE, TEA
    }

    public HotDrinkMachine() throws Exception
    {
    }

    public HotDrink makeDrink(AvailableDrink drink, int amount)
    {
        switch (drink)
        {

            case COFFEE:
                return new CoffeeFactory().prepare(amount);
            case TEA:
                return new TeaFactory().prepare(amount);
        }

        return null;
    }
}

class AbstractFactoryDemo
{
    public static void main(String[] args) throws Exception
    {
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink tea = machine.makeDrink(HotDrinkMachine.AvailableDrink.TEA, 200);
        tea.consume();
    }

}