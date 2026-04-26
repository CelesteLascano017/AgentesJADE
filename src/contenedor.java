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

            AgentController ag1 = container.createNewAgent("Agente1", "Ag1", null);
            ag1.start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 