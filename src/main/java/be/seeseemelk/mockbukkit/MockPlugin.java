package be.seeseemelk.mockbukkit;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class MockPlugin extends JavaPlugin
{

	public MockPlugin()
	{
	}

	protected MockPlugin(@NotNull JavaPluginLoader loader, @NotNull PluginDescriptionFile description, @NotNull File dataFolder, @NotNull File file)
	{
		super(loader, description, dataFolder, file);
	}

}
