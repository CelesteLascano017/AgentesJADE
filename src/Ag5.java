import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag5 extends Agent {

    @Override
    protected void setup() {
        System.out.println("Soy Ag5: " + getLocalName());

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();

                if (msg != null) {
                    System.out.println("Ag5 received: " + msg.getContent());
                     //Respuesta
                    ACLMessage reply = msg.createReply();
                    reply.setContent("Respuesta desde Ag5");

                    //Enviar respuesta
                    send(reply);
                    System.out.println("Ag5 respondió a Ag2");
                } else {
                    block();
                }
            }
        });
    }
}