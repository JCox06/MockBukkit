package be.seeseemelk.mockbukkit.block.state;

import be.seeseemelk.mockbukkit.inventory.InventoryMock;
import be.seeseemelk.mockbukkit.inventory.LecternInventoryMock;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Lectern;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LecternMock extends ContainerMock implements Lectern
{

	private int currentPage;

	public LecternMock(@NotNull Material material)
	{
		super(material);
		checkType(material, Material.LECTERN);
	}

	protected LecternMock(@NotNull Block block)
	{
		super(block);
		checkType(block, Material.LECTERN);
	}

	protected LecternMock(@NotNull LecternMock state)
	{
		super(state);
		this.currentPage = state.currentPage;
	}

	@Override
	protected @NotNull InventoryMock createInventory()
	{
		return new LecternInventoryMock(this);
	}

	@Override
	public @NotNull BlockState getSnapshot()
	{
		return new LecternMock(this);
	}

	@Override
	public int getPage()
	{
		return this.currentPage;
	}

	@Override
	public void setPage(int page)
	{
		ItemStack book = getInventory().getItem(0);
		int maxPages = getMaxPages(book);

		this.currentPage = Math.min(Math.max(0, page), maxPages - 1);
	}

	private int getMaxPages(@Nullable ItemStack book)
	{
		if (book == null || !book.hasItemMeta())
		{
			return 1;
		}

		ItemMeta meta = book.getItemMeta();

		if (meta instanceof BookMeta)
		{
			return ((BookMeta) meta).getPageCount();
		}
		else
		{
			return 1;
		}
	}

}
