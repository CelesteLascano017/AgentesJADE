import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag4 extends Agent {

    @Override
    protected void setup() {
        System.out.println("Soy Ag4: " + getLocalName());

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();

                if (msg != null) {
                    System.out.println("Ag4 received: " + msg.getContent());
                     //Respuesta
                    ACLMessage reply = msg.createReply();
                    reply.setContent("Respuesta desde Ag4");

                    //Enviar respuesta
                    send(reply);
                    System.out.println("Ag4 respondió a Ag2");
                } else {
                    block();
                }
            }
        });
    }
}