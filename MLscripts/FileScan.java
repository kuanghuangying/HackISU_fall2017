import java.io.*;

public class FileScan {

    private String[] full_file; 

    public String[] getFSFile()
    {
	return full_file;
    }

    public FileScan(String f) { 

        // The name of the file to open.
        String fileName = f;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

	    full_file = new String[500];
	   
	    int i = 0;
            while((line = bufferedReader.readLine()) != null) {
		full_file[i] = line;
		i++;
            } 		
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
}
