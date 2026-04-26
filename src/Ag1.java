import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Ag1 extends Agent{
    @Override
    protected void setup(){
        System.out.println("Soy el agente: " + getLocalName());

        addBehaviour(new OneShotBehaviour() {

            @Override 
            public void action(){
                System.out.println("Estoy ejecutando mi comportamiento");
            }
            
        });
    }
}