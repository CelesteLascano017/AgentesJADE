import jade.core.Agent;

public class Ag1 extends Agent{
    @Override
    protected void setup(){
            System.out.println("Hola, soy el agente: " + getLocalName());
    }
}