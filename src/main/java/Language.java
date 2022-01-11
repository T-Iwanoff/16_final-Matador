import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Language
{
	private static HashMap<String, String> m_translations = new HashMap<>();

	private Language()
	{
	}

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
					m_translations.put(data.split(":")[0], data.split(":")[1].trim());
				}
				catch (Exception e)
				{
					// no translation for the key
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
		if (m_translations.isEmpty())
		{
			setLanguage("english");
		}
		if (m_translations.get(line) == null)
		{
			return "MISSING TRANSLATION (" + line + ")";
		}
		return m_translations.get(line);
	}

	/** Returns a string array of all available languages */
	public static String[] getLanguages()
	{
		File folder = new File("languages");
		File[] listOfFiles = folder.listFiles();
		assert listOfFiles != null;
		String[] FileList = new String[listOfFiles.length];
		for (int i = 0; i < listOfFiles.length; i++)
		{
			File file = listOfFiles[i];
			FileList[i] = file.getName();
		}
		return FileList;
	}
}
