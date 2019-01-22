package lambdas.basics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomFunctionalInterface {

	public static void main(String[] args) {
		String processFile = processFile();
		System.out.println(processFile);

		// the behaviour of the method is changed, and now different behaviour
		// can be passed by the client at runtime
		String processFile2 = processFile(br -> {
			StringBuilder builder = new StringBuilder();
			while (br.read() != -1) {
				builder.append(br.readLine() + "\n");
			}
			return builder.toString();
		});

		System.out.println(processFile2);

		String processFile3 = processFile(br -> {

			br.skip(2);
			return br.readLine();

		});

		System.out.println(processFile3);
	}

	/**
	 * This method only reads the first line of the file and hence is limited in
	 * what it can do. One approach would be to modify the existing method
	 * 
	 * @return
	 */
	static String processFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/temp/Instructions.txt"));
			return reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * modified method which makes use of Functional Interfaces
	 * 
	 * @param processor
	 * @return
	 */
	static String processFile(BufferedReaderProcessor processor) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/temp/Instructions.txt"));
			return processor.process(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@FunctionalInterface
	public interface BufferedReaderProcessor {
		String process(BufferedReader b) throws IOException;
	}

}
