/**
 * Blast Main contains main method to run the blast app.
 * 
 * @author Jeric Derama and Olivia Kullman with assistance from Dr. Cutter and TAs
 * @version Spring 2012
 *
 */
public class BLASTMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String dataFile = ValidatedInputReader.getResponse("Please enter DNA data file name", "testData.txt");
		int length = ValidatedInputReader.getInteger("Please enter a segment length", 1, 30, 12, "Running through the database");
		String queryFile = ValidatedInputReader.getResponse("Please enter query file name", "testQueries.txt");
		BLASTApp blast = new BLASTApp(dataFile, queryFile, length);
		blast.run();
				
	}

}
