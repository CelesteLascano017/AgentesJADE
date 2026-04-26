import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag2 extends Agent {

    @Override
    protected void setup() {
        System.out.println("Soy Ag2: " + getLocalName());

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();

                if (msg != null) {
                    System.out.println("Ag2 recibió: " + msg.getContent());
                } else {
                    block();
                }
            }
        });
    }
}
