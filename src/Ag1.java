import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag1 extends Agent {

    @Override
    protected void setup() {
        System.out.println("Soy Ag1: " + getLocalName());

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {

                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(new AID("Agente2", AID.ISLOCALNAME));
                msg.setContent("Hola desde Ag1");

                send(msg);

                System.out.println("Mensaje enviado a Ag2");
            }
        });
    }
}