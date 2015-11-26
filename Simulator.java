public class Simulator{

    public static void main(String[] args) throws InterruptedException{
	Simulation s;

	if (args.length == 5) {
	    s = new Simulation(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
	} else {
	    System.out.println("Simulator [number of registers] [threshold for new register] [intensity] [max groceries] [steps]");
	    return;
	}
	int steps = Integer.parseInt(args[4]);
        for(int i = 0; i < steps; i++){
            System.out.print("\033[2J\033[;H");
            s.step();
            System.out.println(s);
            Thread.sleep(100);
        }
        System.out.println("");
        System.out.println("Simulation finished!");
    }
}
