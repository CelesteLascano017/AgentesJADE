import jade.core.Agent;
import jade.core.AID;
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

                    String sender = msg.getSender().getLocalName();

                    System.out.println("Ag2 recibió de " + sender + ": " + msg.getContent());

                    // Solo reenvía si viene de Ag1
                    if (sender.equals("Agente1")) {

                        ACLMessage nuevo = new ACLMessage(ACLMessage.INFORM);

                        nuevo.addReceiver(new AID("Agente3", AID.ISLOCALNAME));
                        nuevo.addReceiver(new AID("Agente4", AID.ISLOCALNAME));
                        nuevo.addReceiver(new AID("Agente5", AID.ISLOCALNAME));

                        nuevo.setContent("Mensaje reenviado por Ag2");

                        send(nuevo);

                        System.out.println("Ag2 reenvió mensaje a Ag3, Ag4 y Ag5");

                    } else {
                        System.out.println("Ag2 recibió respuesta, no reenvía");
                    }

                } else {
                    block();
                }
            }
        });
    }
}
