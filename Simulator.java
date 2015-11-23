public class Simulator{

    public static void main(String[] args) throws InterruptedException{
        int steps = 100;
	Simulation s;
	
	if (args.length == 1) {
	    s = new Simulation(Integer.parseInt(args[0]), 10, 100, 20);
	} else if (args.length == 2) {
	    s = new Simulation(Integer.parseInt(args[0]), Integer.parseInt(args[1]), 100, 20);
	} else if (args.length == 3) {
	    s = new Simulation(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), 20);
	} else if (args.length == 4) {
	    s = new Simulation(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
	} else {
	    s = new Simulation(10, 5, 100, 10);
	}
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
