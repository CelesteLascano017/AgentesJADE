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
                    // 1. Mostrar mensaje recibido
                    System.out.println("Ag2 recibió: " + msg.getContent());

                    // 2. Crear nuevo mensaje
                    ACLMessage nuevo = new ACLMessage(ACLMessage.INFORM);

                    // 3. Agregar receptores
                    nuevo.addReceiver(new AID("Agente3", AID.ISLOCALNAME));
                    nuevo.addReceiver(new AID("Agente4", AID.ISLOCALNAME));
                    nuevo.addReceiver(new AID("Agente5", AID.ISLOCALNAME));

                    // 4. Contenido del mensaje
                    nuevo.setContent("Mensaje reenviado por Ag2");

                    // 5. Enviar mensaje
                    send(nuevo);

                    System.out.println("Ag2 reenvió mensaje a Ag3, Ag4 y Ag5");

                } else {
                    block();
                }
            }
        });
    }
}
