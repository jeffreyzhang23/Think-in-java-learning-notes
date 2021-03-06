package net.mindview.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExecute {
	public static void command(String command) {
		boolean err = false;
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader results = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			String s ;
			while((s = results.readLine()) != null)
				System.out.println(s);
			BufferedReader errors = new BufferedReader(
					new InputStreamReader(process.getErrorStream()));
			// report errors and return nonzero value
			// to calling process if there are problems.
			while((s = errors.readLine()) != null) {
				System.err.println(s);
				err = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// compensate for windows2000, which throws an 
			// exception for the default command line;
			if(!command.startsWith("CMD /C"))
				command("CMD /C" + command);
			else 
				throw new RuntimeException(e);
		}
		if(err) {
			throw new OSExecuteException("Errors executing " + command);
		}
	}
}
