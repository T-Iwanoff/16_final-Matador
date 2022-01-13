import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Language
{
	private static HashMap<String, String> translations = new HashMap<>();

	/** Changes the used language */
	public static void setLanguage(String language)
	{
		try
		{
			// Selects the chosen language file from the 'languages' folder
			File file = Paths.get("languages/" + language).toFile();
			Scanner reader = new Scanner(file);
			// Turns language file into a HashMap for easy call
			while (reader.hasNextLine())
			{
				String data = reader.nextLine();
				try
				{
					translations.put(data.split(";")[0], data.split(";")[1].trim());
				}
				catch (Exception e)
				{
					// Translation invalid
				}
			}
			reader.close();
		}
		// Prints an exception if language file isn't found
		catch (FileNotFoundException e)
		{
			System.out.println("An error occurred during language selection.");
			e.printStackTrace();
		}
	}

	/** Returns a string in the current language matching the input key */
	public static String getLine(String line)
	{
		if (translations.isEmpty())
		{
			setLanguage("english");
		}
		if (translations.get(line) == null)
		{
			return "MISSING TRANSLATION FOR: '"+line+"'";
		}
		return translations.get(line);
	}

	/** Returns a string array of all available languages */
	public static String[] getLanguages()
	{
		//Creates an array of all files in the languages directory
		File folder = new File("languages");
		File[] listOfFiles = folder.listFiles();
		assert listOfFiles != null;
		//Creates a list of all the file names
		String[] FileList = new String[listOfFiles.length];
		for (int i = 0; i < listOfFiles.length; i++)
		{
			File file = listOfFiles[i];
			FileList[i] = file.getName();
		}
		return FileList;
	}
}
