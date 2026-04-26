import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.ContainerController;
import jade.wrapper.AgentController;

public class contenedor {
    public static void main(String[] args) {
        try {
            Runtime rt = Runtime.instance();

            Profile profile = new ProfileImpl();
            profile.setParameter(Profile.MAIN_HOST, "localhost");

            ContainerController container = rt.createMainContainer(profile);

            System.out.println("Contenedor iniciado");
            
            AgentController ag3 = container.createNewAgent("Agente3", "Ag3", null);
            ag3.start();

            AgentController ag4 = container.createNewAgent("Agente4", "Ag4", null);
            ag4.start();

            AgentController ag5 = container.createNewAgent("Agente5", "Ag5", null);
            ag5.start();

            AgentController ag2 = container.createNewAgent("Agente2", "Ag2", null);
            ag2.start();

            AgentController ag1 = container.createNewAgent("Agente1", "Ag1", null);
            ag1.start();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}